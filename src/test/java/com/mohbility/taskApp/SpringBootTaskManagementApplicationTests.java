package com.mohbility.taskApp;

import com.mohbility.taskApp.entities.Task;
import com.mohbility.taskApp.entities.User;
import com.mohbility.taskApp.service.TaskService;
import com.mohbility.taskApp.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootTaskManagementApplicationTests {
    @Autowired
    private UserService userService;
    @Autowired
    private TaskService taskService;

    public SpringBootTaskManagementApplicationTests() {
    }

    @Before
    public void initDb() {
        {
            User newUser = new User("testUser@gmail.com", "testUser", "123456");
            userService.createUser(newUser);
        }
        {
            User newUser = new User("testAdmin@gmail.com", "testAdmin", "123456");
            userService.createAdmin(newUser);
        }

        Task userTask = new Task("03/01/2018", "00:11", "11:00", "You need to work today");
        Optional<User> user = userService.findOne("testUser@gmail.com");
        user.ifPresent(user1 -> taskService.addTask(userTask, user1));
    }

    @Test
    public void testUser(){
       Optional<User> user = userService.findOne("testUser@gmail.com");
       assertNotNull(user);

       Optional<User> admin = userService.findOne("testAdmin@gmail.com");
        admin.ifPresent(admin1 -> assertEquals(admin1.getEmail(), "testAdmin@gmail.com"));

    }

    @Test
    public void testTask(){
        Optional<User> user = userService.findOne("testUser@gmail.com");
        if(user.isPresent()) {
            List<Task> task = taskService.findUserTask(user.get());
            assertNotNull(task);
        }
    }
}
