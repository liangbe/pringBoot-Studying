package com.bee.study.service.impl;

import com.bee.study.dao.UserDao;
import com.bee.study.entity.User;
import com.bee.study.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

/**
 * Created by liangbe on 2017/4/14.
 */
@Service
public class UserServiceImpl extends CRUDServiceImpl<User,Long> implements UserService{

    @Autowired
    UserDao userDao;

    @Override
    public JpaRepository getDao() {
        return userDao;
    }
}
