package cn.aka.service.impl;

import cn.aka.mapper.UserMapper;
import cn.aka.pojo.User;
import cn.aka.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import java.util.List;
import java.util.Map;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User findUserAndRoleByNP(User user) {
        return userMapper.findUserAndRoleByNP(user);
    }

    /**
     * 通过姓名查找用户
     */
    @Override
    public User findUserByUsername(User user) {
        return userMapper.findUserByUsername(user);
    }

    /**
     * 通过用户名和密码来注册用户
     */
    @Override
    public int addUser(User user) {
        return userMapper.addUser(user);
    }

    /**
     * 根据uid注册用户等级
     */
    @Override
    public int addUserRole(User user){
        return userMapper.addUserRole(user);
    }

    /**
     * 查询所有用户的数量
     */
    @Override
    public int findTotalUser(Map<String, Object> map) {
        return userMapper.findTotalUser(map);
    }

    /**
     * 分页查找所有用户
     */
    @Override
    public List<User> findAllUserByPage(Map<String, Object> map) {
        return userMapper.findAllUserByPage(map);
    }

    /**
     * 修改用户
     */
    @Override
    public int updateUser(User user) {
        return userMapper.updateUser(user);
    }

    /**
     * 删除用户
     */
    @Override
    public int deleteUser(Integer id) {
        return userMapper.deleteUser(id);
    }


}
