package cn.nxnil.blueack.dmscenter.task;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 */
public class Launcher {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:application-context.xml");
        ctx.start();
    }
}
