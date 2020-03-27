package com.tk.medical.oauth2.entity;

import lombok.Data;

import java.util.List;
@Data
public class PageMap {
    //当前页
    private long pageCurrent;
    //条数
    private long pageSize;
    //排序
    private String orderBy;
    private List<String> orderBys;
}

