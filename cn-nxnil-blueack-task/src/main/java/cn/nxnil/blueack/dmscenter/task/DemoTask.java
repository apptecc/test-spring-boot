package cn.nxnil.blueack.dmscenter.task;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class DemoTask {

    @Scheduled(cron = "${dmscenter.promo.sync.all}")
    public void fetchFullProductPrice() {
        log.info("================全量DMS任务开始================");
    }
}
