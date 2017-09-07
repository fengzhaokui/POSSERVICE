package xb.posservice.dao;

import java.util.List;

import xb.posservice.dao.vo.HIS_SALE_THIRDPAY;
import xb.posservice.dao.vo.HIS_SALE_THIRDPAYKey;
import xb.posservice.dao.vo.SALE_THIRDPAY;
import xb.posservice.dao.vo.SALE_THIRDPAYKey;

public interface HIS_SALE_THIRDPAYMapper {
    int deleteByPrimaryKey(HIS_SALE_THIRDPAYKey key);

    int insert(HIS_SALE_THIRDPAY record);

    int insertSelective(HIS_SALE_THIRDPAY record);

    HIS_SALE_THIRDPAY selectByPrimaryKey(HIS_SALE_THIRDPAYKey key);
    List<HIS_SALE_THIRDPAY> selectByskt(SALE_THIRDPAYKey key);
    int updateByPrimaryKeySelective(HIS_SALE_THIRDPAY record);

    int updateByPrimaryKey(HIS_SALE_THIRDPAY record);
}