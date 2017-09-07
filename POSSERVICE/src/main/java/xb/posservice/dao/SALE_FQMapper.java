package xb.posservice.dao;

import java.util.List;

import xb.posservice.dao.vo.SALEKey;
import xb.posservice.dao.vo.SALE_FQ;
import xb.posservice.dao.vo.SALE_FQKey;

public interface SALE_FQMapper {
    int deleteByPrimaryKey(SALE_FQKey key);

    int insert(SALE_FQ record);

    int insertSelective(SALE_FQ record);

    SALE_FQ selectByPrimaryKey(SALE_FQKey key);
    List<SALE_FQ> selectByskt(SALEKey key);

    int updateByPrimaryKeySelective(SALE_FQ record);

    int updateByPrimaryKey(SALE_FQ record);
}