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

    @Override
    public List<Datadic> findDatadicSecurity() {
        return datadicMapper.findDatadicSecurity();
    }
}
