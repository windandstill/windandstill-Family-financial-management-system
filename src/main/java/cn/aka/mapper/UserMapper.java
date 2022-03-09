package cn.aka.mapper;

import cn.aka.pojo.PageBean;
import cn.aka.pojo.User;

import java.util.List;

public interface UserMapper {


    User findUserAndRoleByNP(User user);

    /**
     * 根据用户名,密码,角色编号来查询user
     */
    User findUserByUsername(User user);

    /**
     * 根据用户名和密码注册用户
     */
    void insertUser(User user);

    /**
     * 根据uid注册用户等级
     */
    void insertUserRole(User user);

    /**
     * 查询所有用户的数量
     */
    int findTotalUser();

    /**
     * 查询所有用户
     * @param pageBean
     */
    List<User> findAllUserByPage(PageBean pageBean);
}
