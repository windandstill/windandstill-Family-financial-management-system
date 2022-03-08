package cn.aka.service;

import cn.aka.pojo.User;

import java.util.List;

public interface UserService {
    User findUserAndRoleByNP(User user);

    User findUserByUsername(User user);

    void insertUser(User user);
    /**
     * 根据uid注册用户等级
     */
    void insertUserRole(User user);
}
