package com.jmj.controller;

import com.common.ResponseBean;
import com.jmj.entity.TVisitorInfo;
import com.jmj.service.TVisitorInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/visit")
public class VisitorController {
    @Autowired
    private TVisitorInfoService visitorInfoService;
    @PostMapping("/doVisit")
    @ResponseBody
    public ResponseBean doVisit(TVisitorInfo visitorInfo){
        return visitorInfoService.doVisit(visitorInfo);
    }
    @GetMapping("/visit_page")
    public String visitPage(){
        return "/pages/visit";
    }
    @GetMapping("/plan")
    public String visitList(HttpSession session, Model model, @RequestParam(defaultValue = "1") Integer page){
        visitorInfoService.visitList(session, model, page);
        return "pages/plan";
    }
    @GetMapping("/audit/{id}/{type}")
    @ResponseBody
    public ResponseBean audit(@PathVariable("id") Integer id, @PathVariable("type") Integer type){
        return visitorInfoService.audit(id,type);
    }
}