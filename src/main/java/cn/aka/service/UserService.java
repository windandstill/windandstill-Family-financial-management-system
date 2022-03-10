package cn.aka.service;

import cn.aka.pojo.User;

import java.util.List;
import java.util.Map;

public interface UserService {
    User findUserAndRoleByNP(User user);


    User findUserByUsername(User user);

    void addUser(User user);

    /**
     * 根据uid注册用户等级
     */
    void addUserRole(User user);

    /**
     * 查询所有用户的数量
     */
    int findTotalUser(Map<String, Object> map);

    /**
     * 分页查询所有用户
     */
    List<User> findAllUserByPage(Map<String, Object> map);

    /**
     * 修改用户
     */
    void updateUser(User user);

    /**
     * 删除用户
     */
    void deleteUser(Integer id);
}
