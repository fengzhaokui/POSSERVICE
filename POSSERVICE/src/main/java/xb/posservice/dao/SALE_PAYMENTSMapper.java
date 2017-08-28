package xb.posservice.dao;

import xb.posservice.dao.vo.SALE_PAYMENTS;
import xb.posservice.dao.vo.SALE_PAYMENTSKey;

public interface SALE_PAYMENTSMapper {
    int deleteByPrimaryKey(SALE_PAYMENTSKey key);

    int insert(SALE_PAYMENTS record);

    int insertSelective(SALE_PAYMENTS record);

    SALE_PAYMENTS selectByPrimaryKey(SALE_PAYMENTSKey key);

    int updateByPrimaryKeySelective(SALE_PAYMENTS record);

    int updateByPrimaryKey(SALE_PAYMENTS record);
}