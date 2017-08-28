package xb.posservice.dao;

import xb.posservice.dao.vo.MEM_COUPON_DEF;

public interface MEM_COUPON_DEFMapper {
    int deleteByPrimaryKey(Long yhqid);

    int insert(MEM_COUPON_DEF record);

    int insertSelective(MEM_COUPON_DEF record);

    MEM_COUPON_DEF selectByPrimaryKey(Long yhqid);

    int updateByPrimaryKeySelective(MEM_COUPON_DEF record);

    int updateByPrimaryKey(MEM_COUPON_DEF record);
}