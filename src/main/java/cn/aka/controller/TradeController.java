package cn.aka.controller;

import cn.aka.pojo.*;
import cn.aka.service.DatadicService;
import cn.aka.service.SecurityService;
import cn.aka.service.SharesService;
import cn.aka.service.TradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class TradeController {
    @Autowired
    private DatadicService datadicService;
    @Autowired
    private SecurityService securityService;
    @Autowired
    private SharesService sharesService;

    @Autowired
    private TradeService tradeService;

    @RequestMapping("tradeManage")
    @ResponseBody
    public ModelAndView tradeManage(HttpServletRequest request) {
        ModelAndView mv = new ModelAndView();
        List<Datadic> datadics = datadicService.findDatadicValueByName("证券流水账类型");
        mv.addObject("trades",datadics);
        User user = (User) request.getSession().getAttribute("currentUser");
        Map<String, Object> userMap = new HashMap<String, Object>();
        userMap.put("userid", user.getId());
        userMap.put("roleid", user.getRoleid());
        List<User> allUsers = securityService.getAllUsers(userMap);
        mv.addObject("allUsers", allUsers);

        List<Shares> shares = sharesService.findShareName();
        mv.addObject("allShares",shares);
        return mv;
    }

    @RequestMapping("tradelist")
    @ResponseBody
    public ResultBean<Trade> list(@RequestParam(value = "page", required = false) String page,
                                  @RequestParam(value = "rows", required = false) String rows,TradeVo vo){
        ResultBean<Trade> resultBean = new ResultBean<>();
        PageBean pageBean = new PageBean((Integer.parseInt(page) - 1) * (Integer.parseInt(rows)), Integer.parseInt(rows));

        int total = tradeService.findCount(vo);
        resultBean.setTotal(total);
        List<Trade> trades = tradeService.findTrade(vo);
        resultBean.setRows(trades);
        return resultBean;
    }

    @RequestMapping("tradesave")
    @ResponseBody
    public Result save(Trade trade) {
        Result result = new Result();
        int total = 0;
        if (trade.getId() == null) {
            total = tradeService.addTrade(trade);
        }else {
            total = tradeService.updateTrade(trade);
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
    @RequestMapping("tradedelete")
    @ResponseBody
    public Result delete(@RequestParam(value = "ids")String ids) {
        Result result = new Result();
        int total = 0;
        String[] idsStr = ids.split(",");
        for (int i = 0; i < idsStr.length; i++) {
            tradeService.deleteTrade(Integer.parseInt(idsStr[i]));
        }
        result.setErrres(200);
        result.setErrmsg("删除成功!!!");
        return result;
    }
}
