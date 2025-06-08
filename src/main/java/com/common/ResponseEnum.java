package com.common;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author 哈喽沃德
 * @version 1.0
 * @date 2025/03/17 下午 19:23:40
 */
@Getter
@AllArgsConstructor
public enum ResponseEnum {
    SUCCESS(0,"登录成功"),
    PARAMETER_IS_ABNORMAL(-1000,"参数异常"),
    LOGIN_INFORMATION_IS_INCORRECT(1001, "登录信息异常"),
    EMP_DOES_NOT_EXIST(2001,"没有这个员工" ),
    SAVE_VISIT_DATA_FAIL(2002, "保存来访数据失败"),
    AUDIT_FAIL(2003, "审核失败");

    private final Integer code;
    private final String msg;

}
