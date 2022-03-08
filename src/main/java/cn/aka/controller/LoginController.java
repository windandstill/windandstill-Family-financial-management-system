package cn.aka.controller;

import cn.aka.pojo.Role;
import cn.aka.pojo.User;
import cn.aka.service.RoleService;
import cn.aka.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.core.Request;
import java.util.List;

@Controller
public class LoginController {
    @Autowired
    private RoleService roleService;
    @Autowired
    private UserService userService;

    @GetMapping(value = "/index")
    public ModelAndView index(ModelAndView modelAndView) {
        modelAndView.addObject("roles",roleService.getAllRole());
        modelAndView.setViewName("login");
        return modelAndView;
    }

    @RequestMapping("/login")
    public ModelAndView login(User user, HttpServletRequest request){
        User currentUser = userService.findUserAndRoleByNP(user);
        ModelAndView modelAndView = new ModelAndView();
        if (currentUser!=null){
            request.getSession().setAttribute("currentUser",currentUser);
            modelAndView.addObject(currentUser);
            modelAndView.setViewName("main");
        }else {
            modelAndView.addObject("roles",roleService.getAllRole());
            modelAndView.addObject("messageshow","用户名或密码错误");
        }
        return modelAndView;
    }
    @RequestMapping("sign")
    public String sgin(){
        return "sign";
    }


}
