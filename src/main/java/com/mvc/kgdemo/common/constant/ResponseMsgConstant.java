package com.mvc.kgdemo.common.constant;

/**
 * 系统异常枚举类
 */
public enum ResponseMsgConstant {

    UNKNOW_EXCEPTION(100, "系统未知异常！"),
    VALID_EXCEPTION(101, "数据格式校验失败！"),
    SUCCESS(200, "操作成功！"),
    ERROR(201, "请求异常！"),
    WARNING(202, "操作警告！"),
    INFO(203, "操作提示！"),
    FAILURE(400, "操作失败！"),
    NOTFOUND_AUTHORIZATION(900, "缺少身份凭证！"),
    UNACTIVE_AUTHORIZATION(901, "身份凭证无效！"),
    EXPIRED_AUTHORIZATION(902, "身份凭证无效！"),
    FAILURE_AUTHORIZATION(903, "登录失败！"),
    FAILURE_LOGIN_TIMEOUT(999, "登录超时！");

    public static final String CODE_KEY = "code";
    public static final String MSG_KEY = "msg";

    private int code;
    private String msg;

    ResponseMsgConstant(int code, String msg) {
        this.code = code;
        this.msg = msg;

    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
