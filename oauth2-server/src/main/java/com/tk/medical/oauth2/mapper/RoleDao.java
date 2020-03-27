package com.tk.medical.oauth2.mapper;

import com.tk.medical.oauth2.entity.SysRole;
import org.apache.ibatis.annotations.Mapper;

import java.util.Set;

@Mapper
public interface RoleDao {
    Set<SysRole> findByUserId(Integer userId);
}
