package com.common;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/**
 * @author 哈喽沃德
 * @version 1.0
 * @date 2025/03/17 下午 19:21:06
 */

@Data
@AllArgsConstructor
public class ResponseBean implements Serializable {
    private static final long serialVersionUID = 9064991095652797386L;
    private Integer code;
    private String msg;
    private Object data;
    private Integer total;

    public static ResponseBean success(){
        return new ResponseBean(ResponseEnum.SUCCESS.getCode(),ResponseEnum.SUCCESS.getMsg(),null,null);
    }

    public static ResponseBean success(Object data){
        return new ResponseBean(ResponseEnum.SUCCESS.getCode(),ResponseEnum.SUCCESS.getMsg(),data,null);
    }
    public static ResponseBean success(Object data,Integer total){
        return new ResponseBean(ResponseEnum.SUCCESS.getCode(),ResponseEnum.SUCCESS.getMsg(),data,total);
    }

    public static ResponseBean error(ResponseEnum responseEnum){
        return new ResponseBean(responseEnum.getCode(),responseEnum.getMsg(),null,null);
    }

}
