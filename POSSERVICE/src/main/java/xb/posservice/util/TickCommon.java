package xb.posservice.util;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import xb.posservice.dao.vo.SHOPDEF;
import xb.posservice.dao.vo.SKT;
import xb.posservice.dao.vo.TICK;
import xb.posservice.service.ShopService;
import xb.posservice.service.SktService;
import xb.posservice.service.TickService;
//@Component
@Component
public class TickCommon {
	Logger logger = Logger.getLogger(TickCommon.class);
	@Autowired
	@Qualifier("SktServiceImpl")
	private SktService sktService;
	
	@Autowired
	@Qualifier("ShopServiceImpl")
	private ShopService shopService;

	@Autowired
	@Qualifier("TickServiceImpl")
	private TickService tickService;

	public List<TICK> GetTickList(String posno) {
		
		SKT skt = sktService.selectByPrimaryKey(posno);
		
		if (skt != null && skt.getShopid() != null) {
			SHOPDEF shop = shopService.selectByPrimaryKey(skt.getShopid());
			if (shop != null && shop.getMallid() != null) {
				List<TICK> tick = tickService.selectBymall(shop.getMallid(), skt.getDyfa());
				return tick;
			}
		} else {
			List<TICK> tick = tickService.selectBymall(skt.getMdid(), skt.getDyfa());
			return tick;
		}
		return null;
	}
}
