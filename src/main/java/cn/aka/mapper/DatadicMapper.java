package cn.aka.mapper;

import cn.aka.pojo.Datadic;

import java.util.List;
import java.util.Map;

public interface DatadicMapper {
  /**
   * 根据字典名称查询字典数值
   */
  List<Datadic> findDatadicValueByName(String datadicName);

  /**
   * 查询所有字典名称
   */
  List<Datadic> findAllDataticName();

  /**
   * 分页条件查询数据字典
   */
  List<Datadic> findAllDatadicByPage(Map map);

  /**
   * 查询数据字典总条数
   */
  int findAllDatadicByTotal(Map map);

  /**
   * 添加数据字典
   */
  int addDatadic(Datadic datadic);

  /**
   * 查找存不存在该数据字典
   */
  Datadic findDatadicValueAndName(Datadic datadic);

  /**
   * 修改数据字典
   */
  int updateDatadic(Datadic datadic);

  /**
   * 删除数据字典
   */
  int deleteDatadic(Integer id);
}
