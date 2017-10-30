package xb.posservice.dao;

import xb.posservice.dao.vo.TICK_CONDITION_DETAIL;
import xb.posservice.dao.vo.TICK_CONDITION_DETAILKey;

public interface TICK_CONDITION_DETAILMapper {
    int deleteByPrimaryKey(TICK_CONDITION_DETAILKey key);

    int insert(TICK_CONDITION_DETAIL record);

    int insertSelective(TICK_CONDITION_DETAIL record);

    TICK_CONDITION_DETAIL selectByPrimaryKey(TICK_CONDITION_DETAILKey key);

    int updateByPrimaryKeySelective(TICK_CONDITION_DETAIL record);

    int updateByPrimaryKey(TICK_CONDITION_DETAIL record);
}