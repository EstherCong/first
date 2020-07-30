/*
 * Copyright 2020 Kingland Systems Corporation. All Rights Reserved.
 */
package com.kingland.demo.bean;

import com.sun.istack.internal.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * UserInfo Entity class
 * @description Used to store and transfer data
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserInfo {

    private int id;
@NotNull
    private String username;
@NotNull
    private String password;
}
