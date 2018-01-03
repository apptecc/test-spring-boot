package cn.nxnil.blueack.facade;

import cn.nxnil.blueack.common.enums.BizError;
import cn.nxnil.blueack.common.response.CommonResultResponse;
import cn.nxnil.blueack.dmscenter.service.DemoService;
import cn.nxnil.blueack.facade.stub.DemoFacade;
import com.alibaba.dubbo.config.annotation.Service;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@Service
@RestController
public class DemoFacadeImpl implements DemoFacade {
    @Autowired
    private DemoService demoService;

    @Override
    public CommonResultResponse<String> syncAll() {
        log.info("================全量DMS任务开始================");
        try {
            System.out.println(demoService.demo("demo"));
            return CommonResultResponse.buildSuccResponse(demoService.demo("demo"));
        } catch (Exception e) {
            return CommonResultResponse.buildFailResponse(BizError.REQUEST_ERROR);
        }
    }
}
