package cn.aka.mapper;

import cn.aka.pojo.Datadic;

import java.util.List;

public interface DatadicMapper {
  /**
   * 根据字典名称查询字典数值
   */
  List<Datadic> findDatadicValueByName(String datadicName);

  /**
   * 查询所有字典名称
   */
  List<Datadic> findAllDataticName();
}
