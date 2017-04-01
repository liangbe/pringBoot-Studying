package com.bee.study.controller;

import com.bee.study.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * Created by liangbe on 2017/3/31.
 */

//@Controller
//@EnableAutoConfiguration

@RestController
@RequestMapping("/springboot")
public class SampleController {


//    @RequestMapping("/")
////    @ResponseBody
//    public  String home() {
//
//        return "Hello Liangbe!";
//    }
    @Autowired
    User user;

    @RequestMapping(value = "/{name}", method = RequestMethod.GET)
    public String sayWorld(@PathVariable("name") String name) {
        System.out.println("userName:" + user.getName());
        System.out.println("age:" + user.getAge());
        System.out.println("address:" + user.getAddress());
        return user.getRemark();
    }

//    已经在Util中的Application 实现了
//    public static void main(String[] args) throws Exception {
//
//
//        SpringApplication.run(SampleController.class, args);
//
//    }
}
