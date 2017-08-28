package xb.posservice.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xb.posservice.dao.GOODSMapper;
import xb.posservice.dao.MEMQRCODEMapper;
import xb.posservice.dao.SHOPDEFMapper;
import xb.posservice.dao.SKTMapper;
import xb.posservice.dao.vo.GOODS;
import xb.posservice.dao.vo.MEMQRCODE;
import xb.posservice.dao.vo.SHOPDEF;
import xb.posservice.dao.vo.SKT;
import xb.posservice.service.GoodsService;
import xb.posservice.service.MemQrcodeService;
import xb.posservice.service.ShopService;
import xb.posservice.service.SktService;
@Service("MemQrcodeServiceImpl")
public class MemQrcodeServiceImpl implements MemQrcodeService{
	@Autowired
	MEMQRCODEMapper memqrcodeMapper;

	public MEMQRCODE selectByQRCODE(String qrcode) {
		// TODO Auto-generated method stub
		return memqrcodeMapper.selectByQRCODE(qrcode);
	}

}
