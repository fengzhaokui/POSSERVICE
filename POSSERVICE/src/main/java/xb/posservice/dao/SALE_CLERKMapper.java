package xb.posservice.dao;

import java.util.List;

import xb.posservice.dao.vo.SALE_CLERK;
import xb.posservice.dao.vo.SALE_CLERKKey;
import xb.posservice.dao.vo.SALE_DETAIL;
import xb.posservice.dao.vo.SALE_DETAILKey;

public interface SALE_CLERKMapper {
    int deleteByPrimaryKey(SALE_CLERKKey key);

    int insert(SALE_CLERK record);

    int insertSelective(SALE_CLERK record);

    SALE_CLERK selectByPrimaryKey(SALE_CLERKKey key);
    List<SALE_CLERK> selectByskt(SALE_CLERKKey key);
    int updateByPrimaryKeySelective(SALE_CLERK record);

    int updateByPrimaryKey(SALE_CLERK record);
}