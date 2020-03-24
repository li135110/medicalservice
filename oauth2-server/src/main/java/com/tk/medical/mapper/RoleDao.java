package com.tk.medical.mapper;

import com.tk.medical.entity.SysRole;
import org.apache.ibatis.annotations.Mapper;

import java.util.Set;

@Mapper
public interface RoleDao {
    Set<SysRole> findByUserId(Integer userId);
}
