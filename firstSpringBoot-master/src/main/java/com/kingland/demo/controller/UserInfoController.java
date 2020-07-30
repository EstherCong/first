/*
 * Copyright 2020 Kingland Systems Corporation. All Rights Reserved.
 */
package com.kingland.demo.controller;

import com.kingland.demo.bean.UserInfo;
import com.kingland.demo.service.UserInfoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/user")

public class UserInfoController  {
    @Resource(name = "userInfoService")
    private UserInfoService service;

    @RequestMapping("/login")
    public String login()
    {
        return "login";
    }

}



