package cn.aka.service.impl;

import cn.aka.mapper.RoleMapper;
import cn.aka.pojo.Role;
import cn.aka.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service
public class RoleServiceImpl implements RoleService {

@Autowired
private RoleMapper roleMapper;

    @Override
    public List<Role> getAllRole() {
        return roleMapper.getAllRole();
    }

    @Override
    public List<Role> findAllRoleByPage(Map<String, Object> map) {
        return roleMapper.findAllRoleByPage(map);
    }
}
