package com.boot.utils;

import java.io.Serializable;
import java.util.List;

/**
 * ******************************
 * Author：      柯贤铭
 * CreateTime:   2019/3/4 15:25
 * Description:  PageList类
 * Version:      V1.0
 * ******************************
 */
public class PageList<T extends Serializable> {

    /**
     * 总记录数
     */
    private Long totalCount;

    /**
     * 总页数
     */
    private Long totalPageCount;

    /**
     * 开始查询的页数
     */
    private int startPageNo;

    /**
     * 查询的偏移量【每页查询的最大条数】
     */
    private int pageSize;

    /**
     * 对象集合
     */
    private List<T> list;

    public Long getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Long totalCount) {
        this.totalCount = totalCount;
    }

    public Long getTotalPageCount() {
        return totalPageCount;
    }

    public void setTotalPageCount(Long totalPageCount) {
        this.totalPageCount = totalPageCount;
    }

    public int getStartPageNo() {
        return startPageNo;
    }

    public void setStartPageNo(int startPageNo) {
        this.startPageNo = startPageNo;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
}
