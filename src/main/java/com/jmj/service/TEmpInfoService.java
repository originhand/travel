package com.jmj.service;

import com.common.ResponseBean;
import com.jmj.entity.TEmpInfo;
import com.baomidou.mybatisplus.extension.service.IService;

import javax.servlet.http.HttpSession;

/**
* @author 73848
* @description 针对表【t_emp_info(员工表)】的数据库操作Service
* @createDate 2025-03-13 17:53:09
*/
public interface TEmpInfoService extends IService<TEmpInfo> {

    ResponseBean doLogin(String empName, String empNo, String telNumber, HttpSession httpSession);
}
