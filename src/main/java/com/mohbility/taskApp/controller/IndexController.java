package com.mohbility.taskApp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @project spring-boot-task-management
 * @author: kbility
 * @Date: 12/2/2018
 */
@Controller
public class IndexController {

    @GetMapping("/")
    public String showIndexPage(){
        return "index";
    }

    @GetMapping("/login")
    public String showLoginForm(){
        return "views/loginForm";
   }
}
