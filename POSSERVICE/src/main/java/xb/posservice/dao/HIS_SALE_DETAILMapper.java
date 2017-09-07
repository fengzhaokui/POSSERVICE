package xb.posservice.dao;

import java.util.List;

import xb.posservice.dao.vo.HIS_SALE_DETAIL;
import xb.posservice.dao.vo.HIS_SALE_DETAILKey;
import xb.posservice.dao.vo.SALE_DETAIL;
import xb.posservice.dao.vo.SALE_DETAILKey;

public interface HIS_SALE_DETAILMapper {
    int deleteByPrimaryKey(HIS_SALE_DETAILKey key);

    int insert(HIS_SALE_DETAIL record);

    int insertSelective(HIS_SALE_DETAIL record);

    HIS_SALE_DETAIL selectByPrimaryKey(HIS_SALE_DETAILKey key);
    List<HIS_SALE_DETAIL> selectByskt(SALE_DETAILKey key);
    int updateByPrimaryKeySelective(HIS_SALE_DETAIL record);

    int updateByPrimaryKey(HIS_SALE_DETAIL record);
}