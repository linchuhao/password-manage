package com.example.demo.service.impl;

import static org.springframework.util.ObjectUtils.isEmpty;

import com.example.demo.dto.UserDTO;
import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Resource
    private UserRepository userRepository;


    @Override
    public String login(User user) {
        User realUser = userRepository.findByUsername(user.getUsername());
        if (isEmpty(realUser)) {
            return "This user does not exist";
        }
        if (bCryptPasswordEncoder.matches(user.getPassword(), realUser.getPassword())) {
            return "success";
        }
        return "fail";
    }

    @Override
    public String register(User user) {
        if (exist(user)) {
            return "This user already exists.";
        }
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        User saveUser = userRepository.save(user);
        if (isEmpty(saveUser)) {
            return "fail";
        }
        return "success";
    }

    private boolean exist(User user) {
        return !isEmpty(userRepository.findByUsername(user.getUsername()));
    }

    @Override
    public String changePassword(UserDTO user) {
        User realUser = userRepository.findByUsername(user.getUsername());
        if (isEmpty(realUser)) {
            return "This user does not exist";
        }
        if (bCryptPasswordEncoder.matches(user.getOldPassword(), realUser.getPassword())) {
            if (bCryptPasswordEncoder.matches(user.getNewPassword(), realUser.getPassword())) {
                return "The new password cannot be the same as the old password";
            }
            realUser.setPassword(bCryptPasswordEncoder.encode(user.getNewPassword()));
            userRepository.save(realUser);
            return "success";
        }
        return "fail";
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
