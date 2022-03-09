package cn.aka.controller;

import cn.aka.pojo.*;
import cn.aka.service.RoleService;
import cn.aka.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class UserController {
    @Autowired
    private RoleService roleService;
    @Autowired
    private UserService userService;

    /**
     * 查询所有角色返回给login里
     */
    @GetMapping(value = "/index")
    public ModelAndView index(ModelAndView modelAndView) {
        modelAndView.addObject("roles",roleService.getAllRole());
        modelAndView.setViewName("login");
        return modelAndView;
    }

    /**
     * 登录用户 并将当前用户放到session中
     */
    @RequestMapping("/login")
    @ResponseBody
    public Result login(User user, HttpServletRequest request) {
        Result result = new Result();
        User currentUser = userService.findUserAndRoleByNP(user);
        if (currentUser == null) {
            result.setErrres(101);
            result.setErrmsg("用户名或者密码错误");
            result.setInputfocus("inputUsername");
        } else {
            result.setErrres(200);
            request.getSession().setAttribute("currentUser", currentUser);
            request.getSession().setAttribute("usermessage", currentUser);
        }
        return result;
    }

    /**
     * 跳转到注册页面
     */
    @RequestMapping("sign")
    public String sgin() {
        return "sign";
    }

    /**
     * 注册用户
     */
    @RequestMapping("gosign")
    @ResponseBody
    public Result gosign(User user) {
        User userByUsername = userService.findUserByUsername(user);
        Result result = new Result();
        if (userByUsername == null) {
            //创建时间
            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            user.setCreatetime(sdf.format(date));
            //增加用户
            userService.insertUser(user);
            //获取用户id
            User user1 = userService.findUserByUsername(user);
            //角色用户表中增加用户角色
            user1.setRoleid(user.getRoleid());
            userService.insertUserRole(user1);
            result.setErrres(1);
            result.setErrmsg("注册成功!");
        } else {
            result.setErrmsg("注册失败,该用户名已存在!");
            result.setInputfocus("inputUsername");
        }
        return result;
    }

    /**
     * 跳转到主页面
     */
    @RequestMapping("main")
    public String main() {
        return "main";
    }

    /**
     * 查询所有用户并跳转到用户信息管理
     */
    @RequestMapping("userManage")
    public ModelAndView userManage(ModelAndView modelAndView) {
        modelAndView.addObject("roles",roleService.getAllRole());
        modelAndView.setViewName("userManage");
        return modelAndView;
    }

    @RequestMapping("userlist")
    @ResponseBody
    public ResultBean<User> userlist(@RequestParam(value = "page", required = false) String page,
                                     @RequestParam(value = "rows", required = false) String rows,User user){
        PageBean pageBean = new PageBean(Integer.parseInt(page), Integer.parseInt(rows));
        Map<String, Object> map = new HashMap<String, Object>();
        ResultBean<User> userResultBean = new ResultBean<User>();
        map.put("username",user.getUsername());
        map.put("truename",user.getTruename());
        map.put("appellation",user.getAppellation());
        map.put("sex",user.getSex());
        map.put("roleid",user.getRoleid());
        map.put("start",pageBean.getStart());
        map.put("pageSize",pageBean.getPageSize());
        System.out.println(map);
        int totalUser = userService.findTotalUser(map);
        List<User> allUserByPage = userService.findAllUserByPage(map);
        userResultBean.setTotal(totalUser);
        userResultBean.setRows(allUserByPage);
        return userResultBean;
}

    @RequestMapping("roleManage")
    public String roleManage() {
        return "roleManage";
    }

    @RequestMapping("datadicManage")
    public String datadicManage() {
        return "datadicManage";
    }




}
