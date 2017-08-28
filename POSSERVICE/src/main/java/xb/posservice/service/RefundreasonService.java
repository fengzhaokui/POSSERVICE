package xb.posservice.service;

import java.util.List;

import xb.posservice.dao.vo.MALLDEF;
import xb.posservice.dao.vo.REFUNDREASON;

public interface RefundreasonService {
	List<REFUNDREASON> selectall();
}
