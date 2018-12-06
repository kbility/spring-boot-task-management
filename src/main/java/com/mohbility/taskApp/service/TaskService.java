package com.mohbility.taskApp.service;

import com.mohbility.taskApp.entities.Task;
import com.mohbility.taskApp.entities.User;
import com.mohbility.taskApp.repositories.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @project spring-boot-task-management
 * @author: kbility
 * @Date: 12/2/2018
 */
@Service
public class TaskService {

    private TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public void addTask(Task task, User user){
        task.setUser(user);
        taskRepository.save(task);
    }

    public List<Task> findUserTask(User user){
        return taskRepository.findByUser(user);
    }
}
