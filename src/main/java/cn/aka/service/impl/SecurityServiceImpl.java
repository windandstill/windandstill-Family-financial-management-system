package cn.aka.service.impl;

import cn.aka.mapper.SecurityMapper;
import cn.aka.pojo.Security;
import cn.aka.pojo.SecurityVo;
import cn.aka.pojo.User;
import cn.aka.service.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class SecurityServiceImpl implements SecurityService {

    @Autowired
    private SecurityMapper securityMapper;
    public List<Security> findSecurityById(SecurityVo vo) {
        return securityMapper.findSecurityById(vo);
    }

    @Override
    public int findCount(SecurityVo vo) {
        return securityMapper.findCount(vo);
    }

    @Override
    public List<User> getAllUsers(Map<String, Object> map) {
        return securityMapper.getAllUsers(map);
    }

    @Override
    public int addSecurity(Security security) {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        security.setCreatetime(sdf.format(date));
        return securityMapper.addSecurity(security);
    }

    @Override
    public int updateSecurity(Security security) {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        security.setUpdatetime(sdf.format(date));
        return securityMapper.updateSecurity(security);
    }

    @Override
    public int deleteSecurity(Integer id) {
        return securityMapper.deleteSecurity(id);
    }
}
