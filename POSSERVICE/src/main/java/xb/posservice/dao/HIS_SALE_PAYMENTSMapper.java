package xb.posservice.dao;

import java.util.List;

import xb.posservice.dao.vo.HIS_SALE_PAYMENTS;
import xb.posservice.dao.vo.HIS_SALE_PAYMENTSKey;
import xb.posservice.dao.vo.SALE_PAYMENTS;
import xb.posservice.dao.vo.SALE_PAYMENTSKey;

public interface HIS_SALE_PAYMENTSMapper {
    int deleteByPrimaryKey(HIS_SALE_PAYMENTSKey key);

    int insert(HIS_SALE_PAYMENTS record);

    int insertSelective(HIS_SALE_PAYMENTS record);

    HIS_SALE_PAYMENTS selectByPrimaryKey(HIS_SALE_PAYMENTSKey key);
    List<HIS_SALE_PAYMENTS> selectByskt(SALE_PAYMENTSKey key);
    int updateByPrimaryKeySelective(HIS_SALE_PAYMENTS record);

    int updateByPrimaryKey(HIS_SALE_PAYMENTS record);
}