package com.gioov.spiny.common.property;

import com.gioov.common.util.StringUtil;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author godcheese
 * @date 2018-02-22
 */
@ConfigurationProperties(
        prefix = "app.servlet.multipart")
@Component
public class AppServletMultipartProperties {

    /**
     * .pdf,.txt,.bmp,.jpg,.gif
     */
    private String allowFileExtension = "*";

    /**
     * 附件上传分类 /upload/
     */
    private String uploadDirectory = "/upload/";


    public List<String> getAllowFileExtension() {
        return StringUtil.splitAsList(allowFileExtension, ",");
    }

    public void setAllowFileExtension(String allowFileExtension) {
        this.allowFileExtension = allowFileExtension;
    }

    public String getUploadDirectory() {
        return uploadDirectory;
    }

    public void setUploadDirectory(String uploadDirectory) {
        this.uploadDirectory = uploadDirectory;
    }

}
