package io.sited.user.api.oauth;

import io.sited.user.api.user.UserResponse;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

/**
 * @author chi
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class OauthLoginResponse {
    @XmlElement(name = "user")
    public UserResponse user;
    @XmlElement(name = "autoLoginToken")
    public String autoLoginToken;
    @XmlElement(name = "bindNeeded")
    public Boolean bindNeeded;
}
