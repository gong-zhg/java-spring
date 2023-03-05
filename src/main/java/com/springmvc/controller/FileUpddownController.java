package com.springmvc.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.util.UUID;

@Controller
public class FileUpddownController {

    @GetMapping("/testDown")
    public ResponseEntity<byte[]> testDown(HttpSession session) throws IOException {
        //获取ServletContext对象
        ServletContext servletContext = session.getServletContext();
        //获取服务器中文件的真交路径
        String realpath = servletContext.getRealPath("/static/img/539.jpg");
        //创建输入流
        InputStream is = new FileInputStream(realpath);
        //创建字节数组
        byte[] bytes = new byte[is.available()];
        //将流读到字节数组中
        is.read(bytes);
        //创建HttpHeaders对象设置响应头信息
        MultiValueMap<String, String> headers = new HttpHeaders();
        //设置要下载方式以及下载文件的名字
        headers.add("Content-Disposition", "attachment;filename=539.jpg");
        //设置响应状杰码
        HttpStatus status = HttpStatus.OK;
        //创建ResponseEntity对象
        ResponseEntity<byte[]> responseEntity = new ResponseEntity<>(bytes, headers, status);
        //关团输入流
        is.close();
        return  responseEntity;
    }

    @PostMapping("/testUpload")
    public String testUpload(MultipartFile photo, HttpSession session) throws IOException {
        // 获取文件名
        String filename = photo.getOriginalFilename();
        // 获取上传文件的后缀名
        String suffixName = filename.substring(filename.lastIndexOf("."));
        // 将UUID作为文件名
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        // UUID作为文件名 + 上传文件的后缀名
        filename = uuid + suffixName;
        //获取ServletContext对象
        ServletContext servletContext = session.getServletContext();
        //获取服务器中文件的真交路径
        String realpath = servletContext.getRealPath("photo");
        // 文件路径
        File file =new File(realpath);
        // 判断realpath所对应路径是否存在
        if(!file.exists()){
            // 若不存在，创建目录
            file.mkdir();
        }
        // 文件最终路径（文件路径+文件分隔符+文件名）
        String finalPath = realpath + File.separator + filename;
        // 文件上传
        photo.transferTo(new File(finalPath));
        return "test";
    }


}
