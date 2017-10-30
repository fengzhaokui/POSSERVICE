package xb.posservice.dao;

import xb.posservice.dao.vo.TICK_BASIC;
import xb.posservice.dao.vo.TICK_BASICKey;

public interface TICK_BASICMapper {
    int deleteByPrimaryKey(TICK_BASICKey key);

    int insert(TICK_BASIC record);

    int insertSelective(TICK_BASIC record);

    TICK_BASIC selectByPrimaryKey(TICK_BASICKey key);

    int updateByPrimaryKeySelective(TICK_BASIC record);

    int updateByPrimaryKey(TICK_BASIC record);
}