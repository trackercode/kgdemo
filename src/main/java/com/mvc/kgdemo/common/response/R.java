package com.mvc.kgdemo.common.response;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.mvc.kgdemo.common.constant.ResponseMsgConstant;


import java.util.HashMap;
import java.util.Map;

/**
 * 返回数据
 */
public class R extends HashMap<String, Object> {
    private static final long serialVersionUID = 1L;
    private static final String DATA_KEY = "data";

    public R() {
        put(ResponseMsgConstant.CODE_KEY, ResponseMsgConstant.SUCCESS.getCode());
        put(ResponseMsgConstant.MSG_KEY, ResponseMsgConstant.SUCCESS.getMsg());
        put(DATA_KEY, "");
    }

    public static R error() {
        return error(ResponseMsgConstant.ERROR.getCode(), ResponseMsgConstant.ERROR.getMsg());
    }

    public static R error(String msg) {
        return error(ResponseMsgConstant.ERROR.getCode(), msg);
    }

    public static R error(int code, String msg) {
        R r = new R();
        r.put(ResponseMsgConstant.CODE_KEY, code);
        r.put(ResponseMsgConstant.MSG_KEY, msg);
        return r;
    }

    public static R warning() {
        return error(ResponseMsgConstant.WARNING.getCode(), ResponseMsgConstant.WARNING.getMsg());
    }

    public static R warning(String msg) {
        return error(ResponseMsgConstant.WARNING.getCode(), msg);
    }

    public static R warning(int code, String msg) {
        R r = new R();
        r.put(ResponseMsgConstant.CODE_KEY, code);
        r.put(ResponseMsgConstant.MSG_KEY, msg);
        return r;
    }

    public static R info() {
        return error(ResponseMsgConstant.INFO.getCode(), ResponseMsgConstant.INFO.getMsg());
    }

    public static R info(String msg) {
        return error(ResponseMsgConstant.INFO.getCode(), msg);
    }

    public static R info(int code, String msg) {
        R r = new R();
        r.put(ResponseMsgConstant.CODE_KEY, code);
        r.put(ResponseMsgConstant.MSG_KEY, msg);
        return r;
    }

    public static R failure() {
        return error(ResponseMsgConstant.FAILURE.getCode(), ResponseMsgConstant.FAILURE.getMsg());
    }

    public static R failure(String msg) {
        return error(ResponseMsgConstant.FAILURE.getCode(), msg);
    }

    public static R failure(int code, String msg) {
        R r = new R();
        r.put(ResponseMsgConstant.CODE_KEY, code);
        r.put(ResponseMsgConstant.MSG_KEY, msg);
        return r;
    }

    public static R ok(String msg) {
        R r = new R();
        r.put(ResponseMsgConstant.MSG_KEY, msg);
        return r;
    }

    public static R ok(Map<String, Object> map) {
        R r = new R();
        r.putAll(map);
        return r;
    }

    public static R ok() {
        return new R();
    }

    /**
     * R实质上为一个HashMap,只能保存键值对，不能使用私有属性的getter和setter方法的形式保存数据
     */
    public R setData(Object data) {
        put(DATA_KEY, data);
        return this;
    }

    /**
     * 利用fastjson转成泛型
     *
     * @param typeReference
     * @param <T>           泛型指定返回值类型
     * @return
     */
    public <T> T getData(TypeReference<T> typeReference) {
        Object data = get(DATA_KEY);
        return JSON.parseObject(JSON.toJSONString(data), typeReference);
    }

    @Override
    public R put(String key, Object value) {
        super.put(key, value);
        return this;
    }
}
