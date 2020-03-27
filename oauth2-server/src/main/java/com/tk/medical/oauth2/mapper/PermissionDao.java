package com.tk.medical.oauth2.mapper;

import com.tk.medical.oauth2.entity.SysPermission;
import org.apache.ibatis.annotations.Mapper;

import java.util.Set;

@Mapper
public interface PermissionDao {
    Set<SysPermission> findByRoleId(Integer roleId);
}
