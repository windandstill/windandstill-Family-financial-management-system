package cn.aka.service;

import cn.aka.pojo.Security;
import cn.aka.pojo.SecurityVo;
import cn.aka.pojo.User;

import java.util.List;
import java.util.Map;

public interface SecurityService {

    List<Security> findSecurityById(SecurityVo vo);
    int findCount(SecurityVo vo);
    /**
     * 查询所有用户
     */
    List<User> getAllUsers(Map<String,Object> map);
    int addSecurity(Security security);
    int updateSecurity(Security security);
    int deleteSecurity(Integer id);

}
