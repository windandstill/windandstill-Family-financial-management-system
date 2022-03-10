package cn.aka.mapper;

import cn.aka.pojo.User;

import java.util.List;
import java.util.Map;

public interface UserMapper {


    User findUserAndRoleByNP(User user);

    /**
     * 根据用户名,密码,角色编号来查询user
     */
    User findUserByUsername(User user);

    /**
     * 根据用户名和密码注册用户
     */
    int addUser(User user);

    /**
     * 根据uid注册用户等级
     */
    int addUserRole(User user);

    /**
     * 查询所有用户的数量
     */
    int findTotalUser(Map<String, Object> map);

    /**
     * 查询所有用户
     */
    List<User> findAllUserByPage(Map<String, Object> map);

    /**
     * 修改用户
     */
    int updateUser(User user);

    /**
     * 删除用户
     */
    int deleteUser(Integer id);

    /**
     * 删除用户时删除用户角色联立表中数据
     */
    int deleteUserRole(Integer id);
}
