package cn.aka.mapper;


import cn.aka.pojo.Security;
import cn.aka.pojo.SecurityVo;
import cn.aka.pojo.User;

import java.util.List;

/**
 * 财务管理
 */

public interface SecurityMapper {

List<Security> findSecurityById(SecurityVo vo);
int findCount(SecurityVo vo);
}
