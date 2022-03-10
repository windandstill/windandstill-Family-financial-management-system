package cn.aka.controller;

import cn.aka.pojo.*;
import cn.aka.service.DatadicService;
import cn.aka.service.IncomeService;
import cn.aka.service.SecurityService;
import cn.aka.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
public class IncomeController {
    @Autowired
    private DatadicService datadicService;

    @Autowired
    private IncomeService incomeService;

    @Autowired
    private UserService userService;

    @RequestMapping("/incomeManage.do")
    public ModelAndView incomeManage(HttpServletRequest request) {
        System.out.println("123456789");
        ModelAndView mv = new ModelAndView();
        List<Datadic> datadics = datadicService.findDatadicSecurity();
        mv.addObject("incomes", datadics);

        User user = (User) request.getSession().getAttribute("currentUser");
        Map<String, Object> userMap = new HashMap<String, Object>();
        userMap.put("userid", user.getId());
        userMap.put("roleid", user.getRoleid());
        List<User> allUsers = incomeService.getAllUsers(userMap);
        mv.addObject("allUsers",allUsers);
        return mv;
    }
    @RequestMapping ("incomelist")
    @ResponseBody
    public ResultBean<Income> list(@RequestParam(value = "page", required = false) String page,
                                     @RequestParam(value = "rows", required = false) String rows, Income income) {
        ResultBean<Income> resultBean = new ResultBean<>();
        PageBean pageBean = new PageBean((Integer.parseInt(page)-1)*(Integer.parseInt(rows)), Integer.parseInt(rows));
        int total = incomeService.findCount(income);
        resultBean.setTotal(total);
        List<Income> incomes= incomeService.findIncome(income);
        resultBean.setRows(incomes);
        return resultBean;
    }
}
