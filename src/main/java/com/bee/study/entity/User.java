package com.bee.study.entity;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liangbe on 2017/4/1.
 */
@Component
@ConfigurationProperties(prefix = "user")
public class User {


    @Value("${userName:lkl}")
    private String name;


    @Value("${age}")
    private Integer age;

    @Value("${remark}")
    private String remark;

    // 使用@ConfigurationProperties需要指定prefix,同时bean中的属性和配置参数名保持一致。
    private String  address;

    private List<Address> allAddress;

    private Address detailAddress;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Address getDetailAddress() {
        return detailAddress;
    }

    public void setDetailAddress(Address detailAddress) {
        this.detailAddress = detailAddress;
    }

    public List<Address> getAllAddress() {
        return allAddress;
    }

    public void setAllAddress(List<Address> allAddress) {
        this.allAddress = allAddress;
    }
}