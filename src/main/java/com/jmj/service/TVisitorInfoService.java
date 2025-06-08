package com.jmj.service;

import com.common.ResponseBean;
import com.jmj.entity.TVisitorInfo;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.ui.Model;

import javax.servlet.http.HttpSession;

/**
* @author 73848
* @description 针对表【t_visitor_info】的数据库操作Service
* @createDate 2025-03-13 17:53:09
*/
public interface TVisitorInfoService extends IService<TVisitorInfo> {
    /**
     * 保存来访记录
     * @param visitorInfo
     * @return
     */
    ResponseBean doVisit(TVisitorInfo visitorInfo);
    /**
     * 根据当前登录用户获取其到访数据列表
     *
     * @param session session对象
     * @param model   ModelView
     * @param page    当前页码
     */
    void visitList(HttpSession session, Model model, Integer page);

    /**
     * 审核
     *
     * @param id   访客信息ID
     * @param type 审核状态  1通过 2拒绝
     */
    ResponseBean audit(Integer id, Integer type);
}
