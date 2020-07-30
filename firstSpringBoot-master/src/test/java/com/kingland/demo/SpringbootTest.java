package com.kingland.demo;

import com.kingland.demo.service.UserInfoService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest

public class SpringbootTest {

    @Autowired
    UserInfoService userInfoService;
    @Test
    void test()
    {
        // int res=userInfoService.loadUserByUsername(String);
    }
    @BeforeAll
    public static void beforeAll()
    {

    }


}
