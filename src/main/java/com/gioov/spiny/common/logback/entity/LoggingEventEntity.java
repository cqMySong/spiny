package com.gioov.spiny.common.logback.entity;

import java.io.Serializable;

/**
 * @author godcheese
 * @date 2018-02-22
 */
public class LoggingEventEntity implements Serializable {

    private static final long serialVersionUID = -7701190715011024824L;

    private Long eventId;
    private Long timestmp;
    private String threadName;
    private String levelString;
    private String loggerName;
    private String callerFilename;
    private String callerClass;
    private String callerMethod;
    private Integer callerLine;
    private String formattedMessage;
    private Integer referenceFlag;
    private String arg0;
    private String arg1;
    private String arg2;
    private String arg3;

    public Long getEventId() {
        return eventId;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }

    public Long getTimestmp() {
        return timestmp;
    }

    public void setTimestmp(Long timestmp) {
        this.timestmp = timestmp;
    }

    public String getThreadName() {
        return threadName;
    }

    public void setThreadName(String threadName) {
        this.threadName = threadName;
    }

    public String getLevelString() {
        return levelString;
    }

    public void setLevelString(String levelString) {
        this.levelString = levelString;
    }

    public String getLoggerName() {
        return loggerName;
    }

    public void setLoggerName(String loggerName) {
        this.loggerName = loggerName;
    }

    public String getCallerFilename() {
        return callerFilename;
    }

    public void setCallerFilename(String callerFilename) {
        this.callerFilename = callerFilename;
    }

    public String getCallerClass() {
        return callerClass;
    }

    public void setCallerClass(String callerClass) {
        this.callerClass = callerClass;
    }

    public String getCallerMethod() {
        return callerMethod;
    }

    public void setCallerMethod(String callerMethod) {
        this.callerMethod = callerMethod;
    }

    public Integer getCallerLine() {
        return callerLine;
    }

    public void setCallerLine(Integer callerLine) {
        this.callerLine = callerLine;
    }

    public String getFormattedMessage() {
        return formattedMessage;
    }

    public void setFormattedMessage(String formattedMessage) {
        this.formattedMessage = formattedMessage;
    }

    public Integer getReferenceFlag() {
        return referenceFlag;
    }

    public void setReferenceFlag(Integer referenceFlag) {
        this.referenceFlag = referenceFlag;
    }

    public String getArg0() {
        return arg0;
    }

    public void setArg0(String arg0) {
        this.arg0 = arg0;
    }

    public String getArg1() {
        return arg1;
    }

    public void setArg1(String arg1) {
        this.arg1 = arg1;
    }

    public String getArg2() {
        return arg2;
    }

    public void setArg2(String arg2) {
        this.arg2 = arg2;
    }

    public String getArg3() {
        return arg3;
    }

    public void setArg3(String arg3) {
        this.arg3 = arg3;
    }
}
