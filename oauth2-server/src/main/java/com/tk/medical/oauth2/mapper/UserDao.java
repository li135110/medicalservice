package com.tk.medical.oauth2.mapper;

import com.tk.medical.oauth2.vo.SysUserVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDao {

    SysUserVO findByUserName(String username);

}
