package xb.posservice.dao;

import java.util.List;

import xb.posservice.dao.vo.SALE_THIRDPAY;
import xb.posservice.dao.vo.SALE_THIRDPAYKey;

public interface SALE_THIRDPAYMapper {
    int deleteByPrimaryKey(SALE_THIRDPAYKey key);

    int insert(SALE_THIRDPAY record);

    int insertSelective(SALE_THIRDPAY record);

    SALE_THIRDPAY selectByPrimaryKey(SALE_THIRDPAYKey key);
    List<SALE_THIRDPAY> selectByskt(SALE_THIRDPAYKey key);
    int updateByPrimaryKeySelective(SALE_THIRDPAY record);

    int updateByPrimaryKey(SALE_THIRDPAY record);
}