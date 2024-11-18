package com.spring_security.demo.entity;

import jakarta.persistence.Id;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import jakarta.persistence.Entity;



@Entity
public class User {

    @Id
    private Integer id;

    private String userName;

    public Integer getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    private  String password;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
