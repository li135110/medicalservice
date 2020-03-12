package com.tk.medical.mapper;

import com.tk.medical.bean.User;

public interface UserMapper {

    User selectByUsername(String username);

    User selectByMobile(String mobile);

    User selectByEmail(String email);
}
