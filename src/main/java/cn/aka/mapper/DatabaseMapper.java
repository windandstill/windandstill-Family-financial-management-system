package cn.aka.mapper;


import cn.aka.pojo.Database;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface DatabaseMapper {
    /**
     * 查询数据库备份记录
     * @param
     * @return
     */
List<Database> findDataBack(Database database);

    /**
     * 获取数据库备份记录数
     * @param
     * @return
     */
 Long getDataBackTotal(Database database);



 int addDatabase(Database database);

    /**
     * 删除数据库操作记录
     * @param id
     * @return
     */
  int deleteDatabase(Integer id);

    /**
     * 清空数据库
     * @param
     * @return
     */
 int truncateTable(@Param("tablename") String tablename);

    /**
     * 数据库整理
     * @param
     * @return
     */
 int deleteOrderdata(@Param("tablename") String tablename,@Param("startid") Integer startid,@Param("endid") Integer endid);
}




