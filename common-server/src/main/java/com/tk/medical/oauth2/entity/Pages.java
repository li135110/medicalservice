package com.tk.medical.oauth2.entity;

import lombok.Data;

import java.util.List;

@Data
public class Pages {
    //当前页
    private int pageNum;
    //条数
    private int pageSize;
    //排序
    private String orderBy;
    private List<String> orderBys;
}

