package com.jmj.entity.vo;

import com.jmj.entity.TVisitorInfo;
import lombok.Data;

import java.io.Serializable;

/**
 * @author 哈喽沃德
 * @version 1.0
 * @date 2025/03/20 下午 17:20:08
 */
@Data
public class VisitorInfoVO extends TVisitorInfo implements Serializable {
    private static final long serialVersionUID = 3619631958486215597L;
    private String empName;
}
