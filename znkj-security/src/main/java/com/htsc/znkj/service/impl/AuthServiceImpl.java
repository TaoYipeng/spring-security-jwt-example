package com.htsc.znkj.service.impl;

import com.htsc.znkj.util.JwtUtil;
import com.htsc.znkj.service.IAuthService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class AuthServiceImpl implements IAuthService {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtUtil jwtUtil;

    @Override
    public String login(String userName, String password) throws Exception {
        log.debug("进入login方法");
        // 1 创建UsernamePasswordAuthenticationToken
        UsernamePasswordAuthenticationToken usernameAuthentication = new UsernamePasswordAuthenticationToken(userName, password);
        // 2 认证
        Authentication authentication = this.authenticationManager.authenticate(usernameAuthentication);
        // 3 保存认证信息
        SecurityContextHolder.getContext().setAuthentication(authentication);
        // 4 生成自定义token
        String token = jwtUtil.generateToken(userName);
        return token;
    }

    @Override
    public String logout() {
        SecurityContextHolder.clearContext();
        return "logout successifully";
    }

    @Override
    public String refreshToken(String oldToken) {
        String newToken = jwtUtil.refreshHeadToken(oldToken);
        return newToken;
    }
}
