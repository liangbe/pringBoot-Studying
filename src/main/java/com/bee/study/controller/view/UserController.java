package com.bee.study.controller.view;

import com.bee.study.entity.User;
import com.bee.study.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by liangbe on 2017/4/18.
 */

@Controller
public class UserController {

    @Autowired
    private  UserService userService;

    @RequestMapping(value = "/hello")
    public String  hello(Model model) {
        model.addAttribute("name", userService.findOne(1L).getName());
        return  "index";
    }
}
