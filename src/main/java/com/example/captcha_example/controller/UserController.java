package com.example.captcha_example.controller;

import cn.apiclub.captcha.Captcha;
import com.example.captcha_example.entity.User;
import com.example.captcha_example.service.UserServiceImpl;
import com.example.captcha_example.util.CaptchaUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * project: Captcha_Example
 * author: Sardor Urokov
 * created at 2:35 AM on 05/Dec/2022
 **/

@Controller
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserServiceImpl userService;

    @GetMapping("/register")
    public String registerUser(Model model) {

        User user = new User();
        getCaptcha(user);
        model.addAttribute("user", user);
        return "registerUser";
    }


    @PostMapping("/save")
    public String saveUser(@ModelAttribute User user, Model model) {

        if (user.getCaptcha().equals(user.getHiddenCaptcha())) {
            userService.createUser(user);
            model.addAttribute("message", "Successfully Registered!");
            return "redirect:allUsers";

        } else {
            model.addAttribute("message", "Wrong Answer!");
            getCaptcha(user);
            model.addAttribute("user", user);
        }
        return "registerUser";
    }


    @GetMapping("/allUsers")
    public String getAllUsers(Model model) {

        List<User> userList = userService.getAllUsers();
        model.addAttribute("userList", userList);
        return "listUsers";
    }


    private void getCaptcha(User user) {

        //captcha rasmga o'lcham berdik
        Captcha captcha = CaptchaUtil.createCaptcha(120, 80);
        user.setHiddenCaptcha(captcha.getAnswer()); //captchaning haqiqiy qiymati
        user.setCaptcha(""); //user kiritgan qiymat
        user.setRealCaptcha(CaptchaUtil.encodeCaptcha(captcha)); //captchadan string olindi
    }
}
