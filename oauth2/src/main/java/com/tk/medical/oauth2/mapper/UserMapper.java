package com.tk.medical.oauth2.mapper;

import com.tk.medical.oauth2.pojo.UserPojo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @Author: yugu
 * @CreateDate: 2018/9/27$ 上午8:49$
 * @Description: UserMapper
 */
@Mapper
public interface UserMapper {

    @Select("SELECT * FROM user WHERE name = #{name}")
    public UserPojo findByName(String name);

    @Select("SELECT * FROM user WHERE mobile = #{mobile}")
    public UserPojo findByMobile(String mobile);

    @Select("SELECT * FROM user WHERE mail = #{mail}")
    public UserPojo findByMail(String mail);
}
