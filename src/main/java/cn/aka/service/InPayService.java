package cn.aka.service;

import cn.aka.pojo.Income;
import cn.aka.pojo.Pay;

import java.util.List;
import java.util.Map;

public interface InPayService {
    List<Income> findIncome(Map<String,Object> map);
    List<Income> getIncomeLine(Map<String,Object> map);
    List<Income> getIncomer();

    List<Pay> findPay(Map<String, Object> map);
    List<Pay> getPayLine(Map<String,Object> map);
    List<Pay> getPayer();
}
