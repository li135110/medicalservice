package com.tk.medical.oauth.mapper;

import com.tk.medical.oauth.bean.UserPojo;

public interface UserMapper {

    UserPojo selectByUsername(String username);

    UserPojo selectByMobile(String mobile);

    UserPojo selectByEmail(String email);
}
