package cn.aka.mapper;

import cn.aka.pojo.Role;

import java.util.List;
import java.util.Map;

public interface RoleMapper {

    List<Role> getAllRole();

    List<Role> findAllRoleByPage(Map<String, Object> map);

}
