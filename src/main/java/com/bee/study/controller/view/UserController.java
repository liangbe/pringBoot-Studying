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

    @RequestMapping(value = "/User")
    public String  hello() {
        return  "index";
    }
}
