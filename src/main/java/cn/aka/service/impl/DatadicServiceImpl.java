package cn.aka.service.impl;

import cn.aka.mapper.DatadicMapper;
import cn.aka.pojo.Datadic;
import cn.aka.service.DatadicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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
}
