package cn.aka.mapper;

import cn.aka.pojo.Income;
import cn.aka.pojo.Pay;

import java.util.List;
import java.util.Map;

public interface InPayMapper {
    List<Income> findIncome(Map<String,Object> map);
    List<Income> getIncomeLine(Map<String,Object> map);
    List<Income> getIncomer();

    List<Pay> findPay(Map<String, Object> map);
    List<Pay> getPayLine(Map<String,Object> map);
    List<Pay> getPayer();
}
