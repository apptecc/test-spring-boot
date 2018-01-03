package cn.nxnil.blueack.common.response;

import cn.nxnil.blueack.common.enums.ExceptionEnum;
import cn.nxnil.blueack.common.exception.CommonException;

import java.io.Serializable;

public class CommonResultResponse<T> extends CommonResponse implements Serializable {
    private static final long serialVersionUID = 2523377728598055414L;
    private T result;

    private CommonResultResponse() {
    }

    public static <T> CommonResultResponse<T> buildSuccResponse(T result) {
        CommonResultResponse<T> response = new CommonResultResponse();
        response.setCode(ResponseCode.SUCCESS);
        response.setMessage(ResponseCode.SYS_SUCC_MSG);
        response.setResult(result);
        return response;
    }

    public static <T> CommonResultResponse<T> buildFailResponse(ExceptionEnum error) {
        CommonResultResponse<T> response = new CommonResultResponse();
        response.setCode(error.getCode());
        response.setMessage(error.getDesc());
        return response;
    }

    public static <T> CommonResultResponse<T> buildFailResponse(ExceptionEnum error, T result) {
        CommonResultResponse<T> response = new CommonResultResponse();
        response.setCode(error.getCode());
        response.setMessage(error.getDesc());
        response.setResult(result);
        return response;
    }

    public static <T> CommonResultResponse<T> buildResponse(int code, String message, T result) {
        CommonResultResponse<T> response = new CommonResultResponse();
        response.setCode(code);
        response.setMessage(message);
        response.setResult(result);
        return response;
    }

    public static <T> CommonResultResponse<T> buildFailResponse(int code, String message) {
        CommonResultResponse<T> response = new CommonResultResponse();
        response.setCode(code);
        response.setMessage(message);
        return response;
    }

    public static <T> CommonResultResponse<T> buildFailResponse(CommonException e) {
        CommonResultResponse<T> response = new CommonResultResponse();
        response.setCode(e.getCode());
        response.setMessage(e.getMessage());
        return response;
    }

    public static <T> CommonResultResponse<T> buildFailResponse() {
        CommonResultResponse<T> response = new CommonResultResponse();
        response.setCode(ResponseCode.SERVER_ERROR);
        response.setMessage(ResponseCode.SYS_ERROR_MSG);
        return response;
    }

    public void setResult(T result) {
        this.result = result;
    }

    public T getResult() {
        return this.result;
    }
}