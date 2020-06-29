package com.movie.crawling.controller;

import org.jasypt.encryption.StringEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/test2")
public class StudyController {

    @Autowired
    StringEncryptor stringEncryptor;

    public void Test(){
        String result = stringEncryptor.encrypt("yourpassword");
        System.out.println("==================");
        System.out.println(result);
        System.out.println("==================");
    }
}
