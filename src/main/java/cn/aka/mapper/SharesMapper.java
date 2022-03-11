package cn.aka.mapper;

import cn.aka.pojo.Shares;
import cn.aka.pojo.SharesVo;

import java.util.List;

public interface SharesMapper {
    List<Shares> findShares(SharesVo vo);

    int findCount(SharesVo vo);

    int addShares(Shares shares);

    int updateShares(Shares shares);

    int deleteShares(Integer id);

    List<Shares> findShareName();
}
