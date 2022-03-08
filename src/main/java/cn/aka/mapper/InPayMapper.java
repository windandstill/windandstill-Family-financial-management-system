package cn.aka.mapper;

import cn.aka.pojo.Income;
import cn.aka.pojo.Pay;
import cn.aka.pojo.Result;

import java.util.List;

public interface InPayMapper {
    List<Income> findByUserIdI(Income income);
    List<Pay>  findByUserIdP(Pay pay);
    List<Result> findByUserIdT(Result result);
}
