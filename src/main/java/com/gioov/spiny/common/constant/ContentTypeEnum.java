package com.gioov.spiny.common.constant;

/**
 * @author godcheese
 * @date 2018-02-22
 */
public enum ContentTypeEnum {
    /**
     * application/json
     */
    APPLICATION_JSON("application/json", new String[]{".json"}),

    /**
     * text/plain
     */
    TEXT_PLAIN("text/plain", new String[]{".txt"}),

    /**
     * text/html
     */
    TEXT_HTML("text/html", new String[]{".html", ".htm"});

    public static class Produces {
        public static final String APPLICATION_JSON = "application/json";
        public static final String TEXT_HTML = "text/html";
    }

    public String mimeType;
    public String[] fileExtension;

    ContentTypeEnum(String mimeType, String[] fileExtension) {
        this.mimeType = mimeType;
        this.fileExtension = fileExtension;
    }

    public String getMimeType() {
        return mimeType;
    }

    public void setMimeType(String mimeType) {
        this.mimeType = mimeType;
    }

    public String[] getFileExtension() {
        return fileExtension;
    }

    public void setFileExtension(String[] fileExtension) {
        this.fileExtension = fileExtension;
    }
}
