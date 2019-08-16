package com.wyn.api.pojo;

import lombok.Data;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wxk on 2019/6/4.
 */
@Data
@ToString
public class PageVo<T> {

    //总条数
    private int totalSize;
    //当前页
    private int currentPage;
    //每页数据大小
    private int pageSize;
    //总页数
    private int totalPage;
    //数据集合
    private List<T> dataList;

    public PageVo(){
        this.dataList=new ArrayList<>();
    }


}
