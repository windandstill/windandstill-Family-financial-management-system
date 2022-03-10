package cn.aka.controller;

import cn.aka.pojo.*;
import cn.aka.service.RoleService;
import cn.aka.service.UserService;
import net.sf.json.JSONObject;
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
     * 登录用户
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
            int result1 = userService.addUser(user);
            //获取用户id
            User user1 = userService.findUserByUsername(user);
            //角色用户表中增加用户角色
            user1.setRoleid(user.getRoleid());
            int result2 = userService.addUserRole(user1);
            if (result1+result2<2){
                result.setErrmsg("注册失败,请重试");
                result.setInputfocus("inputUsername");
            }else {
            result.setErrres(1);
            result.setErrmsg("注册成功!");
            }
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
    public ModelAndView main(ModelAndView modelAndView) {
        modelAndView.addObject("roles",roleService.getAllRole());
        modelAndView.setViewName("main");
        return modelAndView;
    }

    /**
     * 查询所有角色并跳转到用户信息管理
     */
    @RequestMapping("userManage")
    public ModelAndView userManage(ModelAndView modelAndView) {
        modelAndView.addObject("roles",roleService.getAllRole());
        modelAndView.setViewName("userManage");
        return modelAndView;
    }

    /**
     * 条件查询用户
     */
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
        int totalUser = userService.findTotalUser(map);
        List<User> allUserByPage = userService.findAllUserByPage(map);
        userResultBean.setTotal(totalUser);
        userResultBean.setRows(allUserByPage);
        return userResultBean;
}

    /**
     * 添加与修改用户
     */
    @RequestMapping("usersave")
    @ResponseBody
    public Result usersave(User user){
        System.out.println(user);
        Result result = new Result();
        if (user.getId() == null){
            User userByUsername = userService.findUserByUsername(user);
            if (userByUsername != null){
                result.setErrmsg("用户名已被使用");
                return result;
            }
            //创建时间
            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            user.setCreatetime(sdf.format(date));
            int result1 = userService.addUser(user);
            User user1 = userService.findUserByUsername(user);
            user1.setRoleid(user.getRoleid());
            int result2 = userService.addUserRole(user1);
            if (result1 + result2 < 2) {
                result.setErrmsg("添加数据失败,请重试");
            }else {
            result.setErrres(1);
            result.setErrmsg("数据添加成功！");
            }
        }else {
            User userByUsername = userService.findUserByUsername(user);
            if (userByUsername!=null && (!(userByUsername.getUsername().equals(user.getUsername())))){
                result.setErrmsg("用户名已被使用");
                return result;
            }
            //创建时间
            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            user.setUpdatetime(sdf.format(date));
            int resultTotal = userService.updateUser(user);
            if (resultTotal > 0){
                result.setErrres(1);
                result.setErrmsg("数据修改成功！");
            }else {
                result.setErrmsg("修改数据失败!");
            }
        }
        return result;
    }

    /**
     * 删除用户
     */
    @RequestMapping("userdelete")
    @ResponseBody
    public Result delete(@RequestParam(value = "ids") String ids) throws Exception {
        Result result = new Result();
        int resultTotal=0;
        String[] idsStr = ids.split(",");
        for (int i = 0; i < idsStr.length; i++) {
            resultTotal+= userService.deleteUserRole(Integer.parseInt(idsStr[i]));
            resultTotal+= userService.deleteUser(Integer.parseInt(idsStr[i]));
        }
        if (resultTotal==(idsStr.length*2)){
            result.setErrres(1);
            result.setErrmsg("数据删除成功！");
        }else {
            result.setErrmsg("删除失败");
        }
        return result;
    }

    /**
     * 修改用户密码
     */
    @RequestMapping("modifyPassword")
    @ResponseBody
    public Result upDateUserPassword(User user){
        Result result = new Result();
        int resultTotal = userService.updateUser(user);
        if (resultTotal>0){
            result.setErrres(1);
        }
        return result;
    }

    /**
     * 用户登出
     */
    @RequestMapping("logout")
    public String logout(){
        return "login";
    }
}
