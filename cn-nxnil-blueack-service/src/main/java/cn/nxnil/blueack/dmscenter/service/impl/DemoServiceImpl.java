package cn.nxnil.blueack.dmscenter.service.impl;

import cn.nxnil.blueack.dmscenter.service.DemoService;
import org.springframework.stereotype.Service;

@Service
public class DemoServiceImpl implements DemoService {
    @Override
    public String demo(String demo) throws Exception {
        return "hello " + demo;
    }
}
