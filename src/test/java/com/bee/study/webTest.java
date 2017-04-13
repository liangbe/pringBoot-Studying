package com.bee.study;

import com.bee.study.dao.AddressDao;
import com.bee.study.dao.UserDao;
import com.bee.study.entity.Address;
import com.bee.study.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by liangbe on 2017/4/12.
 */
@RunWith(SpringRunner.class)
/**写成这样要
 * package :application 跟test的package名一样(同一级)
 *
 */
@SpringBootTest
public class webTest {


    @Autowired
    private UserDao repository;

    @Autowired
    private AddressDao addressDao;

    @Test
    public void exampleTest() {
//        String body = "Hello World";
//        assertThat(body).isEqualTo("Hello World");

//        User userData = repository.findOne(2L);
//        Address address=new Address();
         Address address=addressDao.findOne(2L);

//        userData.setName("dingtian");
//        userData.setAge(20);
//        userData.setFirstName("Yan");
//        address.setId(1L);
//        address.setCountry("China");
//        address.setProvince("GD");
//        userData.setAddress(address);
//        User userNew=repository.save(userData);
//        assertThat(userNew.getName()).isEqualTo("dingtian");
//        assertThat(userNew.getAge()).isEqualTo(23);
//        assertThat(userNew.getFirstName()).isEqualTo("Yan");

        addressDao.delete(address);
    }
}
