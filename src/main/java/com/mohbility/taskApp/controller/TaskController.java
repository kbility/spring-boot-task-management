package com.mohbility.taskApp.controller;

import com.mohbility.taskApp.entities.Task;
import com.mohbility.taskApp.service.TaskService;
import com.mohbility.taskApp.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

/**
 * @project spring-boot-task-management
 * @author: kbility
 * @Date: 12/2/2018
 */
@Controller
public class TaskController {

    private TaskService taskService;
    private UserService userService;

    public TaskController(TaskService taskService, UserService userService) {
        this.taskService = taskService;
        this.userService = userService;
    }

    @GetMapping("/addTask")
    public String taskForm(String email, Model model, HttpSession session){

        session.setAttribute("email", email);
        model.addAttribute("task", new Task());
        return "views/taskForm";
    }

    @PostMapping("/addTask")
    public String addTask(@Valid Task task, BindingResult bindingResult, HttpSession session){
        if(bindingResult.hasErrors()){
            System.out.println("There is an error");

            return "views/taskForm";
        }

        String email = (String) session.getAttribute("email");

        taskService.addTask(task, userService.findOne(email).get());
        System.out.println("this is a "+task);

        return "redirect:/users";

    }
}
