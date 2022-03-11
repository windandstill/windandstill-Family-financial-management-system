package cn.aka.controller;

import cn.aka.pojo.*;
import cn.aka.service.DatadicService;
import cn.aka.service.PayService;
import cn.aka.service.PayService;
import cn.aka.service.SecurityService;
import cn.aka.service.UserService;
import cn.aka.util.ResponseUtil;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
public class PayController {
    @Autowired
    private DatadicService datadicService;

    @Autowired
    private PayService payService;

    @Autowired
    private UserService userService;

    @Autowired
    private SecurityService securityService;

    @RequestMapping("payManage")
    @ResponseBody
    public ModelAndView payManage(HttpServletRequest request) {
        ModelAndView mv = new ModelAndView();
        List<Datadic> datadics = datadicService.findDatadicValueByName("支出类型");
        mv.addObject("pays", datadics);
        User user = (User) request.getSession().getAttribute("currentUser");
        Map<String, Object> userMap = new HashMap<String, Object>();
        userMap.put("userid", user.getId());
        userMap.put("roleid", user.getRoleid());
        List<User> allUsers = securityService.getAllUsers(userMap);
        mv.addObject("allUsers",allUsers);
        return mv;
    }
    @RequestMapping("paylist")
    public String list(@RequestParam(value = "page", required = false) String page,
                       @RequestParam(value = "rows", required = false) String rows, Pay s_pay, HttpServletResponse response)
            throws Exception {
        PageBean pageBean = new PageBean(Integer.parseInt(page), Integer.parseInt(rows));
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("payer", s_pay.getPayer());
        map.put("tword", s_pay.getTword());
        map.put("dataid", s_pay.getDataid());
        map.put("starttime", s_pay.getStarttime());
        map.put("endtime", s_pay.getEndtime());
        map.put("roleid", s_pay.getRoleid());
        map.put("userid", s_pay.getUserid());
        map.put("start", pageBean.getStart());
        map.put("size", pageBean.getPageSize());
        List<Pay> payList = payService.findPay(s_pay);
        Long total = payService.getTotalPay(s_pay);
        JSONObject result = new JSONObject();
        JSONArray jsonArray = JSONArray.fromObject(payList);
        result.put("rows", jsonArray);
        result.put("total", total);
        ResponseUtil.write(response, result);
        return null;
    }
    @RequestMapping("paysave")
    @ResponseBody
    public Result save(Pay pay) {
        Result result = new Result();
        int total = 0;
        if (pay.getId() == null) {
            total = payService.addPay(pay);
        }else {
            total = payService.updatePay(pay);
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

    @RequestMapping("paydelete")
    @ResponseBody
    public Result delete(@RequestParam(value = "ids")String ids) {
        Result result = new Result();
        int total = 0;
        String[] idsStr = ids.split(",");
        for (int i = 0; i < idsStr.length; i++) {
            payService.deletePay(Integer.parseInt(idsStr[i]));
        }
        result.setErrres(200);
        result.setErrmsg("删除成功!!!");
        return result;
    }

}
