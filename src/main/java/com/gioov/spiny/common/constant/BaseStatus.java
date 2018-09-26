package com.gioov.spiny.common.constant;

import com.gioov.common.web.http.BaseResponse;

/**
 * @author godcheese
 * @date 2018-02-22
 */
public class BaseStatus {

    public enum CustomStatus implements BaseResponse.BaseStatus {

        /**
         * 未知错误
         */
        UNKNOWN(0, "Unknown"),

        OK(200, "Ok"),
        BAD_REQUEST(400, "Bad Request"),
        UNAUTHORIZED(401, "Unauthorized"),
        FORBIDDEN(403, "Forbidden"),
        NOT_FOUND(404, "Not found"),
        INTERNAL_SERVER_ERROR(500, "Internal Server Error"),
        ;

        private int code;
        private String message;

        CustomStatus(int code, String message) {
            this.code = code;
            this.message = message;
        }

        @Override
        public int getCode() {
            return this.code;
        }

        @Override
        public String getMessage() {
            return this.message;
        }

        public static BaseResponse.BaseStatus valueOf(int code) {
            for (BaseResponse.BaseStatus status : values()) {
                if (status.getCode() == code) {
                    return status;
                }
            }
            throw new IllegalArgumentException("No matching constant for [" + code + "]");
        }
    }

}
