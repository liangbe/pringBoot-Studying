package com.bee.study.controller;

import com.bee.study.config.UserConfig;
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


    @Autowired
    UserConfig user;

    @RequestMapping(value = "/{name}", method = RequestMethod.GET)
    public String sayWorld(@PathVariable("name") String name) {
        System.out.println("userName:" + user.getName());
        System.out.println("age:" + user.getAge());
        System.out.println("address:" + user.getAddress());
        return user.getRemark()+ " and "+name;
    }
}
