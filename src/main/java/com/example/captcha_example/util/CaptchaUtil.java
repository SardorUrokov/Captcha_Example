package com.example.captcha_example.util;

import cn.apiclub.captcha.Captcha;
import cn.apiclub.captcha.backgrounds.GradiatedBackgroundProducer;
import cn.apiclub.captcha.noise.CurvedLineNoiseProducer;
import cn.apiclub.captcha.text.producer.DefaultTextProducer;
import cn.apiclub.captcha.text.renderer.DefaultWordRenderer;

import javax.imageio.ImageIO;
import java.io.ByteArrayOutputStream;
import java.util.Base64;

/**
 * project: Captcha_Example
 * author: Sardor Urokov
 * created at 2:37 AM on 05/Dec/2022
 **/

public class CaptchaUtil {

    //Creating Captcha Object
    public static Captcha createCaptcha (Integer width,  Integer height){

        return new Captcha.Builder(width, height)
                .addBackground( new GradiatedBackgroundProducer())
                .addText(new DefaultTextProducer(), new DefaultWordRenderer())
                .addNoise( new CurvedLineNoiseProducer())
                .build();
    }

    //Convert to binary String
    public static String encodeCaptcha (Captcha captcha){
        String image = null;

        try {
            ByteArrayOutputStream arrayOutputStream = new ByteArrayOutputStream();
            ImageIO.write(captcha.getImage(), "jpg", arrayOutputStream);

            byte[] bytes = Base64
                    .getEncoder()
                    .encode(arrayOutputStream.toByteArray());

            image = new String(bytes);

        }catch (Exception e){
            e.printStackTrace();
        }
        return image;
    }
}
