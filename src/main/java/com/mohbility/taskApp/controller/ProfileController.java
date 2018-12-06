package com.mohbility.taskApp.controller;

import com.mohbility.taskApp.entities.User;
import com.mohbility.taskApp.service.TaskService;
import com.mohbility.taskApp.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;
import java.util.Optional;

/**
 * @project spring-boot-task-management
 * @author: kbility
 * @Date: 12/2/2018
 */
@Controller
public class ProfileController {

    private TaskService taskService;
    private UserService userService;

    public ProfileController(TaskService taskService, UserService userService) {
        this.taskService = taskService;
        this.userService = userService;
    }

    @GetMapping("/profile")
    public String showProfilePage(Model model, Principal principal){
        String email = principal.getName();
        Optional<User> user = userService.findOne(email);

        user.ifPresent(user1 -> model.addAttribute("tasks", taskService.findUserTask(user1)));

        return "views/profile";
    }
}
