package com.mvc.kgdemo.common.page;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.pagehelper.Page;

import java.util.List;
import java.util.Map;

public class PageInfo {
    /**
     * 响应请求分页数据
     */
    public static <T> PageTable getPageTable(IPage<T> page) {
        PageTable pageTable = new PageTable();
        pageTable.setCode(0);
        pageTable.setMsg("查询成功！");
        pageTable.setData(page.getRecords());
        pageTable.setCount(page.getTotal());
        return pageTable;
    }

    /**
     * 响应请求分页数据 添加额外返回参数
     */
    public static <T> PageTable getPageTable(Page<T> page, List<T> list, Map<String, Object> extra) {
        PageTable pageTable = new PageTable();
        pageTable.setCode(0);
        pageTable.setMsg("查询成功！");
        pageTable.setData(list);
        pageTable.setExtra(extra);
        pageTable.setCount(page.getTotal());
        return pageTable;
    }

    /**
     * 响应请求分页数据
     */
    public static <T> PageTable getPageTable(Page<T> page, List<T> list) {
        PageTable pageTable = new PageTable();
        pageTable.setCode(0);
        pageTable.setMsg("查询成功！");
        pageTable.setData(list);
        pageTable.setCount(page.getTotal());
        return pageTable;
    }

    /**
     * 响应请求分页数据
     */
    public static <T> PageTable getPageTable1(IPage<T> page) {
        PageTable pageTable = new PageTable();
        pageTable.setCode(0);
        pageTable.setMsg("查询成功！");
        pageTable.setData(page.getRecords());
        pageTable.setCount(page.getRecords().size());
        return pageTable;
    }
}
