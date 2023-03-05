package com.springmvc.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class controller {

//    @RequestMapping(value = {"/"})
//    public String index(){
//
//        return "index";
//    }

    @GetMapping("/target")
    public String totarget(){

        return "target";
    }

    @PostMapping(value = "/test")
    public String totest(String username, HttpServletRequest request){

        request.setAttribute("ServletRequestApI", "ServletRequestApI Hello");

        System.out.println(username);

        return "test";
    }

    @GetMapping("/testModelAndView")
    public ModelAndView testModelAndView(){
        ModelAndView modelAndView =new ModelAndView();

        modelAndView.addObject("testModelAndView", "Hello testModelAndView");
        modelAndView.setViewName("test");

        return modelAndView;
    }

    @GetMapping("/testModel")
    public String testModel(Model model){

        model.addAttribute("testModel", "Hello testModel");
        return "test";
    }

    @GetMapping("/testHttpSession")
    public String testHttpSession(HttpSession session){
        session.setAttribute("testHttpSession", "Hello testHttpSession");

        return "test";
    }

    @GetMapping("/testApplication")
    public String testApplication(HttpServletRequest request){
        ServletContext app = request.getSession().getServletContext();

        app.setAttribute("testApplication", "Hello testApplication");

        return "test";
    }

    // 转发
    @GetMapping("/testForward")
    public String testForward(){

        return "forward:/testApplication";
    }

    // 重定向
    @GetMapping("/testRedirect")
    public String testRedirect(){

        return "redirect:/testApplication";
    }
}
