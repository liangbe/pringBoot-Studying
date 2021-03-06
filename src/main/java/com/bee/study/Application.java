package com.bee.study;

import com.bee.study.appEvent.MyApplicationFailedEventListener;
import com.bee.study.appEvent.MyApplicationPreparedEventListener;
import com.bee.study.appEvent.MyApplicationStartedEventListener;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by liangbe on 2017/3/31.
 */

//它只会扫同级包下的文件，不要问为什么。因为我花半个小时在这
@SpringBootApplication

//SpringBootApplication这个东西中的注解有东西，你看看
/*
@Configuration : 表示Application作为sprig配置文件存在
@EnableAutoConfiguration: 启动spring boot内置的自动配置
@ComponentScan : 扫描bean，路径为Application类所在package以及package下的子路径，
                   这里为 com.bee.study，在spring boot中bean都放置在该路径已经子路径下。
 */

public class Application {
    public static void main(String[] args) {
        //       ======== 加app 启动的监听器时 ============
        SpringApplication app = new SpringApplication(Application.class);
        app.addListeners(new MyApplicationStartedEventListener());
//        app.addListeners(new MyApplicationEnvironmentPreparedEventListener());
//        app.addListeners(new MyApplicationPreparedEventListener());
        app.setBannerMode(Banner.Mode.OFF);
//        app.addListeners(new MyApplicationFailedEventListener());
//       ======== 加app 启动的监听器时 ============

        app.run(args);
    }

}
