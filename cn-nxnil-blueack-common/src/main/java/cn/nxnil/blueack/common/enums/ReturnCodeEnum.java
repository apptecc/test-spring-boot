package cn.nxnil.blueack.common.enums;

import lombok.Getter;

@Getter
public enum ReturnCodeEnum {

    SUCCESS(200000, "成功"),

    CONTENT_TYPE_ERROR(400000, "content type error"),
    SYSTEM_ERROR(500000, "系统错误，请稍后再试"),


    REMOTE_ERROR(700000, "远程服务错误!");

    private int code;
    private String message;

    ReturnCodeEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }


}
