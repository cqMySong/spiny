package com.gioov.spiny.common.property;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author godcheese
 * @date 2018-02-22
 */
@ConfigurationProperties(prefix = "app"
//        ignoreInvalidFields = true)
)
@Component
public class AppProperties {

    private String name;
    private String secret;
    private String url;
    private List<String> systemAdminRole;

    private boolean debug = false;
    private String defaultTimeZone = "GMT+8";
    private String defaultDateFormat = "yyyy-MM-dd HH:mm:ss";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public boolean getDebug() {
        return debug;
    }

    public void setDebug(boolean debug) {
        this.debug = debug;
    }

    public String getDefaultTimeZone() {
        return defaultTimeZone;
    }

    public void setDefaultTimeZone(String defaultTimeZone) {
        this.defaultTimeZone = defaultTimeZone;
    }

    public String getDefaultDateFormat() {
        return defaultDateFormat;
    }

    public void setDefaultDateFormat(String defaultDateFormat) {
        this.defaultDateFormat = defaultDateFormat;
    }

    public List<String> getSystemAdminRole() {
        return systemAdminRole;
    }

    public void setSystemAdminRole(List<String> systemAdminRole) {
        this.systemAdminRole = systemAdminRole;
    }
}
