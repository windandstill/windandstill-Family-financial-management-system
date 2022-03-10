package cn.aka.controller;

import cn.aka.pojo.PageBean;
import cn.aka.pojo.ResultBean;
import cn.aka.pojo.Role;
import cn.aka.pojo.User;
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

    @RequestMapping("/rolelist")
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


}
