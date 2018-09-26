package com.gioov.spiny.common.logback.entity;

import java.io.Serializable;

/**
 * @author godcheese
 * @date 2018-02-22
 */
public class LoggingEventExceptionEntity implements Serializable {

    private static final long serialVersionUID = -4827595803650938598L;

    private Long eventId;
    private Integer i;
    private String traceLine;

    public Long getEventId() {
        return eventId;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }

    public Integer getI() {
        return i;
    }

    public void setI(Integer i) {
        this.i = i;
    }

    public String getTraceLine() {
        return traceLine;
    }

    public void setTraceLine(String traceLine) {
        this.traceLine = traceLine;
    }
}
