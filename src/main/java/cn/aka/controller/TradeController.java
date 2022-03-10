package cn.aka.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TradeController {

    @RequestMapping("tradeManage")
    @ResponseBody
    public ModelAndView tradeManage() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("tradeManage");
        return mv;
    }


}
