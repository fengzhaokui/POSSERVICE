package xb.posservice.dao;

import java.util.List;

import xb.posservice.dao.vo.SALE_DETAIL;
import xb.posservice.dao.vo.SALE_DETAILKey;

public interface SALE_DETAILMapper {
    int deleteByPrimaryKey(SALE_DETAILKey key);

    int insert(SALE_DETAIL record);

    int insertSelective(SALE_DETAIL record);

    SALE_DETAIL selectByPrimaryKey(SALE_DETAILKey key);
    List<SALE_DETAIL> selectByskt(SALE_DETAILKey key);

    int updateByPrimaryKeySelective(SALE_DETAIL record);

    int updateByPrimaryKey(SALE_DETAIL record);
}