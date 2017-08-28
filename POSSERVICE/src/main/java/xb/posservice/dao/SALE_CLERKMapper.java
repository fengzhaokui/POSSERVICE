package xb.posservice.dao;

import xb.posservice.dao.vo.SALE_CLERK;
import xb.posservice.dao.vo.SALE_CLERKKey;

public interface SALE_CLERKMapper {
    int deleteByPrimaryKey(SALE_CLERKKey key);

    int insert(SALE_CLERK record);

    int insertSelective(SALE_CLERK record);

    SALE_CLERK selectByPrimaryKey(SALE_CLERKKey key);

    int updateByPrimaryKeySelective(SALE_CLERK record);

    int updateByPrimaryKey(SALE_CLERK record);
}