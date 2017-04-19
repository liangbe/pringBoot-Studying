package com.bee.study.controller.api;

import com.bee.study.entity.User;
import com.bee.study.service.UserService;
import com.bee.study.util.ResponseEntityDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Created by liangbe on 2017/3/31.
 */


@RestController
@RequestMapping("/api/user")
public class SampleController {


    @Autowired
    UserService userService;

    @RequestMapping( method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<?> sayWorld() {
        List<User> entities=userService.findAll();
        return new ResponseEntity<Object>(new ResponseEntityDto(entities), HttpStatus.OK);
    }
}
