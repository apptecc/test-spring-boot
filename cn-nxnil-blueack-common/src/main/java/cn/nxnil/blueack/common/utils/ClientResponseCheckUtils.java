package cn.nxnil.blueack.common.utils;
import cn.nxnil.blueack.common.enums.ExceptionEnum;
import cn.nxnil.blueack.common.exception.CommonException;
import cn.nxnil.blueack.common.response.CommonResultResponse;
import cn.nxnil.blueack.common.response.ResponseCode;
import lombok.extern.slf4j.Slf4j;

/**
 * client调用统一返回码解析
 */
@Slf4j
public class ClientResponseCheckUtils {

    @Deprecated
    public static <T> void check(CommonResultResponse<T> response, ExceptionEnum e) {
        if (response.getCode() != ResponseCode.SUCCESS) {
            log.error("client 调用失败 code: {}， message: {} ", response.getCode(), response.getMessage());
            throw new CommonException(e);
        }
    }

    public static <T> void check(CommonResultResponse<T> response) {
        if (response.getCode() != ResponseCode.SUCCESS) {
            log.error("client 调用失败 code: {}， message: {} ", response.getCode(), response.getMessage());
            throw new CommonException(response.getCode(), response.getMessage());
        }
    }
}
