package cn.aka.controller;


import cn.aka.pojo.Security;
import cn.aka.service.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/security")
public class FinancialController {
    @Autowired
    private SecurityService securityService;

    @RequestMapping("/securitylist")
    public ModelAndView list() {
        ModelAndView mv = new ModelAndView();
        System.out.println("12444");
        List<Security> securities = securityService.findSecurityById();
        System.out.println(securities+"----------------");
        System.out.println("今天集团那就 ");
        securities.forEach(System.out::println);
        mv.addObject("currentUser", securities);
        mv.setViewName("securityManage");
        return mv;
    }
}
