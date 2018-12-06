package com.mohbility.taskApp.repositories;

import com.mohbility.taskApp.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @project spring-boot-task-management
 * @author: kbility
 * @Date: 12/1/2018
 */
public interface RoleRepository extends JpaRepository<Role, String> {
}
