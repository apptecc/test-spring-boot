package cn.nxnil.blueack.common.exception;

import cn.nxnil.blueack.common.enums.ReturnCodeEnum;
import cn.nxnil.blueack.common.response.CommonResultResponse;
import lombok.extern.slf4j.Slf4j;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * 全局异常统一处理
 * 捕获自定义异常
 * 不期望的异常打ERROR日志（Provider端）
 * 不期望的日志即是，没有的接口上声明的Unchecked异常。
 * 异常不在API包中，则Wrap一层RuntimeException。
 * RPC对于第一层异常会直接序列化传输(Cause异常会String化)，避免异常在Client出不能反序列化问题。
 * Created by lumian on 2017/5/11.
 */
@Provider
@Slf4j
public class ApplicationExceptionHandler implements ExceptionMapper<Exception> {
    @Override
    public Response toResponse(Exception e) {
        //CommonResultResponse response = new CommonResultResponse<String>(UserCenterErrorCode.SYSTEM_ERROR.getCode(), UserCenterErrorCode.SYSTEM_ERROR.getMessage(), null);
        CommonResultResponse response = CommonResultResponse.buildResponse(ReturnCodeEnum.SYSTEM_ERROR.getCode(), ReturnCodeEnum.SYSTEM_ERROR.getMessage(), null);

        if (e instanceof InventoryCenterException) {
            InventoryCenterException ue = (InventoryCenterException) e;
            //response = new CommonResultResponse<String>(null, ue.getCode(), ue.getMessage());
            response = CommonResultResponse.buildResponse(ue.getCode(), ue.getMessage(), null);
        } else {
            log.error("error", e);
        }
        return Response.ok().entity(response).type("application/json; charset=UTF-8").build();
    }
}
