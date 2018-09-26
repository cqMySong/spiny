package com.gioov.spiny.system.entity;

import java.io.Serializable;

/**
 * @author godcheese
 * @date 2018-02-22
 */
public class EmailAttachmentEntity implements Serializable {

    private static final long serialVersionUID = 6605144566371734278L;

    private Long id;
    private Long emailId;
    private Long attachmentId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getEmailId() {
        return emailId;
    }

    public void setEmailId(Long emailId) {
        this.emailId = emailId;
    }

    public Long getAttachmentId() {
        return attachmentId;
    }

    public void setAttachmentId(Long attachmentId) {
        this.attachmentId = attachmentId;
    }
}
