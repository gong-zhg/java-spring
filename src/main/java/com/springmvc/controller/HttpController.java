package com.springmvc.controller;

import com.springmvc.entity.User;
import org.springframework.http.RequestEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class HttpController {

    @PostMapping("/testRequestBody")
    public String testRequestBody(@RequestBody String re){
        System.out.println(re);
        return "test";
    }

    @PostMapping("/testRequestEntity")
    public String testRequestEntity(RequestEntity<String> requestEntity){
        System.out.println(requestEntity.getHeaders());
        System.out.println(requestEntity.getUrl());
        System.out.println(requestEntity.getBody());
        return "test";
    }

    @GetMapping("/testResponseBody")
    public String testResponse(HttpServletResponse response) throws IOException {
        response.getWriter().println("Hello word");
        return "test";
    }

    @GetMapping("/testResponseBody1")
    @ResponseBody
    public User testResponseBody() {
        return new User(12,"qwe",12,"1");
    }

    @PostMapping("/testajax")
    @ResponseBody
    public String testajax(String username, String password) {
        System.out.println(username + password);
        return "hello axja";
    }



}
