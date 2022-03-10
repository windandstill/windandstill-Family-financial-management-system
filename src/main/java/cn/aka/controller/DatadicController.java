package cn.aka.controller;

import cn.aka.pojo.Datadic;
import cn.aka.pojo.ResultBean;
import cn.aka.pojo.Role;
import cn.aka.service.DatadicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class DatadicController {
    @Autowired
    private DatadicService datadicService;


    /**
     * 显示所有数据字典名称
     */
    @RequestMapping("datadicManage")
    public ModelAndView datadicManage(ModelAndView modelAndView) {
        modelAndView.addObject("datadicnames",datadicService.findAllDataticName());
        modelAndView.setViewName("datadicManage");
        return modelAndView;
    }

    /**
     * 分页查找
     */
    @RequestMapping("datadiclist")
    public ResultBean<Datadic> findAllDatadicByPage(@RequestParam(value = "page", required = false) String page,
                                                    @RequestParam(value = "rows", required = false) String rows, Datadic datadic){

        ResultBean<Datadic> datadicResultBean = new ResultBean<>();
        return datadicResultBean;
    }


}
