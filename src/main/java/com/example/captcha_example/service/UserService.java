package com.example.captcha_example.service;

import com.example.captcha_example.entity.User;

import java.util.List;
import java.util.Optional;

/**
 * project: Captcha_Example
 * author: Sardor Urokov
 * created at 2:47 AM on 05/Dec/2022
 **/

public interface UserService {

    void createUser(User user);

    List<User> getAllUsers();

    Optional<User> getOneUser(Integer id);
}
