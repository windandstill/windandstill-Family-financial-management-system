package cn.aka.controller;

import cn.aka.pojo.Security;
import cn.aka.pojo.Shares;
import cn.aka.pojo.User;
import cn.aka.service.SecurityService;
import cn.aka.service.SharesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class TradeController {
    @Autowired
    private SecurityService securityService;
    @Autowired
    private SharesService sharesService;

    @RequestMapping("tradeManage")
    @ResponseBody
    public ModelAndView tradeManage(HttpServletRequest request) {
        ModelAndView mv = new ModelAndView();

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


}
