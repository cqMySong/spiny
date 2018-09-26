package com.gioov.spiny.common.annotation.operationlog;

/**
 * @author godcheese
 * @date 2018-02-22
 */
public enum OperationLogTypeEnum {

    /**
     * 页面访问
     */
    PAGE(0),

    /**
     * API 调用
     */
    API(1),

    ;

    private int value;

    OperationLogTypeEnum(int value) {
        this.value = value;
    }

    public int value() {
        return this.value;
    }

}
