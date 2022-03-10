package cn.aka.controller;


import cn.aka.pojo.*;

import cn.aka.service.DatadicService;
import cn.aka.service.SecurityService;
import cn.aka.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 证券账户管理
 */
@Controller
public class SecurityController {
    @Autowired
    private DatadicService datadicService;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private UserService userService;

    @RequestMapping("/securityManage")
    public ModelAndView securityManage(HttpServletRequest request) {
        ModelAndView mv = new ModelAndView();
        List<Datadic> datadics = datadicService.findDatadicValueByName("证券类型");
        mv.addObject("securitys", datadics);

        User user = (User) request.getSession().getAttribute("currentUser");
        Map<String, Object> userMap = new HashMap<String, Object>();
        userMap.put("userid", user.getId());
        userMap.put("roleid", user.getRoleid());
        List<User> allUsers = securityService.getAllUsers(userMap);
        mv.addObject("allUsers",allUsers);
        return mv;
    }
    @RequestMapping ("securitylist")
    @ResponseBody
    public ResultBean<Security> list(@RequestParam(value = "page", required = false) String page,
                       @RequestParam(value = "rows", required = false) String rows, SecurityVo securityVo) {
        ResultBean<Security> resultBean = new ResultBean<>();
        PageBean pageBean = new PageBean((Integer.parseInt(page)-1)*(Integer.parseInt(rows)), Integer.parseInt(rows));
        int total = securityService.findCount(securityVo);
        resultBean.setTotal(total);
        List<Security> securities = securityService.findSecurityById(securityVo);
        resultBean.setRows(securities);
        return resultBean;
}
@RequestMapping("tradeManage")
    public String a(){
        return "tradeManage";
}
    @RequestMapping("sharesManage")
    public String b(){
        return "sharesManage";
    }
}
