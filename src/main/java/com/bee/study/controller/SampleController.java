package com.bee.study.controller;

import com.bee.study.appEvent.MyApplicationEnvironmentPreparedEventListener;
import com.bee.study.appEvent.MyApplicationFailedEventListener;
import com.bee.study.appEvent.MyApplicationPreparedEventListener;
import com.bee.study.appEvent.MyApplicationStartedEventListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by liangbe on 2017/3/31.
 */

@Controller
@EnableAutoConfiguration
public class SampleController {


    @RequestMapping("/")
    @ResponseBody
    String home(HttpServletRequest request) {
        String userName = request.getParameter("username");
//        if (userName == null) userName = "";
        if (userName.equals("root")){
            System.out.println("2233 ");
        }
        return "Hello World!";
    }


    public static void main(String[] args) throws Exception {
//        SpringApplication.run(SampleController.class, args);

        SpringApplication app = new SpringApplication(SampleController.class);
        app.addListeners(new MyApplicationStartedEventListener());
//        app.addListeners(new MyApplicationEnvironmentPreparedEventListener());
//        app.addListeners(new MyApplicationPreparedEventListener());
        app.addListeners(new MyApplicationFailedEventListener());
        app.run(args);

    }
}
