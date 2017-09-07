package xb.posservice.dao;

import java.util.List;

import xb.posservice.dao.vo.HIS_SALE_FQ;
import xb.posservice.dao.vo.HIS_SALE_FQKey;
import xb.posservice.dao.vo.SALEKey;
import xb.posservice.dao.vo.SALE_FQ;

public interface HIS_SALE_FQMapper {
    int deleteByPrimaryKey(HIS_SALE_FQKey key);

    int insert(HIS_SALE_FQ record);

    int insertSelective(HIS_SALE_FQ record);

    HIS_SALE_FQ selectByPrimaryKey(HIS_SALE_FQKey key);
    List<HIS_SALE_FQ> selectByskt(SALEKey key);

    int updateByPrimaryKeySelective(HIS_SALE_FQ record);

    int updateByPrimaryKey(HIS_SALE_FQ record);
}