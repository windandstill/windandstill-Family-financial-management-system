package cn.aka.mapper;


import cn.aka.pojo.Security;
import cn.aka.pojo.SecurityVo;
import cn.aka.pojo.User;

import java.util.List;
import java.util.Map;

/**
 * 财务管理
 */

public interface SecurityMapper {

    List<Security> findSecurityById(SecurityVo vo);

    /**
     * 查询总记录数
     */
    int findCount(SecurityVo vo);

    /**
     * 查询所有用户
     */
    List<User> getAllUsers(Map<String, Object> map);

    /**
     * 添加用户
     */
    int addSecurity(Security security);

    /**
     * 修改用户
     */
    int updateSecurity(Security security);


    /**
     * 删除用户
     */
    int deleteSecurity(Integer id);

}
