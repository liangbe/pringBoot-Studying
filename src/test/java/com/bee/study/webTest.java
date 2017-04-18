package com.bee.study;

import com.bee.study.dao.AddressDao;
import com.bee.study.dao.EducationDao;
import com.bee.study.dao.HobbyDao;
import com.bee.study.dao.UserDao;
import com.bee.study.entity.Address;
import com.bee.study.entity.Education;
import com.bee.study.entity.Hobby;
import com.bee.study.entity.User;
import com.bee.study.service.UserService;
import com.bee.study.util.SearchDto;
import org.hibernate.Hibernate;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Service;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


import java.util.ArrayList;
import java.util.List;

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

    @Autowired
    private EducationDao educationDao;

    @Autowired
    private HobbyDao hobbyDao;

    @Autowired
    private UserService userService;


    @Test
    public void exampleTest() {
//        String body = "Hello World";
//        assertThat(body).isEqualTo("Hello World");

//        User userData = repository.findOne(1L);
//        Address address=new Address();
//         Address address=addressDao.findOne(2L);

//        userData.setName("dingtian");
//        userData.setAge(20);
//        userData.setFirstName("Yan");
//        address.setId(1L);
//        address.setCountry("China");
//        address.setProvince("GD");
//        userData.setAddress(address);
//        List<Education> educationList=userData.getEducationList();
//        Education bachelor=educationList.get(0);
//        educationList.add(bachelor);
//        bachelor.setName("college graduate");
//        bachelor.setDegree("bachelor");
//        userData.setEducationList(educationList);

//        User userNew=repository.save(userData);
//        assertThat(userNew.getName()).isEqualTo("liangbe");
//        assertThat(userNew.getAge()).isEqualTo(25);
//        assertThat(userNew.getAddress().getProvince()).isEqualTo("GD");

//        addressDao.delete(address);
    }

    @Test
    //加下面这个会解决：could not initialize proxy - no Session
    @Rollback(value = false)
    public void manyToManyTest() {
//        User userData = userService.findOne(1L);
        SearchDto searchDto=new SearchDto("firstName","LIKE","yan");
        SearchDto searchDto2=new SearchDto("age","GT",20);
        List<SearchDto> searchDtoList=new ArrayList<SearchDto>();
        searchDtoList.add(searchDto);
        searchDtoList.add(searchDto2);
        List<User> users = userService.findAll(searchDtoList);
        int num=0;
        for(User u:users){
            num++;
            System.out.println("Result :" +num);
        }
//        List<Hobby> hobbies=new ArrayList<Hobby>();
//        Hobby hobby1=new Hobby();
//        Hobby hobby2=hobbyDao.findOne(2L);
//        Hobby hobby3=hobbyDao.findOne(3L);
//        hobby1.setName("fencing");
//        hobbies.add(hobby1);
//        hobbies.add(hobby2);
//        hobbies.add(hobby3);
//        userData.setHobbyList(hobbies);
//        userData.setName("yingting23333");
//        User userUpdate=userService.save(userData);
//        assertThat(userUpdate.getName()).isEqualTo("yingting23333");
//        List<Hobby> hobbies=hobbyDao.findAll();
//        for(Hobby hobby:hobbies) {
//            List<User> users =hobby.getUsers();
//            System.out.println(hobby.getName() + " :");
//            for (User user : users) {
//                System.out.println(" " + user.getName());
//            }
//        }

    }

}
