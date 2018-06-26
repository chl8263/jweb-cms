package io.sited.template.impl;

import io.sited.template.Expression;

import java.util.Map;

/**
 * @author chi
 */
public interface TemplateModel {
    Object eval(int expressionId, Map<String, Object> bindings);

    Expression add(String expression, Expression defaultValue, Integer row, Integer col, String source);
}
