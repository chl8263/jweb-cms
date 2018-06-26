package io.sited.page.api.comment;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

/**
 * @author chi
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class CommentDeletedMessage {
    @XmlElement(name = "pageId")
    public String pageId;
    @XmlElement(name = "commentId")
    public String commentId;
}
