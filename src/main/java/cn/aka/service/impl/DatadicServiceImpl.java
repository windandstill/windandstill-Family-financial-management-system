package cn.aka.service.impl;

import cn.aka.mapper.DatadicMapper;
import cn.aka.pojo.Datadic;
import cn.aka.service.DatadicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class DatadicServiceImpl implements DatadicService {

    @Autowired
    private DatadicMapper datadicMapper;

    /**
     * 根据字典名称查询字典数值
     */
    @Override
    public List<Datadic> findDatadicValueByName(String datadicName) {
        return datadicMapper.findDatadicValueByName(datadicName);
    }


    /**
     * 查询所有字典名称
     */
    @Override
    public List<Datadic> findAllDataticName(){
        return datadicMapper.findAllDataticName();
    }

    /**
     * 分页查找数据字典
     */
    @Override
    public List<Datadic> findAllDatadicByPage(Map map) {
        return datadicMapper.findAllDatadicByPage(map);
    }

    /**
     * 查找总数
     */
    @Override
    public int findAllDatadicByTotal(Map map) {
        return datadicMapper.findAllDatadicByTotal(map);
    }

    /**
     * 添加数据字典
     */
    @Override
    public int addDatadic(Datadic datadic) {
        return datadicMapper.addDatadic(datadic);
    }

    /**
     * 查找存不存在该数据字典
     */
    @Override
    public Datadic findDatadicValueAndName(Datadic datadic) {
        return datadicMapper.findDatadicValueAndName(datadic);
    }

    /**
     * 修改数据字典
     */
    @Override
    public int updateDatadic(Datadic datadic) {
        return datadicMapper.updateDatadic(datadic);
    }

}
