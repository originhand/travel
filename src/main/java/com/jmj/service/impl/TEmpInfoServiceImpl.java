package com.jmj.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.common.ResponseBean;
import com.common.ResponseEnum;
import com.jmj.entity.TEmpInfo;
import com.jmj.service.TEmpInfoService;
import com.jmj.mapper.TEmpInfoMapper;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

/**
 * @author muyan
 * @description 针对表【t_emp_info(员工表)】的数据库操作Service实现
 * @createDate 2025-03-13 16:54:22
 */
@Service
public class TEmpInfoServiceImpl extends ServiceImpl<TEmpInfoMapper, TEmpInfo>
        implements TEmpInfoService {
    @Value("${my-config.session-key}")
    private String sessionKey;
//    @Autowired
//    private TEmpInfoMapper empInfoMapper;

    @Override
    public ResponseBean doLogin(String empName, String empNo, String telNumber, HttpSession httpSession) {
        //参数校验
        if (StringUtils.isEmpty(empName) || StringUtils.isEmpty(empNo) || StringUtils.isEmpty(telNumber)) {
            return ResponseBean.error(ResponseEnum.PARAMETER_IS_ABNORMAL);
        }
        // 如果你使用的是密码登录，建议给密码加密 select * from t_emp_info where
        TEmpInfo empInfo = getOne(new LambdaQueryWrapper<>(TEmpInfo.class)
                .eq(TEmpInfo::getEmpName,empName)
                .eq(TEmpInfo::getEmpNo,empNo)
                .eq(TEmpInfo::getTelNumber,telNumber)
        );
//        EmpInfo empInfo=  getOne(new QueryWrapper<EmpInfo>()
//                .eq("emp_name", empName)
//                .eq("emp_no",empNo)
//                .eq("tel_number",telNumber));
        if (ObjectUtils.isEmpty(empInfo)){
            return ResponseBean.error(ResponseEnum.LOGIN_INFORMATION_IS_INCORRECT);
        }
        //做登录成功之后的处理（将登录成功的员工信息 存放到session中）
        httpSession.setAttribute(sessionKey, empInfo);
        return ResponseBean.success();
    }
}




