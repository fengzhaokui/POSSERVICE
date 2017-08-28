package xb.posservice.web;

import java.math.BigDecimal;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import xb.posservice.dao.vo.ResultData;
import xb.posservice.dao.vo.SALE_BANKDETAIL;
import xb.posservice.dao.vo.SALE_BANKDETAILKey;
import xb.posservice.service.SaleBankdetailService;
import xb.posservice.util.CommonUtils;
import xb.posservice.vo.InCouponInfo;
import xb.posservice.vo.InSaveBankInfo;
import xb.posservice.vo.SaveState;

@Controller
public class SKFSPayController {
	Logger log = Logger.getLogger(SKFSPayController.class);

	@Autowired
	@Qualifier("SaleBankdetailServiceImpl")
	private SaleBankdetailService sbService;

	// 保存银行卡交易信息；
	// @AuthChecker
	@RequestMapping(value = "/savebankinfo", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public ResultData SaveBankInfo(@RequestParam String posno, @RequestParam String billid,
			@RequestParam String transtype, @RequestParam String cardno, @RequestParam String batchno,
			@RequestParam String refno, @RequestParam String tradeno, @RequestParam String amount,
			@RequestParam String decmoney, @RequestParam String skfsid) {
		// public ResultData SaveBankInfo(@RequestParam String posno,
		// @RequestParam String billid
		// ) {
		ResultData result = new ResultData();
		SALE_BANKDETAIL detail = new SALE_BANKDETAIL();
		SALE_BANKDETAILKey key = new SALE_BANKDETAILKey();
		key.setJlbh(Long.valueOf(billid));
		key.setSktno(posno);
		SALE_BANKDETAIL old = sbService.selectByskt(key);
		Integer inx = 0;
		if (old == null) {
			// result.setRetmsg("没有记录");
		} else {
			inx = old.getInx() + 1;
			// result.setRetmsg("inx:"+old.getInx());
		}
		detail.setInx(inx);
		detail.setSktno(posno);
		detail.setJlbh(Long.valueOf(billid));
		if (!CommonUtils.Isnullstr(transtype)) {
			detail.setJylx(Integer.valueOf(transtype));
		}
		detail.setCardno(cardno);
		detail.setPch(batchno);
		detail.setCkh(refno);
		detail.setLsh(tradeno);
		if (!CommonUtils.Isnullstr(amount)) {
			detail.setJe(new BigDecimal(amount));
		}
		if (!CommonUtils.Isnullstr(decmoney)) {
			detail.setZkje(new BigDecimal(decmoney));
		}
		if (!CommonUtils.Isnullstr(skfsid)) {
			detail.setSkfsid(Integer.valueOf(skfsid));
		}
		int num = sbService.insert(detail);
		if (num > 0) {
			result.setRetcode("00");
		} else {
			result.setRetmsg("保存失败");
		}
		return result;
	}

	// 保存银行卡交易信息列表；
	// @AuthChecker
	@RequestMapping(value = "/savebankinfolist", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public ResultData SaveBankInfoList(@RequestParam String data) {
		ResultData result = new ResultData();
		Gson gson = new Gson();
		SaveState state = new SaveState();
		List<InSaveBankInfo> clist = gson.fromJson(data, new TypeToken<List<InSaveBankInfo>>() {
		}.getType());
		for (InSaveBankInfo info : clist) {
			try{
			SALE_BANKDETAIL detail = new SALE_BANKDETAIL();
			SALE_BANKDETAILKey key = new SALE_BANKDETAILKey();
			key.setJlbh(Long.valueOf(info.billid));
			key.setSktno(info.posno);
			SALE_BANKDETAIL old = sbService.selectByskt(key);
			Integer inx = 0;
			if (old == null) {
				// result.setRetmsg("没有记录");
			} else {
				inx = old.getInx() + 1;
			}
			detail.setInx(inx);
			detail.setSktno(info.posno);
			detail.setJlbh(Long.valueOf(info.billid));
			if (!CommonUtils.Isnullstr(info.transtype)) {
				detail.setJylx(Integer.valueOf(info.transtype));
			}
			detail.setCardno(info.cardno);
			detail.setPch(info.batchno);
			detail.setCkh(info.refno);
			detail.setLsh(info.tradeno);
			if (!CommonUtils.Isnullstr(info.amount)) {
				detail.setJe(new BigDecimal(info.amount));
			}
			if (!CommonUtils.Isnullstr(info.decmoney)) {
				detail.setZkje(new BigDecimal(info.decmoney));
			}
			if (!CommonUtils.Isnullstr(info.skfsid)) {
				detail.setSkfsid(Integer.valueOf(info.skfsid));
			}
			int num = sbService.insert(detail);
			if (num > 0) {
				state.sucbillidlist.add(info.tradeno);
				state.sucnum++;
			}
			}
			catch(Exception e)
			{
				log.info(e);
			}
		}
		if (state.sucnum == clist.size()) {
			result.setRetcode("00");
		} else if (state.sucnum > 0) {
			result.setRetcode("02");

			result.setRetmsg("上传银行卡数据部分成功");
		} else {
			result.setRetcode("05");
			result.setRetmsg("上传银行卡数据失败");

		}
		result.setData(state);

		return result;

	}
}
