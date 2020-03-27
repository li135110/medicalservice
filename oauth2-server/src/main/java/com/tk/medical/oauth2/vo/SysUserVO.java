package com.tk.medical.oauth2.vo;

import com.tk.medical.oauth2.entity.SysRole;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Set;

@Getter
@Setter
@ToString
public class SysUserVO {
    private int id;
    private String username;
    private String password;
    private Set<SysRole> sysRoles;
}
