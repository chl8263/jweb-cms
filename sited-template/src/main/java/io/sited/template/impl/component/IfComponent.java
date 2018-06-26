package io.sited.template.impl.component;

import com.google.common.collect.Lists;
import io.sited.template.AbstractComponent;
import io.sited.template.Children;
import io.sited.template.ObjectAttribute;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Map;

/**
 * @author chi
 */
public class IfComponent extends AbstractComponent {
    public IfComponent() {
        super("if", Lists.newArrayList(new ObjectAttribute<>("condition", boolean.class, false)));
    }

    @Override
    public void output(Map<String, Object> bindings, Map<String, Object> attributes, Children children, OutputStream out) throws IOException {
        Boolean condition = (Boolean) attribute("condition").value(attributes);

        if (Boolean.TRUE.equals(condition)) {
            children.output(bindings, out);
        }
    }
}
