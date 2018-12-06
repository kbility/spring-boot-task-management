package com.mohbility.taskApp.entities;

import javax.persistence.*;
import java.util.List;

/**
 * @project spring-boot-task-management
 * @author: kbility
 * @Date: 11/30/2018
 */

@Entity
public class Role {
    @Id
    @Column(length = 100)
    private String name;

    @ManyToMany(mappedBy = "roles")
    private List<User> users;

    public Role() {
    }

    public Role(String name) {
        this.name = name;
    }

    public Role(String name, List<User> users) {
        this.name = name;
        this.users = users;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
