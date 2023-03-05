package com.springmvc.dao;

import com.springmvc.entity.User;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public interface UserDao {

    public void save(User user);
    public Collection<User> getAll();
    public User get(Integer id);
    public User delete(Integer id);

}
