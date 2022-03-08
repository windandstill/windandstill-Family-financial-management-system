package cn.aka.mapper;


import cn.aka.pojo.Security;

import java.util.List;

/**
 * 财务管理
 */

public interface FinancialMapper {

List<Security> findSecurityById();
}
