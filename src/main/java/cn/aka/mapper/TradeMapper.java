package cn.aka.mapper;

import cn.aka.pojo.Trade;
import cn.aka.pojo.TradeVo;

import java.util.List;

public interface TradeMapper {
    List<Trade> findTrade(TradeVo vo);

    int findCount(TradeVo vo);

    int addTrade(Trade trade);

    int updateTrade(Trade trade);

    int deleteTrade(Integer id);
}