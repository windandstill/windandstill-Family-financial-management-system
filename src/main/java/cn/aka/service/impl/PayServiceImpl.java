package cn.aka.service.impl;

import cn.aka.mapper.PayMapper;
import cn.aka.pojo.Income;
import cn.aka.pojo.Pay;
import cn.aka.pojo.User;
import cn.aka.service.PayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
@Service
public class PayServiceImpl implements PayService {
    @Autowired
    private PayMapper payMapper;
    @Override
    public List<Pay> findPay(Map map) {
        return payMapper.findPay(map);
    }

    @Override
    public Long getTotalPay(Pay pay) {
        return payMapper.getTotalPay(pay);
    }

    @Override
    public int updatePay(Pay pay) {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        pay.setUpdatetime(sdf.format(date));
        return payMapper.updatePay(pay);
    }

    @Override
    public int addPay(Pay pay) {

        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        pay.setCreatetime(sdf.format(date));
        return payMapper.addPay(pay);
    }

    @Override
    public int deletePay(Integer id) {
        return payMapper.deletePay(id);
    }

    @Override
    public List<Pay> getPayer() {
        return payMapper.getPayer();
    }

    @Override
    public List<User> getAllUsers(Map<String, Object> map) {
        return payMapper.getAllUsers(map);
    }

    @Override
    public int findCount(Pay pay) {
        return payMapper.findCount(pay);
    }
}
