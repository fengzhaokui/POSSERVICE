package xb.posservice.dao;

import java.util.List;

import xb.posservice.dao.vo.HIS_SALE_CLERK;
import xb.posservice.dao.vo.HIS_SALE_CLERKKey;
import xb.posservice.dao.vo.SALE_CLERK;
import xb.posservice.dao.vo.SALE_CLERKKey;

public interface HIS_SALE_CLERKMapper {
    int deleteByPrimaryKey(HIS_SALE_CLERKKey key);

    int insert(HIS_SALE_CLERK record);

    int insertSelective(HIS_SALE_CLERK record);

    HIS_SALE_CLERK selectByPrimaryKey(HIS_SALE_CLERKKey key);
    List<HIS_SALE_CLERK> selectByskt(SALE_CLERKKey key);
    int updateByPrimaryKeySelective(HIS_SALE_CLERK record);

    int updateByPrimaryKey(HIS_SALE_CLERK record);
}