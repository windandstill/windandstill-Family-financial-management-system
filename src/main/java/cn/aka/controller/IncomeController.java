package cn.aka.controller;

import cn.aka.pojo.*;
import cn.aka.service.*;
import cn.aka.util.ResponseUtil;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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

    @Autowired
    private SecurityService securityService;


    @RequestMapping("incomeManage")
    @ResponseBody
    public ModelAndView incomeManage(HttpServletRequest request) {
        ModelAndView mv = new ModelAndView();
        List<Datadic> datadics = datadicService.findDatadicValueByName("收入类型");
        mv.addObject("incomes", datadics);
        User user = (User) request.getSession().getAttribute("currentUser");
        Map<String, Object> userMap = new HashMap<String, Object>();
        userMap.put("userid", user.getId());
        userMap.put("roleid", user.getRoleid());
        List<User> allUsers = securityService.getAllUsers(userMap);
        mv.addObject("allUsers",allUsers);
        return mv;
    }
    @RequestMapping("incomelist")
    public String list(@RequestParam(value = "page", required = false) String page,
                       @RequestParam(value = "rows", required = false) String rows, Income s_income, HttpServletResponse response)
            throws Exception {
        PageBean pageBean = new PageBean(Integer.parseInt(page), Integer.parseInt(rows));
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("incomer", s_income.getIncomer());
        map.put("source", s_income.getSource());
        map.put("dataid", s_income.getDataid());
        map.put("starttime", s_income.getStarttime());
        map.put("endtime", s_income.getEndtime());
        map.put("roleid", s_income.getRoleid());
        map.put("userid", s_income.getUserid());
        map.put("start", pageBean.getStart());
        map.put("size", pageBean.getPageSize());
        List<Income> incomeList = incomeService.findIncome(map);
        Long total = incomeService.getTotalIncome(s_income);
        JSONObject result = new JSONObject();
        JSONArray jsonArray = JSONArray.fromObject(incomeList);
        result.put("rows", jsonArray);
        result.put("total", total);
        ResponseUtil.write(response, result);
        return null;
    }
    @RequestMapping("incomesave")
    @ResponseBody
    public Result save(Income income) {
        Result result = new Result();
        int total = 0;
        if (income.getId() == null) {
            total = incomeService.addIncome(income);
        }else {
            total = incomeService.updateIncome(income);
        }
        if (total > 0) {
            result.setErrres(200);
            result.setErrmsg("用户保存成功!!!");
        } else {
            result.setErrres(101);
            result.setErrmsg("用户添加失败");
        }
        return result;
    }

    @RequestMapping("incomedelete")
    @ResponseBody
    public Result delete(@RequestParam(value = "ids")String ids) {
        Result result = new Result();
        int total = 0;
        String[] idsStr = ids.split(",");
        for (int i = 0; i < idsStr.length; i++) {
            incomeService.deleteIncome(Integer.parseInt(idsStr[i]));
        }
        result.setErrres(200);
        result.setErrmsg("删除成功!!!");
        return result;
    }

}
