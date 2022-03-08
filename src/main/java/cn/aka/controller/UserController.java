package cn.aka.controller;

import cn.aka.pojo.Result;
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
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class UserController {
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

    @RequestMapping("gosign")
    @ResponseBody
    public Result gosign(User user){
        User userByUsername = userService.findUserByUsername(user);
        Result result = new Result();
        if (userByUsername == null){
            //创建时间
            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            user.setCreatetime(sdf.format(date));
            //增加用户
            userService.insertUser(user);
            //获取用户id
            User user1=userService.findUserByUsername(user);
            //角色用户表中增加用户角色
            user1.setRoleid(user.getRoleid());
            userService.insertUserRole(user1);
            result.setErrres("1");
            result.setErrmsq("注册成功!");
        }else {
            result.setErrmsq("注册失败,该用户名已存在!");
        }
        return result;
    }


}
