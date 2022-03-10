package cn.aka.service.impl;

import cn.aka.mapper.DatabaseMapper;
import cn.aka.pojo.Database;
import cn.aka.service.DatabaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("databaseService")
public class DatabaseServiceImpl implements DatabaseService {
    @Autowired
    private DatabaseMapper databaseMapper;
    @Override
    public List<Database> findDataBack(Database database) {
        return databaseMapper.findDataBack(database);
    }

    @Override
    public Long getDataBackTotal(Database database) {
        return databaseMapper.getDataBackTotal(database);
    }

    @Override
    public int addDatabase(Database database) {
        return databaseMapper.addDatabase(database);
    }

    @Override
    public int deleteDatabase(Integer id) {
        return databaseMapper.deleteDatabase(id);
    }

    @Override
    public int truncateTable(String tablename) {
        return databaseMapper.truncateTable(tablename);
    }

    @Override
    public int deleteOrderdata(String tablename, Integer startid, Integer endid) {
        return databaseMapper.deleteOrderdata(tablename,startid,endid);
    }
}
