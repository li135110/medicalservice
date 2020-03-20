package com.tk.medical.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Set;

@Getter
@Setter
@ToString
public class SysRole {
    private int id;
    private String roleName;
    private String valid;
    private Set<SysPermission> sysPermissions;
}
