package cn.nxnil.blueack.client.impl;

import cn.nxnil.blueack.client.DemoClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class DemoClientImpl implements DemoClient {
    @Override
    public String demo() {
        return "demo";
    }
}
