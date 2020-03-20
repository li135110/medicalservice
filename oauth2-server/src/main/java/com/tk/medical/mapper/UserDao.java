package com.tk.medical.mapper;

import com.tk.medical.vo.SysUserVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDao {

    SysUserVO findByUserName(String username);

}
