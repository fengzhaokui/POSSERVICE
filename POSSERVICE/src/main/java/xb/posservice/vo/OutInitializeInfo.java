package xb.posservice.vo;

import java.util.ArrayList;
import java.util.List;

import xb.posservice.dao.vo.REFUNDREASON;

public class OutInitializeInfo {
	 public List<OutSpxx> brandgoodslist = new ArrayList<OutSpxx>();
	 public List<OutpayInfo> paymentslist = new ArrayList<OutpayInfo>();
	 public List<REFUNDREASON> refundreasonlist = new ArrayList<REFUNDREASON>();
}
