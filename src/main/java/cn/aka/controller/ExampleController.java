package cn.aka.controller;

import cn.aka.pojo.Income;
import cn.aka.pojo.PageBean;
import cn.aka.pojo.ResultBean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ExampleController {

    @GetMapping(value = "/index")
    public String index() {
        return "login";
    }

    @GetMapping(value = "/main")
    public String main() {
        return "main";
    }

    @GetMapping(value = "/payManage")
    public String payManage() {
        return "payManage";
    }

    @GetMapping(value = "/incomeManage")
    public String incomeManage() {
        //查询所有的收入类型
        return "incomeManage";
    }

    @GetMapping(value = "/securityManage")
    public String securityManage() {
        return "securityManage";
    }

    @GetMapping(value = "/sharesManage")
    public String sharesManage() {
        return "sharesManage";
    }

    @GetMapping(value = "/tradeManage")
    public String tradeManage() {
        return "tradeManage";
    }

    @GetMapping(value = "/incomeTimeManage")
    public String incomeTimeManage() {
        return "/incomeTimeManage";
    }

    @GetMapping(value = "/payTimeManage")
    public String payTimeManage() {
        return "/payTimeManage";
    }

    @GetMapping(value = "/typePieManage")
    public String typePieManage() {
        return "/typePieManage";
    }

    @GetMapping(value = "/logout")
    public String logout() {
        return "/index";
    }

    @PostMapping(value = "/incomelist")
    @ResponseBody
    public ResultBean<Income> list(@RequestParam(value = "page", required = false) String page,
                                   @RequestParam(value = "rows", required = false) String rows, Income s_income, HttpServletResponse response)
            throws Exception {
        PageBean pageBean = new PageBean(Integer.parseInt(page), Integer.parseInt(rows));

        //调用业务逻辑，返回结果，包含两种，一个是总记录数，另一个是列表记录

        ResultBean<Income> resultBean = new ResultBean<Income>();
        resultBean.setTotal(100);
        List<Income> list = new ArrayList<Income>();
        for (int i = 0; i < 20; i++) {
            Income income = new Income();
            income.setIncomer("name" + i);
            list.add(income);
        }
        resultBean.setRows(list);
        return resultBean;
    }


}
