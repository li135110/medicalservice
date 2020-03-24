package com.tk.medical.mapper;

import com.tk.medical.entity.SysPermission;
import org.apache.ibatis.annotations.Mapper;

import java.util.Set;

@Mapper
public interface PermissionDao {
    Set<SysPermission> findByRoleId(Integer roleId);
}
