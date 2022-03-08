package cn.aka.controller;

import cn.aka.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginContoller {
    @Autowired
    private RoleService roleService;

    @GetMapping(value = "/index")
    @ResponseBody
    public ModelAndView index(ModelAndView modelAndView) {
        modelAndView.addObject("roles",roleService.getAllRole());
        modelAndView.setViewName("login");
        return modelAndView;
    }
}
