package com.mohbility.taskApp.service;

import com.mohbility.taskApp.entities.Role;
import com.mohbility.taskApp.entities.User;
import com.mohbility.taskApp.repositories.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @project spring-boot-task-management
 * @author: kbility
 * @Date: 12/2/2018
 */
@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void createUser(User user){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        user.setPassword(encoder.encode(user.getPassword()));

        Role userRole = new Role("USER");
        List<Role> roles = new ArrayList<>();
        roles.add(userRole);
        user.setRoles(roles);
        userRepository.save(user);
    }

    public void createAdmin(User user){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        user.setPassword(encoder.encode(user.getPassword()));

        Role userRole = new Role("ADMIN");
        List<Role> roles = new ArrayList<>();
        roles.add(userRole);
        user.setRoles(roles);
        userRepository.save(user);
    }

    public Optional<User> findOne(String email){
        return userRepository.findById(email);
    }

//    public User findByEmail(String email){
//        return userRepository.findByEmail(email);
//    }

    public boolean isUserPresent(String email){
        Optional<User> u = userRepository.findById(email);
        return u.isPresent();
    }

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public List<User> findByName(String name){
        return userRepository.findByNameLike("%" +name + "%");
    }

}
