package cn.nxnil.blueack.common.utils;


import cn.nxnil.blueack.common.enums.BizError;
import cn.nxnil.blueack.common.exception.CommonException;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;

import java.util.Objects;

@Slf4j
public class HttpResponseCheckUtils {
    public static void check(HttpResponse httpResponse) {
        if (Objects.isNull(httpResponse)) {
            log.error("client 调用失败， message: {} ", "httpResponse 为空");
            throw new CommonException(BizError.HTTP_RESPONSE_NULL);
        }
        if (HttpStatus.SC_OK != httpResponse.getStatusLine().getStatusCode()) {
            log.error("client 调用失败, error http code : {} ", httpResponse.getStatusLine().getStatusCode());
            throw new CommonException(BizError.HTTP_RESPONSE_CODE_NOT_OK);
        }
    }
}
