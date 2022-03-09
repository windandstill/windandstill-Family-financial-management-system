package cn.aka.service;

import cn.aka.pojo.User;

import java.util.List;
import java.util.Map;

public interface UserService {
    User findUserAndRoleByNP(User user);


    User findUserByUsername(User user);

    void insertUser(User user);

    /**
     * 根据uid注册用户等级
     */
    void insertUserRole(User user);

    /**
     * 查询所有用户的数量
     */
    int findTotalUser(Map<String, Object> map);

    /**
     * 分页查询所有用户
     */
    List<User> findAllUserByPage(Map<String, Object> map);
}
