package io.sited.user.web.service;

import io.sited.user.api.oauth.Provider;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import java.time.OffsetDateTime;

/**
 * @author chi
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class WeiboResponse implements OauthResponse {
    @XmlElement(name = "screen_name")
    public String screenName;
    @XmlElement(name = "name")
    public String name;
    @XmlElement(name = "created_at")
    public String createdAt;

    @Override
    public String username() {
        return screenName;
    }

    @Override
    public String email() {
        return null;
    }

    @Override
    public String phone() {
        return null;
    }

    @Override
    public Provider provider() {
        return Provider.WEIBO;
    }

    @Override
    public OffsetDateTime createdTime() {
        return null;
    }

    @Override
    public OffsetDateTime updatedTime() {
        return null;
    }
}
