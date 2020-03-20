package com.tk.medical.oauth2.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author: yugu
 * @CreateDate: 2018/9/26$ 下午9:29$
 * @Description: 用户表实体
 */

@Data
public class UserPojo implements Serializable {

    private Integer id;
    private String name;
    private String mobile;
    private String mail;
    private String pwd;

    public UserPojo() {
    }

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
    
    
}
