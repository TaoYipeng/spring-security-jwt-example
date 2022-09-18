package com.htsc.znkj.controller.impl;

import com.htsc.znkj.controller.IAuthController;
import com.htsc.znkj.entity.AuthRequest;
import com.htsc.znkj.service.IAuthService;
import com.htsc.znkj.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * 认证登录接口
 */
@RestController
public class AuthController implements IAuthController {

    @Autowired
    private IAuthService authService;

    @Value("${jwt.tokenHeader}")
    private String tokenHeader;

    public String login(AuthRequest authRequest) throws Exception {
        return authService.login(authRequest.getUserName(), authRequest.getPassword());
    }

    public String logout() {
        return authService.logout();
    }

    public String refreshToken(HttpServletRequest request) {
        return authService.refreshToken(request.getHeader(tokenHeader));
    }
}
