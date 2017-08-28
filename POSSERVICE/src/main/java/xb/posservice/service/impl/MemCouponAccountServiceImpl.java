package xb.posservice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xb.posservice.dao.MEM_COUPON_ACCOUNTMapper;
import xb.posservice.dao.SHOPDEFMapper;
import xb.posservice.dao.SKTMapper;
import xb.posservice.dao.vo.MEM_COUPON_ACCOUNT;
import xb.posservice.dao.vo.SHOPDEF;
import xb.posservice.dao.vo.SKT;
import xb.posservice.service.MemCouponAccountService;
import xb.posservice.service.ShopService;
import xb.posservice.service.SktService;
@Service("MemCouponAccountServiceImpl")
public class MemCouponAccountServiceImpl implements MemCouponAccountService{
	@Autowired
	MEM_COUPON_ACCOUNTMapper couponMapper;
	
	

	public MEM_COUPON_ACCOUNT selectBycode(String code) {
		// TODO Auto-generated method stub
		return couponMapper.selectBycode(code);
	}

	
	
}
