package cn.aka.service.impl;

import cn.aka.mapper.RoleMapper;
import cn.aka.pojo.Role;
import cn.aka.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service
public class RoleServiceImpl implements RoleService {

@Autowired
private RoleMapper roleMapper;
    /**
     * 获取所有角色
     */
    @Override
    public List<Role> getAllRole() {
        return roleMapper.getAllRole();
    }

    /**
     * 分页查找所有角色
     */
    @Override
    public List<Role> findAllRoleByPage(Map<String, Object> map) {
        return roleMapper.findAllRoleByPage(map);
    }

    /**
     * 添加角色
     */
    @Override
    public int addRole(Role role) {
        return roleMapper.addRole(role);
    }

    /**
     * 修改角色
     */
    @Override
    public int updateRole(Role role) {
        return roleMapper.update(role);
    }

    /**
     * 删除角色
     */
    @Override
    public int deleteRole(Integer id) {
        return roleMapper.deleteRole(id);
    }

    @Override
    public int findUserAndRoleByRoleId(Integer id) {
        return roleMapper.findUserAndRoleByRoleId(id);
    }
}
