package com.example.captcha_example.service;

import com.example.captcha_example.entity.User;
import com.example.captcha_example.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * project: Captcha_Example
 * author: Sardor Urokov
 * created at 2:37 AM on 05/Dec/2022
 **/

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    @Override
    public void createUser(User user) {
        userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> getOneUser(Integer id) {
        return userRepository.findById(id);
    }
}
