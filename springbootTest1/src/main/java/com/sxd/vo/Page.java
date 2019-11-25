package com.sxd.vo;

import lombok.Data;

import java.util.List;

/**
 * 分页属性包
 * @param <T>
 */
@Data
public class Page<T> {
    //当前页的数据
    private List<T> datas;
    //总页数
    private int totalPage;
    //总记录数
    private long totalNum;
}
