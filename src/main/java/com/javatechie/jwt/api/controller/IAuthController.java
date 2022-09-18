package com.javatechie.jwt.api.controller;

import com.javatechie.jwt.api.entity.AuthRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@RequestMapping("/api/auth")
public interface IAuthController {

    @PostMapping("/login")
    String login(@RequestBody AuthRequest authRequest) throws Exception;

    @PostMapping("/logout")
    String logout();

    @PostMapping("/refresh")
    String refreshToken(HttpServletRequest request);

}