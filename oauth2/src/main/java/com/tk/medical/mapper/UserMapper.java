package com.tk.medical.mapper;

import com.tk.medical.bean.UserPojo;

public interface UserMapper {

    UserPojo selectByUsername(String username);

    UserPojo selectByMobile(String mobile);

    UserPojo selectByEmail(String email);
}
