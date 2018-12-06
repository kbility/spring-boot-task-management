package com.mohbility.taskApp.controller;

import com.mohbility.taskApp.entities.User;
import com.mohbility.taskApp.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

/**
 * @project spring-boot-task-management
 * @author: kbility
 * @Date: 12/2/2018
 */
@Controller
public class RegisterController {

    private UserService userService;

    public RegisterController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/register")
    public String registerForm(Model model){
        model.addAttribute("user", new User());
        return "views/registerForm";
    }

    @PostMapping("/register")
    public String registerUser(@Valid User user, BindingResult bindingResult, Model model){

        if(bindingResult.hasErrors()){
            return "views/registerForm";
        }

        if(userService.isUserPresent(user.getEmail())){
            model.addAttribute("exist", true);
            return "views/registerForm";
        }
        userService.createUser(user);

        return "views/success";
    }
}
