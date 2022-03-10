package cn.aka.service.impl;

import cn.aka.mapper.IncomeMapper;
import cn.aka.pojo.Income;
import cn.aka.pojo.SecurityVo;
import cn.aka.pojo.User;
import cn.aka.service.IncomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class IncomeServiceImpl implements IncomeService {
    @Autowired
    private IncomeMapper incomeMapper;
    @Override
    public List<Income> findIncome(Income income) {
        return incomeMapper.findIncome(income);
    }

    @Override
    public Long getTotalIncome(Income income) {
        return incomeMapper.getTotalIncome(income);
    }

    @Override
    public int updateIncome(Income income) {
        return incomeMapper.updateIncome(income);
    }

    @Override
    public int addIncome(Income income) {
        return incomeMapper.addIncome(income);
    }

    @Override
    public int deleteIncome(Integer id) {
        return incomeMapper.deleteIncome(id);
    }

    @Override
    public List<Income> getIncomer() {
        return incomeMapper.getIncomer();
    }
    @Override
    public List<User> getAllUsers(Map<String, Object> map) {
        return incomeMapper.getAllUsers(map);
    }
    @Override
    public int findCount(Income income) {
        return incomeMapper.findCount(income);
    }
}
