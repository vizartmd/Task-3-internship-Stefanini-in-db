package com.stefanini.enhancedtaskmanager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class TaskService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    TaskRepository taskRepository;

    public void addTask(String userName, String taskTitle, String taskDescription) {
        List<User> users = userRepository.findAll();
        List<Task> tasks = null;
        for (User user : users) {
            if (user.getUserName().equals(userName)) {
                if (user.getTasks() == null) {
                    tasks = new ArrayList<>();
                    tasks.add(new Task(userName, taskTitle, taskDescription));
                    userRepository.save(user);
                } else {
                    tasks = user.getTasks();
                    tasks.add(new Task(userName, taskTitle, taskDescription));
                    userRepository.save(user);
                }
            }
        }
    }

    public void showTasks(String userName) {
        List<Task> tasks = taskRepository.findAll();
        for (Task task : tasks) {
            if (task.getUserName().equals(userName)) {
                System.out.println(task.toString());
            }
        }
    }
}
