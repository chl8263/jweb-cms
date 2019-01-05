//package app.jweb.page.web.service.component;
//
//import app.jweb.page.web.AbstractPageComponent;
//import app.jweb.template.Attributes;
//import app.jweb.template.Children;
//import app.jweb.template.StringAttribute;
//import com.google.common.collect.Lists;
//
//import java.io.IOException;
//import java.io.OutputStream;
//import java.util.Map;
//
///**
// * @author chi
// */
//public class AuthorComponent extends AbstractPageComponent {
//    public AuthorComponent() {
//        super("author", "component/author/author.html", Lists.newArrayList(
//            new StringAttribute("title", null),
//            new StringAttribute("userId", null)));
//    }
//
//    @Override
//    public void output(Map<String, Object> bindings, Attributes attributes, Children children, OutputStream out) throws IOException {
//        bindings.putAll(attributes);
//        String userId = attributes.get("userId");
//        if (userId == null) {
//            userId = page(bindings).userId;
//        }
//        bindings.put("userId", userId);
//        template().output(bindings, out);
//    }
//}
