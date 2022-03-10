package cn.aka.service;

import cn.aka.pojo.Income;
import cn.aka.pojo.SecurityVo;
import cn.aka.pojo.User;

import java.util.List;
import java.util.Map;

public interface IncomeService {
    List<Income> findIncome(Income income);
    Long getTotalIncome(Income income);
    int updateIncome(Income  income);
    int addIncome(Income income);
    int deleteIncome(Integer id);
    List<Income> getIncomer();
    List<User> getAllUsers(Map<String,Object> map);
    int findCount(Income income);
}
