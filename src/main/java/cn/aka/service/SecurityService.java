package cn.aka.service;

import cn.aka.pojo.Security;
import cn.aka.pojo.SecurityVo;
import cn.aka.pojo.User;

import java.util.List;

public interface SecurityService {

    List<Security> findSecurityById(SecurityVo vo);
    int findCount(SecurityVo vo);
}
