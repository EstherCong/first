package com.kingland.gradle.mapper;

import com.kingland.gradle.bean.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * UserMapper
 * select the user by username
 */
@Mapper
@Repository
public interface UserMapper {

    @Select("select * from user_info where username = #{username};")
    UserInfo queryUserByName(String username);

}
