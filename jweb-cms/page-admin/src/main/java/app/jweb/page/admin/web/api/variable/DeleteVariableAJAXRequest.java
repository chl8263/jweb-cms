package app.jweb.page.admin.web.api.variable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import java.util.List;

/**
 * @author chi
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class DeleteVariableAJAXRequest {
    @XmlElement(name = "ids")
    public List<String> ids;
}