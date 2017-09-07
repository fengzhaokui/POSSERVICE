package xb.posservice.dao;

import java.util.List;

import xb.posservice.dao.vo.HIS_SALE_YQ;
import xb.posservice.dao.vo.HIS_SALE_YQKey;
import xb.posservice.dao.vo.SALEKey;
import xb.posservice.dao.vo.SALE_YQ;

public interface HIS_SALE_YQMapper {
    int deleteByPrimaryKey(HIS_SALE_YQKey key);

    int insert(HIS_SALE_YQ record);

    int insertSelective(HIS_SALE_YQ record);

    HIS_SALE_YQ selectByPrimaryKey(HIS_SALE_YQKey key);
    List<HIS_SALE_YQ> selectByskt(SALEKey key);
    int updateByPrimaryKeySelective(HIS_SALE_YQ record);

    int updateByPrimaryKey(HIS_SALE_YQ record);
}