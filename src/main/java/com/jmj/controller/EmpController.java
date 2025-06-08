package com.jmj.controller;

import com.common.ResponseBean;
import com.jmj.entity.TEmpInfo;
import com.jmj.service.TEmpInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author 哈喽沃德
 * @version 1.0
 * @date 2025/03/13 下午 16:55:40
 */
@Controller
@RequestMapping("/emp")
public class EmpController {
    @Autowired
    private TEmpInfoService empInfoService;

//    @GetMapping("/list")
//    @ResponseBody
//    public List<TEmpInfo> getEmpList(){
//        return empInfoService.list();
//    }

    /**
     * 员工登录接口
     * @param empName 员工姓名
     * @param empNo 员工工号
     * @param telNumber 电话
     * @return com.lxh.common.ResponseBean.class
     */
    @PostMapping("/doLogin")
    @ResponseBody
    public ResponseBean doLogin(String empName, String empNo, String telNumber, HttpSession httpSession){
        return empInfoService.doLogin(empName,empNo,telNumber,httpSession);
    }
    @GetMapping("/login")
    public String login(){
        return "pages/login";
    }

}
