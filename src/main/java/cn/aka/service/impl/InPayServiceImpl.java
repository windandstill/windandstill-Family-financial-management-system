package cn.aka.service.impl;

import cn.aka.mapper.InPayMapper;
import cn.aka.pojo.Datadic;
import cn.aka.pojo.Income;
import cn.aka.pojo.Pay;
import cn.aka.pojo.Result;
import cn.aka.service.InPayService;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class InPayServiceImpl implements InPayService {
    @Autowired
    private InPayMapper inPayMapper;


    public List<Income> getIncomeLine(Map<String, Object> map) {
        return inPayMapper.getIncomeLine(map);
    }

    public List<Income> getIncomer() {
        return inPayMapper.getIncomer();
    }



    public List<Pay> getPayLine(Map<String, Object> map) {
        return inPayMapper.getPayLine(map);
    }

    public List<Pay> getPayer() {
        return inPayMapper.getPayer();
    }

    public List<Datadic> getDatadicPay() {
        return inPayMapper.getDatadicPay();
    }

    public List<Datadic> getDatadicIncome() {
        return inPayMapper.getDatadicIncome();
    }


}
