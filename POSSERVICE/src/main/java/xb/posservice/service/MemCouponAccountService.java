package xb.posservice.service;

import xb.posservice.dao.vo.MEM_COUPON_ACCOUNT;

public interface MemCouponAccountService {
	MEM_COUPON_ACCOUNT selectBycode(String code);
}
