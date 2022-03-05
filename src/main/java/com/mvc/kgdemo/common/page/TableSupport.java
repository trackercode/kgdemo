package com.mvc.kgdemo.common.page;

import com.mvc.kgdemo.common.utils.ServletUtils;

public class TableSupport {

    /**
     * 封装分页
     */
    public static PageEntity getPageEntity() {
        PageEntity pageEntity = new PageEntity();
        pageEntity.setPage(ServletUtils.getParameterToInt(Constants.PAGE));
        pageEntity.setLimit(ServletUtils.getParameterToInt(Constants.LIMIT));
        pageEntity.setOrderByColumn(ServletUtils.getParameter(Constants.ORDER_BY_COLUMN));
        pageEntity.setIsAsc(ServletUtils.getParameter(Constants.IS_ASC));
        return pageEntity;
    }

    public static PageEntity buildPageRequest() {
        return getPageEntity();
    }
}
