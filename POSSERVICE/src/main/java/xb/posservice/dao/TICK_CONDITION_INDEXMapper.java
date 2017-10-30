package xb.posservice.dao;

import xb.posservice.dao.vo.TICK_CONDITION_INDEX;
import xb.posservice.dao.vo.TICK_CONDITION_INDEXKey;

public interface TICK_CONDITION_INDEXMapper {
    int deleteByPrimaryKey(TICK_CONDITION_INDEXKey key);

    int insert(TICK_CONDITION_INDEX record);

    int insertSelective(TICK_CONDITION_INDEX record);

    TICK_CONDITION_INDEX selectByPrimaryKey(TICK_CONDITION_INDEXKey key);

    int updateByPrimaryKeySelective(TICK_CONDITION_INDEX record);

    int updateByPrimaryKey(TICK_CONDITION_INDEX record);
}