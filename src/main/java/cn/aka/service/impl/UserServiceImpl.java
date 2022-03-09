package cn.aka.service.impl;

import cn.aka.mapper.UserMapper;
import cn.aka.pojo.User;
import cn.aka.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    public User findUserAndRoleByNP(User user) {
        return userMapper.findUserAndRoleByNP(user);
    }

    /**
     * 通过姓名查找用户
     */
    public User findUserByUsername(User user) {
        return userMapper.findUserByUsername(user);
    }

    /**
     * 通过用户名和密码来注册用户
     */
    public void insertUser(User user) {
        userMapper.insertUser(user);
    }

    /**
     * 根据uid注册用户等级
     */
    public void insertUserRole(User user){
        userMapper.insertUserRole(user);
    }

    /**
     * 查询所有用户的数量
     */
    public int findTotalUser(Map<String, Object> map) {
        return userMapper.findTotalUser(map);
    }

    /**
     * 分页查找所有用户
     */
    public List<User> findAllUserByPage(Map<String, Object> map) {
        return userMapper.findAllUserByPage(map);
    }
}
