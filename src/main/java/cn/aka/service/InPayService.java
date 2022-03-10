package cn.aka.service;

import cn.aka.pojo.Datadic;
import cn.aka.pojo.Income;
import cn.aka.pojo.Pay;
import cn.aka.pojo.Result;

import java.util.List;
import java.util.Map;

public interface InPayService {
    //    List<Income> getIncomeLine(Income income);
    List<Income> getIncomeLine(Map<String,Object> map);
    List<Income> getIncomer();

    List<Pay> getPayLine(Map<String,Object> map);
    List<Pay> getPayer();


    List<Datadic> getDatadicPay();
    List<Datadic> getDatadicIncome();
}
