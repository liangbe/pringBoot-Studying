package com.bee.study.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

/**
 * Created by liangbe on 2017/4/14.
 */
@Entity
@Table(name="hobby")

@JsonIgnoreProperties(value = "users")
public class Hobby {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="name",nullable = true)
    private String name;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy="hobbyList")
    private List<User> users;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> Users) {
        this.users = users;
    }
}
