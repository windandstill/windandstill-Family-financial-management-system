package cn.aka.service.impl;

import cn.aka.mapper.SharesMapper;
import cn.aka.pojo.Shares;
import cn.aka.pojo.SharesVo;
import cn.aka.service.SharesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class SharesServiceImpl implements SharesService {
    @Autowired
    private SharesMapper sharesMapper;

    @Override
    public List<Shares> findShares(SharesVo vo) {
        return sharesMapper.findShares(vo);
    }

    @Override
    public int findCount(SharesVo vo) {
        return sharesMapper.findCount(vo);
    }

    @Override
    public int addShares(Shares shares) {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        shares.setCreatetime(sdf.format(date));
        return sharesMapper.addShares(shares);
    }

    @Override
    public int updateShares(Shares shares) {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        shares.setUpdatetime(sdf.format(date));
        return sharesMapper.updateShares(shares);
    }

    @Override
    public int deleteShares(Integer id) {
        return sharesMapper.deleteShares(id);
    }

    @Override
    public List<Shares> findShareName() {
        return sharesMapper.findShareName();
    }

}
