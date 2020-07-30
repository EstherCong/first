/*
 * Copyright 2020 Kingland Systems Corporation. All Rights Reserved.
 */
package com.kingland.demo.service;

import com.kingland.demo.bean.UserInfo;
import com.kingland.demo.mapper.UserMapper;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

/**
 * UserInfoService
 * @description Pass UserMapper functionality
 */
@Service
public class UserInfoService implements UserDetailsService {

    private final UserMapper userMapper;

    /**
     * Injection by constructor
     * @param userMapper
     */
    public UserInfoService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    /**
     * override loadUserByUsername method
     * @param username
     * @return userinformation
     * @throws UsernameNotFoundException
     * */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // if username is null
        if (username == null || "".equals(username)) {
            // throw Exception
            throw new UsernameNotFoundException("please input username!");
        }
        // List is used to save permissions
        List<SimpleGrantedAuthority> list = new ArrayList<>();
        UserInfo user = userMapper.queryUserByName(username);
        if (null == user) {
            throw new UsernameNotFoundException("username is not exists!");
        }

        // returns a user object with permission information
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), list);
    }
}