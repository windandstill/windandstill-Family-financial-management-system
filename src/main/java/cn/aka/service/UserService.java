package cn.aka.service;

import cn.aka.pojo.User;

import java.util.List;
import java.util.Map;

public interface UserService {
    User findUserAndRoleByNP(User user);
    List<User> getAllUsers(Map<String,Object> map);

}
