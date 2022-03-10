package cn.aka.controller;

import cn.aka.pojo.*;
import cn.aka.service.DatadicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.sql.ResultSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    @ResponseBody
    public ResultBean<Datadic> findAllDatadicByPage(@RequestParam(value = "page", required = false) String page,
                                                    @RequestParam(value = "rows", required = false) String rows, Datadic datadic){
        PageBean pageBean = new PageBean(Integer.parseInt(page), Integer.parseInt(rows));
        Map<String, Object> map = new HashMap<String, Object>();
        ResultBean<Datadic> datadicResultBean = new ResultBean<>();
        map.put("id",datadic.getId());
        map.put("datadicname",datadic.getDatadicname());
        map.put("datadicvalue",datadic.getDatadicvalue());
        map.put("start",pageBean.getStart());
        map.put("pageSize",pageBean.getPageSize());
        datadicResultBean.setTotal(datadicService.findAllDatadicByTotal(map));
        datadicResultBean.setRows(datadicService.findAllDatadicByPage(map));
        return datadicResultBean;
    }

    /**
     * 添加数据字典
     */
    @RequestMapping("datadicsave")
    @ResponseBody
    public Result datadicsave(Datadic datadic){
        Result result = new Result();
        int resultTotal=0;
        Datadic datadicValueAndName = datadicService.findDatadicValueAndName(datadic);
        if (datadic.getId()!=null){
            if(datadicValueAndName==null){
            resultTotal=datadicService.updateDatadic(datadic);
            if (resultTotal==1){
                result.setErrres(1);
                result.setErrmsg("修改成功!");
            }else {
                result.setErrmsg("修改失败!");
            }
            }else {
                result.setErrmsg("修改失败!,已经有该数据字典了");
            }
        }else {
            if (datadicValueAndName==null){
                resultTotal= datadicService.addDatadic(datadic);
                if (resultTotal==1){
                    result.setErrres(1);
                    result.setErrmsg("添加成功!");
                }else {
                    result.setErrmsg("添加失败!");
                }
            }else {
                result.setErrmsg("添加失败!,已经有该数据字典了");
            }
        }
        return result;
    }
}
