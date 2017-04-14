package com.bee.study.service.impl;

import com.bee.study.dao.UserDao;
import com.bee.study.entity.User;
import com.bee.study.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by liangbe on 2017/4/14.
 */
@Service
@Transactional
public class UserServiceImpl implements UserService{

    @Autowired
    UserDao userDao;

    @Override
    public User save(User user){
        User result=userDao.save(user);
        return result;
    }

    @Override
    public User findOne(Long id){
        User result=userDao.findOne(id);
        return result;
    }
}
