package cn.nxnil.blueack.common.enums;

import lombok.AllArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@AllArgsConstructor
public enum BizError implements ExceptionEnum {
    OUT_OF_DATE(501060, "数据版本被覆盖，过期"),
    HTTP_RESPONSE_NULL(501061, "HTTP 调用返回为空"),
    HTTP_RESPONSE_CODE_NOT_OK(501062, "HTTP 调用返回码异常"),
    REQUEST_NULL(501063, "请求体为空"),
    REQUEST_ERROR(501064, "请求参数不正确"),
    LAST_SERIAL_ID_ERROR(501065, "偏移量不正确"),
    SYSTEM_ERR(501066, "系统异常"),
    LOCATION_CODE_EMPTY_ERROR(501067, "地点编码不能为空"),
    PRODUCT_CODE_EMPTY_ERROR(501068, "商品编码不能为空"),
    PARAM_EMPTY(501069, "参数为空"),
    SYNC_ALL_ERR(501070, "全量任务失败"),;
    public static Map<Integer, String> errorMap;

    static {
        errorMap = new HashMap<>();
        for (BizError item : BizError.values()) {
            errorMap.put(item.getCode(), item.getDesc());
        }
    }

    public int code;
    public String desc;

    public static String getValue(int err_code) {
        return errorMap.get(err_code);
    }

    @Override
    public int getCode() {
        return code;
    }

    @Override
    public String getDesc() {
        return desc;
    }
}
