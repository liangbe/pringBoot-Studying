package com.bee.study.controller;

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

    @RequestMapping(value = "/{name}", method = RequestMethod.GET)
    public String sayWorld(@PathVariable("name") String name) {
        return "Hello " + name;
    }

//    已经在Util中的Application 实现了
//    public static void main(String[] args) throws Exception {
//
//
//        SpringApplication.run(SampleController.class, args);
//
//    }
}
