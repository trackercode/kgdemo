package com.mvc.kgdemo.common.page;

import lombok.Data;

import java.io.Serializable;
import java.util.Map;

@Data
public class PageTable<T> implements Serializable {

    /**
     * 状态
     */
    public int code = 0;
    /**
     * 状态信息
     */
    public String msg = "";
    /**
     * 数据总数
     */
    public long count;
    /**
     * 列表数据
     */
    public T data;
    /**
     * 额外数据
     */
    public Map<String, Object> extra;

}

