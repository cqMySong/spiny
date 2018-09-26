package com.gioov.spiny.common.logback.entity;

import java.io.Serializable;

/**
 * @author godcheese
 * @date 2018-02-22
 */
public class LoggingEventPropertyEntity implements Serializable {

    private static final long serialVersionUID = 8201766168092551544L;

    private Long eventId;
    private String mappedKey;
    private String mappedValue;

    public Long getEventId() {
        return eventId;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }

    public String getMappedKey() {
        return mappedKey;
    }

    public void setMappedKey(String mappedKey) {
        this.mappedKey = mappedKey;
    }

    public String getMappedValue() {
        return mappedValue;
    }

    public void setMappedValue(String mappedValue) {
        this.mappedValue = mappedValue;
    }
}
