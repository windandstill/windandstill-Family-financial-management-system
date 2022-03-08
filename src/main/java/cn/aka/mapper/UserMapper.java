package cn.aka.mapper;

import cn.aka.pojo.User;

import java.util.List;

public interface UserMapper {

    /**
     * 根据用户名,密码,角色编号来查询user
     * @param user
     * @return
     */
    User findUserAndRoleByNP(User user);
}
