package cn.aka.controller;

import cn.aka.pojo.*;
import cn.aka.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class RoleController {

    @Autowired
    private RoleService roleService;

    @RequestMapping("roleManage")
    public String roleManage() {
        return "roleManage";
    }

    @RequestMapping("rolelist")
    @ResponseBody
    public ResultBean<Role> rolelist(@RequestParam(value = "page", required = false) String page,
                                      @RequestParam(value = "rows", required = false) String rows, Role role){
        PageBean pageBean = new PageBean(Integer.parseInt(page), Integer.parseInt(rows));
        Map<String, Object> map = new HashMap<String, Object>();
        ResultBean<Role> roleResultBean = new ResultBean<Role>();
        map.put("rolename",role.getRolename());
        map.put("start",pageBean.getStart());
        map.put("pageSize",pageBean.getPageSize());
        List<Role> allRoleByPage = roleService.findAllRoleByPage(map);
        long total=allRoleByPage.size();
        roleResultBean.setTotal(total);
        roleResultBean.setRows(allRoleByPage);
        return roleResultBean;
    }

    @RequestMapping("rolesave")
    @ResponseBody
    public Result rolesave(Role role){
        Result result = new Result();
        int resultTotal = 0;
        List<Role> allRole = roleService.getAllRole();
        for (Role role1 : allRole){
            if (role1.getRolename().equals(role.getRolename())){
                result.setErrmsg("该角色已存在");
                return result;
            }
        }
        if (role.getId()!=null){
            resultTotal = roleService.updateRole(role);
            if (resultTotal<1){
                result.setErrmsg("修改失败");
            }else {
                result.setErrres(1);
                result.setErrmsg("修改成功");
            }

        }else {
            resultTotal = roleService.addRole(role);
            if (resultTotal<1){
                result.setErrmsg("添加失败");
            }else {
                result.setErrres(1);
                result.setErrmsg("添加成功");
            }
        }

        return result;
    }

}
