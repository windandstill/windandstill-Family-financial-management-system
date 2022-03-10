package cn.aka.service;

import cn.aka.pojo.Role;

import java.util.List;
import java.util.Map;

public interface RoleService {
    List<Role> getAllRole();

    List<Role> findAllRoleByPage(Map<String, Object> map);
}
