package xb.posservice.dao;

import java.util.List;

import xb.posservice.dao.vo.SALEKey;
import xb.posservice.dao.vo.SALE_FQ;
import xb.posservice.dao.vo.SALE_YQ;
import xb.posservice.dao.vo.SALE_YQKey;

public interface SALE_YQMapper {
    int deleteByPrimaryKey(SALE_YQKey key);

    int insert(SALE_YQ record);

    int insertSelective(SALE_YQ record);

    SALE_YQ selectByPrimaryKey(SALE_YQKey key);

    List<SALE_YQ> selectByskt(SALEKey key);

    int updateByPrimaryKeySelective(SALE_YQ record);

    int updateByPrimaryKey(SALE_YQ record);
}