package io.sited.page.web;

import com.google.common.collect.Maps;
import io.sited.page.api.page.PageResponse;
import io.sited.page.web.service.CachedTemplateService;
import io.sited.page.web.service.CachedVariableService;
import io.sited.web.AbstractWebController;
import io.sited.web.Template;

import javax.inject.Inject;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Map;

/**
 * @author chi
 */
public abstract class AbstractPageWebController extends AbstractWebController {
    @Inject
    CachedTemplateService templateService;

    @Inject
    CachedVariableService variableService;

    protected Response page(PageResponse page, Map<String, Object> bindings) {
        Map<String, Object> variables = variableService.variables();
        Map<String, Object> templateBindings = Maps.newHashMapWithExpectedSize(bindings.size() + variables.size() + 6);
        templateBindings.putAll(bindings);
        templateBindings.putAll(variables);
        templateBindings.put("app", appInfo);
        templateBindings.put("request", requestInfo);
        templateBindings.put("client", clientInfo);
        templateBindings.put("user", userInfo);
        templateBindings.put("page", page);
        templateBindings.put("template", templateService.template(page.templatePath));
        return Response.ok(Template.of(page.templatePath, templateBindings)).type(MediaType.TEXT_HTML).build();
    }
}
