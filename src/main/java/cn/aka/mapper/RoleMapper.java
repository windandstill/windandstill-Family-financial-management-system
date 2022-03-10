package cn.aka.mapper;

import cn.aka.pojo.Role;

import java.util.List;
import java.util.Map;

public interface RoleMapper {

    /**
     * 获取所有角色
     */
    List<Role> getAllRole();


    /**
     * 分页条件查找角色
     */
    List<Role> findAllRoleByPage(Map<String, Object> map);

    /**
     * 添加角色
     * @param role
     */
    int addRole(Role role);

    /**
     * 修改角色
     */
    int update(Role role);

    /**
     * 删除角色
     */
    int deleteRole(Integer id);

    /**
     * 根据id查找user与role联立表中元素
     */
    int findUserAndRoleByRoleId(Integer id);

}
