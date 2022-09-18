package com.htsc.znkj.service;

import com.htsc.znkj.entity.User;
import com.htsc.znkj.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * 自定义用户查询接口
 * 该实现类需要继承com.htsc.znkj.service.ICustomUserDetailsService接口，并实loadUserByUsername(String username)方法返回一个UserDetails
 */
@Service
public class CustomUserDetailsService implements ICustomUserDetailsService {
    @Autowired
    private UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = repository.findByUserName(username);
        return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(), new ArrayList<>());
    }
}
