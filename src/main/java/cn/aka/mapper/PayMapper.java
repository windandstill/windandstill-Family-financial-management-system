package cn.aka.mapper;

import cn.aka.pojo.Income;
import cn.aka.pojo.Pay;
import cn.aka.pojo.User;

import java.util.List;
import java.util.Map;

public interface PayMapper {
    List<Pay> findPay(Map map);
    Long getTotalPay(Pay pay);
    int updatePay(Pay pay);
    int addPay(Pay pay);
    int deletePay(Integer id);
    List<Pay> getPayer();

    List<User> getAllUsers(Map<String, Object> map);

    int findCount(Pay pay);
}
