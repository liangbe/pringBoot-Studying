package com.bee.study.dao;

import com.bee.study.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by liangbe on 2017/4/13.
 */
@Repository
public interface UserDao extends JpaRepository<User,Long>{
}
