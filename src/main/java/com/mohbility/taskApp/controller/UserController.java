package com.mohbility.taskApp.controller;

import com.mohbility.taskApp.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @project spring-boot-task-management
 * @author: kbility
 * @Date: 12/3/2018
 */
@Controller
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public String listUser(Model model, @RequestParam(defaultValue ="" ) String name){
             model.addAttribute("users", userService.findByName(name));
        return "views/list";
    }
}
