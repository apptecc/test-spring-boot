package cn.nxnil.blueack.common.protocol;

import org.springframework.web.context.ContextLoaderListener;

/**
 * 定制容器加载
 * 设置dubbo使用slf4j来记录日志
 */
@SuppressWarnings("unused")
public class CustomContextLoaderListener extends ContextLoaderListener {
    static {
        System.setProperty("dubbo.application.logger", "slf4j");
    }
}
