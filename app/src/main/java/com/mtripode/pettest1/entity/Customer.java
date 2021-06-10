package com.mtripode.pettest1.entity;

import java.util.Date;
import java.util.Set;

public class Customer {
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    private String username;

    private String password;

    private String passwordConfirm;

    private Date userCreation;

    private Date userClose;

    private String name;

    private String lastName;

    private Date birthday;


    private String email;

    private String celphone1;

    private String celphone2;

    private String celphone3;

    private String sex;

    private boolean enable;

    private Set<Animal> animals;

    public Set<Animal> getAnimals() {
        return animals;
    }

    public void setAnimals(Set<Animal> animals) {
        this.animals = animals;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getPasswordConfirm() {
        return passwordConfirm;
    }

    public Date getUserCreation() {
        return userCreation;
    }

    public Date getUserClose() {
        return userClose;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public Date getBirthday() {
        return birthday;
    }

    public String getEmail() {
        return email;
    }

    public String getCelphone1() {
        return celphone1;
    }

    public String getCelphone2() {
        return celphone2;
    }

    public String getCelphone3() {
        return celphone3;
    }

    public String getSex() {
        return sex;
    }

    public boolean isEnable() {
        return enable;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }

    public void setUserCreation(Date userCreation) {
        this.userCreation = userCreation;
    }

    public void setUserClose(Date userClose) {
        this.userClose = userClose;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCelphone1(String celphone1) {
        this.celphone1 = celphone1;
    }

    public void setCelphone2(String celphone2) {
        this.celphone2 = celphone2;
    }

    public void setCelphone3(String celphone3) {
        this.celphone3 = celphone3;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }
}
