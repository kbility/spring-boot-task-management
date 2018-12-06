package com.mohbility.taskApp.repositories;

import com.mohbility.taskApp.entities.Task;
import com.mohbility.taskApp.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @project spring-boot-task-management
 * @author: kbility
 * @Date: 12/1/2018
 */
public interface TaskRepository extends JpaRepository<Task, Long> {

    List<Task> findByUser(User user);
}
