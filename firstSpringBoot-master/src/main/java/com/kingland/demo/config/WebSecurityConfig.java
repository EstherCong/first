/*
 * Copyright 2020 Kingland Systems Corporation. All Rights Reserved.
 */
package com.kingland.demo.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * WebSecurityConfig
 * @description Do simple access filtering, forward to the appropriate view page
 */
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private UserDetailsService userService;

    /**
     * Injection by constructor
     * @param userService
     */
    public WebSecurityConfig(UserDetailsService userService) {
        this.userService = userService;
    }

    /**
     * override config，filter static resources
     *@param webSecurity
     * @throws Exception
     */
    @Override
    public void configure(WebSecurity webSecurity) throws Exception {
        webSecurity.ignoring().antMatchers("/css/**");
        webSecurity.ignoring().antMatchers("/public/**");
        webSecurity.ignoring().antMatchers("/favicon.ico", "/resources/**", "/error");
    }

    /**
     * Security Policy Configuration
     *
     * @param httpSecurity
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .authorizeRequests()
                // Some resources on the website need to be authorized
                .antMatchers("/*.html").permitAll()
                .antMatchers("/index").permitAll()
                .antMatchers("/reg").permitAll()
                // All requests except the above require authentication
                .anyRequest().authenticated().and()
                // Defines the login page to go to when a user is required to log in .loginPage("/login")
                .formLogin().loginPage("/login").defaultSuccessUrl("/index.html").permitAll().and()
                .formLogin().loginPage("/reg").defaultSuccessUrl("/index.html").permitAll().and()
                // Define the logout operation
                .logout().logoutSuccessUrl("/login?logout").permitAll().and()
                // Disable CSRF, otherwise it may cause some errors
                .csrf().disable()
        ;
        // Disable catching
        httpSecurity.headers().cacheControl();
    }

    /**
     * @param auth
     * @throws Exception
     */
    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        // user database user information service Password authentication
        auth.userDetailsService(userService).passwordEncoder(new BCryptPasswordEncoder());
    }
}