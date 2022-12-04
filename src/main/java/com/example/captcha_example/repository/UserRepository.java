package com.example.captcha_example.repository;

import com.example.captcha_example.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * project: Captcha_Example
 * author: Sardor Urokov
 * created at 2:36 AM on 05/Dec/2022
 **/

public interface UserRepository extends JpaRepository<User, Integer> {
}
