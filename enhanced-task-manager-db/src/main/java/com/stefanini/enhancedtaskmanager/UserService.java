package com.stefanini.enhancedtaskmanager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public void addUser(User user) {
        userRepository.save(user);
    }

    public List<User> showAllUsers() {
        List<User> list = userRepository.findAll();
        return list;
    }
}