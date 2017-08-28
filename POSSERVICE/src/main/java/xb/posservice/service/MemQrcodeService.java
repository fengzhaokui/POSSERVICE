package xb.posservice.service;

import java.util.List;

import xb.posservice.dao.vo.GOODS;
import xb.posservice.dao.vo.MEMQRCODE;

public interface MemQrcodeService {
	MEMQRCODE selectByQRCODE(String qrcode);
}
