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

    @Override
    public List<User> getAllUsers(Map<String,Object> map) {
        return userMapper.getAllUsers(map);
    }
}
