package com.javatechie.jwt.api.service;

import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

/**
 * 用户表 服务类
 */
public interface IUsersService {

    /**
     * 获取用户信息
     */
    UserDetails loadUserByUsername(String username);

}
