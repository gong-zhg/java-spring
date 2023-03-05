package com.springmvc.controller;

import com.springmvc.dao.UserDao;
import com.springmvc.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collection;

@Controller
public class UserController {

    @Autowired
    private UserDao userDao;

    /**
     * 使用RESTFul模拟用户资源的增删改查
     * user GET 查询用户信息
     * user/id GET 根据id查询用户信息
     * user post  添加用户
     * user/id delete 删除用户信息
     * user put  修改用户信息
     */
    @GetMapping("/getUser")
    public ModelAndView getAllUser(){
        ModelAndView modelAndView = new ModelAndView();
        Collection<User> userController= userDao.getAll();

        modelAndView.addObject("userController", userController);
        modelAndView.setViewName("test-resuful");

        return modelAndView;
    }

    @GetMapping("/GetUserId/{id}")
    public ModelAndView getUserId(@PathVariable("id")int id){
        ModelAndView modelAndView = new ModelAndView();
        System.out.println(id);
        User user = userDao.get(id);

        modelAndView.addObject("user", user);
        modelAndView.setViewName("test-update");

        return modelAndView;
    }

    @PostMapping("/addUser")
    public ModelAndView addUser(User user){
        ModelAndView modelAndView = new ModelAndView();
        userDao.save(user);

        modelAndView.addObject("reuslt","添加成功");
        modelAndView.setViewName("redirect:/getUser");

        return modelAndView;
    }

    @PutMapping("/updateUser")
    public ModelAndView updateUser(User user){
        ModelAndView modelAndView = new ModelAndView();
        userDao.save(user);

        modelAndView.addObject("reuslt","修改成功");
        modelAndView.setViewName("redirect:/getUser");

        return modelAndView;
    }

    @DeleteMapping("/deleteUser/{id}")
    public ModelAndView deleteUser(@PathVariable("id")Integer id){
        ModelAndView modelAndView = new ModelAndView();
        userDao.delete(id);
        modelAndView.addObject("reuslt","修改成功");
        modelAndView.setViewName("redirect:/getUser");

        return modelAndView;
    }
}
