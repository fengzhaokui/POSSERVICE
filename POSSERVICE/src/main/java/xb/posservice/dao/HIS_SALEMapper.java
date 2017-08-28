package xb.posservice.dao;

import xb.posservice.dao.vo.HIS_SALE;
import xb.posservice.dao.vo.HIS_SALEKey;
import xb.posservice.dao.vo.SALE;
import xb.posservice.dao.vo.SALEKey;

public interface HIS_SALEMapper {
    int deleteByPrimaryKey(HIS_SALEKey key);

    int insert(HIS_SALE record);

    int insertSelective(HIS_SALE record);

    HIS_SALE selectByPrimaryKey(SALEKey key);
    HIS_SALE selectMaxJlbh(String sktno);
    int updateByPrimaryKeySelective(HIS_SALE record);

    int updateByPrimaryKey(HIS_SALE record);
}