package com.springmvc.entity;


public class User {

    private Integer id;
    private String name;
    private Integer age;
    private String status;

    public User() {

    }

    public User(Integer id, String name, Integer age, String status) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
