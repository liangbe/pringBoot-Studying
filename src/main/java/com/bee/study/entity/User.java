package com.bee.study.entity;

import javax.persistence.*;
import java.util.List;

/**
 * Created by liangbe on 2017/4/13.
 */
@Entity
@Table(name="user_info")
//@SequenceGenerator(name="user_id_seq" ,sequenceName = "user_seq",allocationSize = 1)
public class User {

    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO,generator = "user_id_seq")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="age")
    private int age;

    @Column(length = 30,name="name")
    private  String name;

    @Column(length = 30,name="first_name")
    private  String firstName;

    @ManyToOne(fetch=FetchType.LAZY,cascade={CascadeType.PERSIST,CascadeType.MERGE,
            CascadeType.REFRESH})
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Address address;

    @OneToMany(fetch=FetchType.EAGER,cascade={CascadeType.PERSIST,CascadeType.MERGE,
            CascadeType.REFRESH})
    @JoinColumn(name = "id")
    private List<Education> educationList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Education> getEducationList() {
        return educationList;
    }

    public void setEducationList(List<Education> educationList) {
        this.educationList = educationList;
    }
}
