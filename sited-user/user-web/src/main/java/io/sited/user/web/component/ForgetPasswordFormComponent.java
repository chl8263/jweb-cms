package io.sited.user.web.component;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import io.sited.template.Children;
import io.sited.template.TemplateComponent;
import io.sited.user.web.UserWebOptions;

import javax.inject.Inject;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Map;

/**
 * @author chi
 */
public class ForgetPasswordFormComponent extends TemplateComponent {
    @Inject
    UserWebOptions userWebOptions;

    public ForgetPasswordFormComponent() {
        super("forget-password-form", "component/forget-password-form/forget-password-form.html", Lists.newArrayList());
    }

    @Override
    public void output(Map<String, Object> bindings, Map<String, Object> attributes, Children children, OutputStream out) throws IOException {
        Map<String, Object> scopedBindings = Maps.newHashMap();
        scopedBindings.put("userNameStrategy", userWebOptions.usernameStrategy);
        scopedBindings.putAll(bindings);
        template().output(scopedBindings, out);
    }
}
