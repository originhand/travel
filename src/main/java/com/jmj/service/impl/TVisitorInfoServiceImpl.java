package com.jmj.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.common.ResponseBean;
import com.common.ResponseEnum;
import com.jmj.entity.TEmpInfo;
import com.jmj.entity.TVisitorInfo;
import com.jmj.entity.vo.VisitorInfoVO;
import com.jmj.service.TEmpInfoService;
import com.jmj.service.TVisitorInfoService;
import com.jmj.mapper.TVisitorInfoMapper;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
* @author 73848
* @description 针对表【t_visitor_info】的数据库操作Service实现
* @createDate 2025-03-13 17:53:09
*/
@Service
public class TVisitorInfoServiceImpl extends ServiceImpl<TVisitorInfoMapper, TVisitorInfo> implements TVisitorInfoService {
    @Value("${my-config.session-key}")
    private String sessionKey;

    @Autowired
    private TEmpInfoService empInfoService;
    @Autowired
    private TVisitorInfoMapper visitorInfoMapper;
    @Override
    public ResponseBean doVisit(TVisitorInfo visitorInfo) {
        //检验来访数据
        if(ObjectUtils.isEmpty(visitorInfo)){
        return ResponseBean.error(ResponseEnum.PARAMETER_IS_ABNORMAL);
        }
        if (ObjectUtils.isEmpty(visitorInfo.getEmpTelNumber())){
            return ResponseBean.error(ResponseEnum.PARAMETER_IS_ABNORMAL);
        }
        //根据被访人联系方式，查询数据库，看是否有这个员工
        TEmpInfo empInfo =empInfoService.getOne(new LambdaQueryWrapper<>(TEmpInfo.class)
                .eq(TEmpInfo::getTelNumber, visitorInfo.getEmpTelNumber())
                .eq(TEmpInfo::getStatus, 1));//对比被访人联系方式
        if (ObjectUtils.isEmpty(empInfo)){
            return ResponseBean.error(ResponseEnum.EMP_DOES_NOT_EXIST);
        }
        visitorInfo.setEmpId(empInfo.getId());
        //保存来访信息
        if (save(visitorInfo)){
            return ResponseBean.success();
        }
        return ResponseBean.error(ResponseEnum.SAVE_VISIT_DATA_FAIL);
    }

    @Override
    public void visitList(HttpSession session, Model model, Integer page) {
        //获取当前登录用户
        TEmpInfo empInfo = (TEmpInfo) session.getAttribute(sessionKey);
        
        // 设置每页显示的数量为2条
        int pageSize = 2;
        
        // 获取总记录数
        int total = visitorInfoMapper.getCountForEmpId(empInfo.getId());
        
        // 计算总页数
        int totalPages = (int) Math.ceil((double) total / pageSize);
        
        // 确保页码在有效范围内
        page = Math.max(1, Math.min(page, totalPages));
        
        // 计算偏移量
        int offset = (page - 1) * pageSize;
        
        // 获取分页数据
        List<VisitorInfoVO> list = visitorInfoMapper.getListForEmpIdWithPage(empInfo.getId(), offset, pageSize);
        
        // 将数据添加到模型中
        model.addAttribute("visitList", list);
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", totalPages);
    }

    @Override
    public ResponseBean audit(Integer id, Integer type) {
        TVisitorInfo visitorInfo=new TVisitorInfo();
        visitorInfo.setId(id);
        visitorInfo.setStatus(type);
        if (updateById(visitorInfo)) {
            return ResponseBean.success();
        }
        return ResponseBean.error(ResponseEnum.AUDIT_FAIL);
    }
}
