package com.htsc.znkj.service;

public interface IAuthService {

    String login(String userName, String password) throws Exception;

    String logout();

    String refreshToken(String token);
}
