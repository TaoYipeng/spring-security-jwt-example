package com.javatechie.jwt.api.controller.impl;

import com.javatechie.jwt.api.controller.IAuthController;
import com.javatechie.jwt.api.entity.AuthRequest;
import com.javatechie.jwt.api.service.IAuthService;
import com.javatechie.jwt.api.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * 认证登录接口
 */
@RestController
public class AuthController implements IAuthController {

    @Autowired
    private IAuthService authService;

    @Autowired
    private JwtUtil jwtUtil;

    public String login(AuthRequest authRequest) throws Exception {
        return authService.login(authRequest.getUserName(), authRequest.getPassword());
    }

    public String logout() {
        return authService.logout();
    }

    public String refreshToken(HttpServletRequest request) {
        return authService.refreshToken(jwtUtil.getToken(request));
    }
}
