package app.jweb.web.impl.controller;

import app.jweb.resource.Resource;
import app.jweb.web.AbstractWebController;
import app.jweb.web.NotFoundWebException;
import app.jweb.web.impl.SitemapService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.util.Optional;

/**
 * @author chi
 */
@Path("/sitemap.xml")
public class SitemapIndexController extends AbstractWebController {
    @Inject
    SitemapService sitemapService;

    @Inject
    UriInfo uriInfo;

    @GET
    public Response index() {
        String resourcePath = uriInfo.getPath();
        Optional<Resource> sitemap = sitemapService.sitemap(resourcePath);
        if (!sitemap.isPresent()) {
            sitemapService.build();
            sitemap = sitemapService.sitemap(resourcePath);
            if (!sitemap.isPresent()) {
                throw new NotFoundWebException(uriInfo.getPath());
            }
        }
        return Response.ok(sitemap.get())
            .type("text/xml").build();
    }
}
