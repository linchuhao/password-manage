package com.example.demo.service;

import com.example.demo.dto.UserDTO;
import com.example.demo.entity.User;
import java.util.List;

public interface UserService {

    String login(User user);

    String register(User user);

    String changePassword(UserDTO user);

    List<User> getAllUsers();
}
