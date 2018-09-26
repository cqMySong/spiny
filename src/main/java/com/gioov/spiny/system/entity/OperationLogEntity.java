package com.gioov.spiny.system.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @author godcheese
 * @date 2018-02-22
 */
public class OperationLogEntity implements Serializable {

    private static final long serialVersionUID = -6459234342558441198L;

    private Long id;

    /**
     * 操作用户 id
     */
    private Long userId;

    /**
     * 操作类型（0=页面访问，1=API 调用）
     */
    private Integer type;

    /**
     * 操作方法
     */
    private String methodName;

    /**
     * 操作内容
     */
    private String operation;

    /**
     * 创建时间
     */
    private Date gmtCreated;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public Date getGmtCreated() {
        return gmtCreated;
    }

    public void setGmtCreated(Date gmtCreated) {
        this.gmtCreated = gmtCreated;
    }
}
