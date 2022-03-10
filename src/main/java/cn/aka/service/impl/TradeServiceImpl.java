package cn.aka.service.impl;

import cn.aka.mapper.TradeMapper;
import cn.aka.pojo.Trade;
import cn.aka.pojo.TradeVo;
import cn.aka.service.TradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
@Service
public class TradeServiceImpl implements TradeService {

    @Autowired
    private TradeMapper tradeMapper;

    @Override
    public List<Trade> findTrade(TradeVo vo) {
        return tradeMapper.findTrade(vo);
    }

    @Override
    public int findCount(TradeVo vo) {
        return tradeMapper.findCount(vo);
    }

    @Override
    public int addTrade(Trade trade) {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        trade.setCreatetime(sdf.format(date));
        return tradeMapper.addTrade(trade);
    }

    @Override
    public int updateTrade(Trade trade) {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        trade.setUpdatetime(sdf.format(date));
        return tradeMapper.updateTrade(trade);
    }

    @Override
    public int deleteTrade(Integer id) {
        return tradeMapper.deleteTrade(id);
    }
}
