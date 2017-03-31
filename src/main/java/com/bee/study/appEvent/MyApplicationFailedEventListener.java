package com.bee.study.appEvent;

import org.springframework.boot.context.event.ApplicationFailedEvent;
import org.springframework.context.ApplicationListener;

/**
 * Created by liangbe on 2017/3/31.
 */
public class MyApplicationFailedEventListener implements ApplicationListener<ApplicationFailedEvent> {
//是启动异常
    @Override
    public void onApplicationEvent(ApplicationFailedEvent event) {
        Throwable throwable = event.getException();
        handleThrowable(throwable);
    }

    /*处理异常*/
    private void handleThrowable(Throwable throwable) {

        System.out.println("Failed ");
    }
}
