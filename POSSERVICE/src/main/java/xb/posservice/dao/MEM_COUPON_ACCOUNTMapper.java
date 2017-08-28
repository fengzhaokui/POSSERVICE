package xb.posservice.dao;

import xb.posservice.dao.vo.MEM_COUPON_ACCOUNT;
import xb.posservice.dao.vo.MEM_COUPON_ACCOUNTKey;

public interface MEM_COUPON_ACCOUNTMapper {
    int deleteByPrimaryKey(MEM_COUPON_ACCOUNTKey key);

    int insert(MEM_COUPON_ACCOUNT record);

    int insertSelective(MEM_COUPON_ACCOUNT record);

    MEM_COUPON_ACCOUNT selectByPrimaryKey(MEM_COUPON_ACCOUNTKey key);
    MEM_COUPON_ACCOUNT selectBycode(String code);

    int updateByPrimaryKeySelective(MEM_COUPON_ACCOUNT record);

    int updateByPrimaryKey(MEM_COUPON_ACCOUNT record);
}