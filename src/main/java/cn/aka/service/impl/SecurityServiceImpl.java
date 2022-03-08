package cn.aka.service.impl;

import cn.aka.mapper.FinancialMapper;
import cn.aka.pojo.Security;
import cn.aka.service.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SecurityServiceImpl implements SecurityService {

    @Autowired
    private FinancialMapper financialMapper;
    public List<Security> findSecurityById() {
        return financialMapper.findSecurityById();
    }
}
