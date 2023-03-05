package com.springmvc.dao.impl;

import com.springmvc.dao.UserDao;
import com.springmvc.entity.User;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class UserDaoImpl implements UserDao {

    private static Map<Integer, User> map = null;

    static {
        map = new HashMap<>();

        map.put(1001, new User(1001, "AA", 12, "1"));
        map.put(1002, new User(1002, "BB", 13, "1"));
        map.put(1003, new User(1003, "CC", 14, "2"));
        map.put(1004, new User(1004, "DD", 15, "2"));
        map.put(1005, new User(1005, "EE", 5, "1"));
    }

    private static Integer intId = 1006;

    public void save(User user){
        if (user.getId() == null){
            user.setId(intId++);
        }
        map.put(user.getId(), user);
    }

    public Collection<User> getAll(){
        return map.values();
    }

    public User get(Integer id){
        return map.get(id);
    }

    public User delete(Integer id){
        return map.remove(id);
    }


}
