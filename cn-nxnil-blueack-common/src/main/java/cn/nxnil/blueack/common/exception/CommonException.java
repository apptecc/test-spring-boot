package cn.nxnil.blueack.common.exception;

import cn.nxnil.blueack.common.enums.ExceptionEnum;
import lombok.Data;

@Data
public class CommonException extends RuntimeException {
    public int code;
    public String message;

    public CommonException(int code, String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.code = code;
        this.message = message;
    }

    public CommonException(int code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
        this.message = message;
    }

    public CommonException(int code, String message) {
        super(message);
        this.code = code;
        this.message = message;
    }

    public CommonException(int code, Throwable cause) {
        super(cause);
        this.code = code;
        this.message = cause.getMessage();
    }

    public CommonException(ExceptionEnum error) {
        super(error.getDesc());
        this.code = error.getCode();
        this.message = error.getDesc();
    }
}