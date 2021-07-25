package com.stefanini.enhancedtaskmanager;

import org.springframework.data.annotation.Id;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "task")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="task_id")
    private int task_id;

    @Column(name="user_name")
    private String userName;

    @Column(name="task_title")
    private String taskTitle;

    @Column(name="task_description")
    private String taskDescription;

    public Task() {
    }

    public Task(String userName, String taskTitle, String taskDescription) {
        this.userName = userName;
        this.taskTitle = taskTitle;
        this.taskDescription = taskDescription;
    }

    public Task(int task_id, String userName, String taskTitle, String taskDescription) {
        this.task_id = task_id;
        this.userName = userName;
        this.taskTitle = taskTitle;
        this.taskDescription = taskDescription;
    }

    public int getTask_id() {
        return task_id;
    }

    public void setTask_id(int task_id) {
        this.task_id = task_id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getTaskTitle() {
        return taskTitle;
    }

    public void setTaskTitle(String taskTitle) {
        this.taskTitle = taskTitle;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    @Override
    public String toString() {
        return "Task{" +
                "userName='" + userName + '\'' +
                ", taskTitle='" + taskTitle + '\'' +
                ", taskDescription='" + taskDescription + '\'' +
                '}';
    }
}

