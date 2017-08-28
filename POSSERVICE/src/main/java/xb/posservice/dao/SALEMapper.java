package xb.posservice.dao;

import xb.posservice.dao.vo.SALE;
import xb.posservice.dao.vo.SALEKey;

public interface SALEMapper {
    int deleteByPrimaryKey(SALEKey key);

    int insert(SALE record);

    int insertSelective(SALE record);

    SALE selectByPrimaryKey(SALEKey key);
    SALE selectMaxJlbh(String sktno);

    int updateByPrimaryKeySelective(SALE record);

    int updateByPrimaryKey(SALE record);
}