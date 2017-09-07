package xb.posservice.dao;

import java.util.List;

import xb.posservice.dao.vo.SALE_BANKDETAIL;
import xb.posservice.dao.vo.SALE_BANKDETAILKey;

public interface SALE_BANKDETAILMapper {
    int deleteByPrimaryKey(SALE_BANKDETAILKey key);

    int insert(SALE_BANKDETAIL record);

    int insertSelective(SALE_BANKDETAIL record);

    SALE_BANKDETAIL selectByPrimaryKey(SALE_BANKDETAILKey key);
    SALE_BANKDETAIL selectoneByskt(SALE_BANKDETAILKey key);
    
    List<SALE_BANKDETAIL> selectByskt(SALE_BANKDETAILKey key);

    int updateByPrimaryKeySelective(SALE_BANKDETAIL record);

    int updateByPrimaryKey(SALE_BANKDETAIL record);
}