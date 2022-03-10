package cn.aka.controller;

import cn.aka.pojo.*;
import cn.aka.service.SecurityService;
import cn.aka.service.SharesService;
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
public class SharesController {

    @Autowired
    private SecurityService securityService;

    @Autowired
    private SharesService sharesService;

    @RequestMapping("sharesManage")
    public ModelAndView sharesManage(HttpServletRequest request) {
        ModelAndView mv = new ModelAndView();
        List<Security> securities = securityService.getAllSecurity();
        mv.addObject("allSecuritys", securities);
        User user = (User) request.getSession().getAttribute("currentUser");
        Map<String, Object> userMap = new HashMap<String, Object>();
        userMap.put("userid", user.getId());
        userMap.put("roleid", user.getRoleid());
        List<User> allUsers = securityService.getAllUsers(userMap);
        mv.addObject("allUsers", allUsers);
        return mv;
    }

    @RequestMapping("shareslist")
    @ResponseBody
    public ResultBean<Shares> list(@RequestParam(value = "page", required = false) String page,
                                   @RequestParam(value = "rows", required = false) String rows, SharesVo vo) {
        ResultBean<Shares> resultBean = new ResultBean<>();
        PageBean pageBean = new PageBean((Integer.parseInt(page) - 1) * (Integer.parseInt(rows)), Integer.parseInt(rows));

        int total = sharesService.findCount(vo);
        resultBean.setTotal(total);
        List<Shares> shares = sharesService.findShares(vo);
        resultBean.setRows(shares);
        return resultBean;
    }

    @RequestMapping("sharessave")
    @ResponseBody
    public Result save(Shares shares) {
        Result result = new Result();
        int total = 0;
        if (shares.getId() == null) {
            total = sharesService.addShares(shares);
        }else {
            total = sharesService.updateShares(shares);
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


    @RequestMapping("sharesdelete")
    @ResponseBody
    public Result delete(@RequestParam(value = "ids")String ids) {
        Result result = new Result();
        int total = 0;
        String[] idsStr = ids.split(",");
        for (int i = 0; i < idsStr.length; i++) {
            sharesService.deleteShares(Integer.parseInt(idsStr[i]));
        }
        result.setErrres(200);
        result.setErrmsg("删除成功!!!");
        return result;
    }
}
