package com.example.captcha_example.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;

/**
 * project: Captcha_Example
 * author: Sardor Urokov
 * created at 2:36 AM on 05/Dec/2022
 **/

@Data
@Entity(name = "users")
public class User {

    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private String email;
    private String phone;

    //user kiritgan string qiymat
    @Transient
    private String captcha;

    @Transient
    private String hiddenCaptcha;

    //rasmi
    @Transient
    private String realCaptcha;

}