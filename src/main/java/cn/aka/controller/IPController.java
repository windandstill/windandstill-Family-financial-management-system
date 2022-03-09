package cn.aka.controller;


import cn.aka.pojo.Income;
import cn.aka.pojo.Pay;
import cn.aka.service.InPayService;
import cn.aka.util.ResponseUtil;
import cn.aka.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class IPController {
    @Autowired
    private InPayService inPayService;

    @RequestMapping("/incomeTimeManage.do")
    public String incomeTimeManage() {
        return "incomeTimeManage";
    }


    @RequestMapping("/produceIncomeTime.do")
    public String produceIncomeTime(Income s_income, HttpServletResponse response) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("incomer", StringUtil.formatLike(s_income.getIncomer()));
        map.put("starttime", s_income.getStarttime());
        map.put("endtime", s_income.getEndtime());
        map.put("roleid", s_income.getRoleid());
        map.put("userid", s_income.getUserid());
        List<Income> incomeList = inPayService.getIncomeLine(map);
        List<Income> incomers = inPayService.getIncomer();


        String curincomer;
        JSONArray incomeArray, obj;
        JSONObject result;

        JSONArray outerobj = new JSONArray();
        for (int i = 0; i < incomers.size(); i++) {
            curincomer = incomers.get(i).getIncomer();
            incomeArray = new JSONArray();
            for (int j = 0; j < incomeList.size(); j++) {
                obj = new JSONArray();
                if (incomeList.get(j).getIncomer().equals(curincomer)) {
                    obj.add(incomeList.get(j).getIncometime());
                    obj.add(incomeList.get(j).getMoney());
                    incomeArray.add(obj);
                }
            }
            if (incomeArray.size() > 0) {
                result = new JSONObject();
                result.put("name", curincomer);
                result.put("data", incomeArray);
                outerobj.add(result);
            }
        }
        ResponseUtil.write(response, outerobj);
        return null;
    }
    @RequestMapping("/payTimeManage.do")
    public String payTimeManage() {
        return "payTimeManage";
    }

    /**
     * （时间-金额）生成支出曲线
     * @param s_pay
     * @param response
     * @return
     */
    @RequestMapping("/producePayTime.do")
    public String producePayLine(Pay s_pay, HttpServletResponse response) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("payer", StringUtil.formatLike(s_pay.getPayer()));
        map.put("starttime", s_pay.getStarttime());
        map.put("endtime", s_pay.getEndtime());
        map.put("roleid", s_pay.getRoleid());
        map.put("userid", s_pay.getUserid());
        List<Pay> payList = inPayService.getPayLine(map);
        List<Pay> payers = inPayService.getPayer();

        String curpayer;
        JSONArray payArray,obj;
        JSONObject result;

        JSONArray outerobj = new JSONArray();
        for(int i=0;i<payers.size();i++){
            curpayer = payers.get(i).getPayer();
            payArray = new JSONArray();
            for(int j = 0; j < payList.size(); j++) {
                obj = new JSONArray();
                if(payList.get(j).getPayer().equals(curpayer)){
                    obj.add(payList.get(j).getPaytime());
                    obj.add(payList.get(j).getMoney());
                    payArray.add(obj);
                }
            }
            if(payArray.size()>0){
                result = new JSONObject();
                result.put("name", curpayer);
                result.put("data", payArray);
                outerobj.add(result);
            }
        }
        ResponseUtil.write(response, outerobj);
        return null;
    }
}


