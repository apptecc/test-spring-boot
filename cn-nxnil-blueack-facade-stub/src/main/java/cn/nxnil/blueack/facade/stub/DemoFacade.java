package cn.nxnil.blueack.facade.stub;

import cn.nxnil.blueack.common.response.CommonResultResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public interface DemoFacade {

    @RequestMapping(value = "/syncAll", method = RequestMethod.GET)
    CommonResultResponse<String> syncAll();

}
