package com.stefanini.enhancedtaskmanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.io.File;
import java.util.List;

@SpringBootApplication
public class EnhancedTaskManagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(EnhancedTaskManagerApplication.class, args);

		System.out.println("Application was srarted successfully");

		UserService userService = new UserService();
		TaskService taskService = new TaskService();
		File newFile = new File("users.txt");
		switch (args[0]) {
			case "createUser":
				userService.addUser(new User(args[1], args[2], args[3], args[4]));
				break;
			case "showAllUsers": {
				if (newFile.length() != 0) {
					List<User> users = userService.showAllUsers();
					if (users != null) {
						for (User user : users) {
							System.out.println(user.toString());
						}
					}
				}
				else {
					System.out.println("User list is empty!");
				}
			} break;
			case "addTask": {
				if (newFile.length() != 0) {
					List<User> users = userService.showAllUsers();
					if (users != null) {
						taskService.addTask(args[1], args[2], args[3]);
					}
				}
				else {
					System.out.println("User list is empty!");
				}
			} break;
			case "showTasks":
				taskService.showTasks(args[1]);
				break;
			default:
				System.out.println("Non-existent method!");
		}
	}
}


