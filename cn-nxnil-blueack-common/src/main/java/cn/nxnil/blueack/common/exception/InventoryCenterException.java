package cn.nxnil.blueack.common.exception;

import cn.nxnil.blueack.common.enums.ReturnCodeEnum;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class InventoryCenterException extends RuntimeException {

    private int code;
    private String message;

    public InventoryCenterException(ReturnCodeEnum errCode) {
        this.code = errCode.getCode();
        this.message = errCode.getMessage();
    }

}
