package io.sited.file.web.service;


import com.google.common.io.Files;
import io.sited.ApplicationException;
import io.sited.resource.Resource;
import org.imgscalr.Scalr;

import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import javax.imageio.stream.ImageOutputStream;
import javax.imageio.stream.MemoryCacheImageOutputStream;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Iterator;

/**
 * @author chi
 */
public class ImageScalarImpl implements ImageScalar {
    @Override
    public byte[] scale(Resource resource, ImageSize size) {
        try (InputStream inputStream = resource.openStream()) {
            BufferedImage image = ImageIO.read(inputStream);
            int targetHeight = size.height;
            int targetWidth = size.width;

            if (targetHeight == 0) {
                targetHeight = size.width * image.getHeight() / image.getWidth();
            }

            if (targetWidth == 0) {
                targetWidth = size.height * image.getWidth() / image.getHeight();
            }

            BufferedImage chopped = chop(image, targetWidth, targetHeight);
            BufferedImage resized = Scalr.resize(chopped, Scalr.Method.ULTRA_QUALITY, Scalr.Mode.FIT_EXACT,
                targetWidth, targetHeight, Scalr.OP_ANTIALIAS);

            String fileExtension = Files.getFileExtension(resource.path());
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            if (isJGP(fileExtension)) {
                writeJPG(resized, out, 0.75);
            } else {
                ImageIO.write(resized, fileExtension, out);
            }
            return out.toByteArray();
        } catch (IOException e) {
            throw new ApplicationException(e);
        }
    }

    private boolean isJGP(String fileExtension) {
        return "jpg".equals(fileExtension) || "jpeg".equals(fileExtension);
    }


    private BufferedImage chop(BufferedImage src, int targetWidth, int targetHeight) {
        if (isChopY(src.getHeight(), src.getWidth(), targetHeight, targetWidth)) {
            double rate = (double) targetHeight / targetWidth;
            int y = (int) (src.getWidth() * rate);
            return src.getSubimage(0, (src.getHeight() - y) / 2, src.getWidth(), y);
        } else {
            double rate = (double) targetWidth / targetHeight;
            int x = (int) (src.getHeight() * rate);
            return src.getSubimage((src.getWidth() - x) / 2, 0, x, src.getHeight());
        }
    }

    private boolean isChopY(int height, int width, int targetHeight, int targetWidth) {
        double srcRate = (double) height / width;
        double targetRate = (double) targetHeight / targetWidth;
        return srcRate > targetRate;
    }

    private void writeJPG(BufferedImage bufferedImage, OutputStream outputStream, double quality) throws IOException {
        Iterator<ImageWriter> iterator =
            ImageIO.getImageWritersByFormatName("jpg");
        ImageWriter imageWriter = iterator.next();
        ImageWriteParam imageWriteParam = imageWriter.getDefaultWriteParam();
        imageWriteParam.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
        imageWriteParam.setCompressionQuality((float) quality);
        ImageOutputStream imageOutputStream = new MemoryCacheImageOutputStream(outputStream);
        imageWriter.setOutput(imageOutputStream);
        IIOImage iioimage = new IIOImage(bufferedImage, null, null);
        imageWriter.write(null, iioimage, imageWriteParam);
        imageOutputStream.flush();
    }
}
