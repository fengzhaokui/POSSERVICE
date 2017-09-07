package xb.posservice.web;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import xb.posservice.dao.vo.GOODS;
import xb.posservice.dao.vo.HIS_SALE;
import xb.posservice.dao.vo.HIS_SALE_BANKDETAIL;
import xb.posservice.dao.vo.HIS_SALE_CLERK;
import xb.posservice.dao.vo.HIS_SALE_DETAIL;
import xb.posservice.dao.vo.HIS_SALE_FQ;
import xb.posservice.dao.vo.HIS_SALE_PAYMENTS;
import xb.posservice.dao.vo.HIS_SALE_THIRDPAY;
import xb.posservice.dao.vo.HIS_SALE_YQ;
import xb.posservice.dao.vo.MEM_TYPEDEF;
import xb.posservice.dao.vo.PERSONINFO;
import xb.posservice.dao.vo.ResultData;
import xb.posservice.dao.vo.SALE;
import xb.posservice.dao.vo.SALEKey;
import xb.posservice.dao.vo.SALE_BANKDETAIL;
import xb.posservice.dao.vo.SALE_BANKDETAILKey;
import xb.posservice.dao.vo.SALE_CLERK;
import xb.posservice.dao.vo.SALE_CLERKKey;
import xb.posservice.dao.vo.SALE_DETAIL;
import xb.posservice.dao.vo.SALE_DETAILKey;
import xb.posservice.dao.vo.SALE_FQ;
import xb.posservice.dao.vo.SALE_PAYMENTS;
import xb.posservice.dao.vo.SALE_PAYMENTSKey;
import xb.posservice.dao.vo.SALE_THIRDPAY;
import xb.posservice.dao.vo.SALE_THIRDPAYKey;
import xb.posservice.dao.vo.SALE_YQ;
import xb.posservice.dao.vo.SKFS;
import xb.posservice.service.FengService;
import xb.posservice.service.GoodsService;
import xb.posservice.service.HisSaleBankdetailService;
import xb.posservice.service.HisSaleClerkService;
import xb.posservice.service.HisSaleDetailService;
import xb.posservice.service.HisSalePaymentsService;
import xb.posservice.service.HisSaleService;
import xb.posservice.service.HisSaleThirdpayService;
import xb.posservice.service.HisSalefqService;
import xb.posservice.service.HisSaleyqService;
import xb.posservice.service.MemTypedefService;
import xb.posservice.service.PersoninfoService;
import xb.posservice.service.SaleBankdetailService;
import xb.posservice.service.SaleClerkService;
import xb.posservice.service.SaleDetailService;
import xb.posservice.service.SalePaymentsService;
import xb.posservice.service.SaleService;
import xb.posservice.service.SaleThirdpayService;
import xb.posservice.service.SalefqService;
import xb.posservice.service.SaleyqService;
import xb.posservice.service.SkfsService;
import xb.posservice.util.CommonUtils;
import xb.posservice.util.JsonUtils;
import xb.posservice.vo.GOODSTYPE;
import xb.posservice.vo.OldTicketBillMember;
import xb.posservice.vo.OldTicketBillgood;
import xb.posservice.vo.OldTicketPayment;
import xb.posservice.vo.OldTicketbankpay;
import xb.posservice.vo.OutOldTicket;
import xb.posservice.vo.OutOldTicketInfo;
import xb.posservice.vo.grantcoupon;
import xb.posservice.vo.thirdpartypay;

@Controller
public class GetReprintInfoController {
	Logger logger = Logger.getLogger(GetReprintInfoController.class);
	@Autowired
	@Qualifier("SaleServiceImpl")
	private SaleService saleService;
	@Autowired
	@Qualifier("HisSaleServiceImpl")
	private HisSaleService hissaleService;
	@Autowired
	@Qualifier("SaleDetailServiceImpl")
	private SaleDetailService saledetailService;
	@Autowired
	@Qualifier("HisSaleDetailServiceImpl")
	private HisSaleDetailService hissaledetailService;
	@Autowired
	@Qualifier("SaleClerkServiceImpl")
	private SaleClerkService saleclerkService;
	@Autowired
	@Qualifier("HisSaleClerkServiceImpl")
	private HisSaleClerkService hissaleclerkService;
	@Autowired
	@Qualifier("SalePaymentsServiceImpl")
	private SalePaymentsService salepaymentsService;
	@Autowired
	@Qualifier("HisSalePaymentsServiceImpl")
	private HisSalePaymentsService hissalepaymentsService;
	@Autowired
	@Qualifier("SaleBankdetailServiceImpl")
	private SaleBankdetailService salebankService;
	@Autowired
	@Qualifier("HisSaleBankdetailServiceImpl")
	private HisSaleBankdetailService hissalebankService;
	@Autowired
	@Qualifier("SaleThirdpayServiceImpl")
	private SaleThirdpayService salethirdpayService;
	@Autowired
	@Qualifier("HisSaleThirdpayServiceImpl")
	private HisSaleThirdpayService hissalethirdpayService;
	@Autowired
	@Qualifier("SalefqServiceImpl")
	private SalefqService salefqService;
	@Autowired
	@Qualifier("HisSalefqServiceImpl")
	private HisSalefqService hissalefqService;
	@Autowired
	@Qualifier("SaleyqServiceImpl")
	private SaleyqService saleyqService;
	@Autowired
	@Qualifier("HisSaleyqServiceImpl")
	private HisSaleyqService hissaleyqService;
	@Autowired
	@Qualifier("PersoninfoServiceImpl")
	private PersoninfoService personService;
	@Autowired
	@Qualifier("MemTypedefServiceImpl")
	private MemTypedefService typeService;
	@Autowired
	@Qualifier("GoodsServiceImpl")
	private GoodsService goodsService;
	@Autowired
	@Qualifier("SkfsServiceImpl")
	private SkfsService skfsService;

	//
	// @Autowired
	// @Qualifier("SaleServiceImpl")
	// private SaledetailService saledetailService;
	// 交易补打
	@RequestMapping(value = "/getreprintinfo", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public ResultData GetReprintInfo(@RequestParam(value = "token", required = false) String token,
			@RequestParam(value = "posno", required = false) String posno,
			@RequestParam(value = "billid", required = false) String billid) throws Exception {
		ResultData result = new ResultData();
		if (CommonUtils.Isnullstr(posno) || CommonUtils.Isnullstr(billid)) {
			result.setRetmsg("参数错误");
			return result;
		}
		SALEKey salekey = new SALEKey();
		salekey.setJlbh(Long.valueOf(billid));
		salekey.setSktno(posno);
		salekey.setStatus(1);
		SALE sale = saleService.selectByPrimaryKey(salekey);
		if (sale == null) {
			 if (sale == null)
             {
                 result = GetHisReprintInfo(posno,billid);//历史订单
                 return result;
             }
		}
		OutOldTicket oot = new OutOldTicket();
		OutOldTicketInfo ooti = new OutOldTicketInfo();
		oot.billInfo = ooti;
		ooti.billid = sale.getJlbh().toString();
		ooti.posno = sale.getSktno();
		ooti.totalmoney = sale.getXsje().toString();
		int i = sale.getXsje().compareTo(BigDecimal.ZERO);
		if (i >= 0) {
			ooti.saletype = "0";
		} else {
			if (sale.getJlbhOld() == 0) {
				ooti.saletype = "2";
			} else {
				ooti.saletype = "1";
			}
		}
		ooti.totalpoint = "0";
		ooti.saletime = CommonUtils.getDateTimeStr(sale.getJysj());
		ooti.changeMoney = String.valueOf(sale.getZlje());// 找零；
		ooti.awardpoint = String.valueOf(sale.getJf());
		ooti.usedPoint = String.valueOf(sale.getSyjf());
		ooti.exchangedPoint = CommonUtils.ToString(sale.getDkjf());

		if (!CommonUtils.Isnullstr(sale.getCardno())) {
			OldTicketBillMember otbm = new OldTicketBillMember();
			otbm.id = sale.getVipid().toString();
			otbm.memberno = sale.getCardno();
			otbm.membertype = sale.getViptype().toString();
			MEM_TYPEDEF type = typeService.selectByPrimaryKey(Long.valueOf(sale.getViptype()));
			if (type != null)
				otbm.membertypename = type.getTypename();
			ooti.member = otbm;

		} else
			ooti.member = null;

		// 缺获取会员总积分；
		if (sale.getBackreason() != null) {
			ooti.backreason = sale.getBackreason().toString();
		}
		PERSONINFO personinfo = personService.selectByPrimaryKey(sale.getSky());
		if (personinfo != null) {
			ooti.cashier = personinfo.getRydm();
			ooti.cashierName = personinfo.getPersonName();
		}
		SALE_CLERKKey clerkkey = new SALE_CLERKKey();
		clerkkey.setSktno(salekey.getSktno());
		clerkkey.setJlbh(salekey.getJlbh());
		List<SALE_CLERK> clerks = saleclerkService.selectByskt(clerkkey);
		if (clerks.size() > 0) {
			ooti.saleman = clerks.get(0).getYyy().toString();
			PERSONINFO scpersoninfo = personService.selectByPrimaryKey(clerks.get(0).getYyy());
			if (scpersoninfo != null) {
				ooti.salemanName = scpersoninfo.getPersonName();
			}
		}

		List<OldTicketBillgood> otbglist = new ArrayList<OldTicketBillgood>();
		OldTicketBillgood otbg = null;
		ooti.goodslist = otbglist;// 商品列表
		SALE_DETAILKey goodkey = new SALE_DETAILKey();
		goodkey.setSktno(sale.getSktno());
		goodkey.setJlbh(sale.getJlbh());
		List<SALE_DETAIL> goods = saledetailService.selectByskt(goodkey);
		for (SALE_DETAIL item : goods) {
			otbg = new OldTicketBillgood();
			otbg.id = item.getSpId().toString();
			otbg.code = item.getBarcode();
			otbg.barcode = item.getBarcode();
			GOODS good = goodsService.selectByPrimaryKey(item.getSpId());
			if (good != null) {
				otbg.goodsname = good.getName();
				if (good.getSptype() == GOODSTYPE.BFJFSP.ordinal() || good.getSptype() == GOODSTYPE.JFSP.ordinal()) {
					otbg.sptype = "1";
				} else
					otbg.sptype = "0";
			}
			otbg.inx = item.getInx().toString();
			otbg.price = item.getLsdj().toString();
			otbg.usedpoint = item.getPoint().toString();
			otbg.saleamt = item.getXsje().toString();
			otbg.salecount = item.getXssl().toString();
			otbg.discmoney = item.getZkje().toString();
			otbg.preferentialmoney = item.getYhje().toString();
			otbg.grantpoint = CommonUtils.ToString(item.getGrantpoint());
			otbglist.add(otbg);
		}
		// 支付方式
		List<OldTicketPayment> otplist = new ArrayList<OldTicketPayment>();
		OldTicketPayment cash = null;
		ooti.paymentslist = otplist;
		SALE_PAYMENTSKey spkey = new SALE_PAYMENTSKey();
		spkey.setSktno(sale.getSktno());
		spkey.setJlbh(sale.getJlbh());
		List<SALE_PAYMENTS> paylist = salepaymentsService.selectByskt(spkey);
		for (SALE_PAYMENTS itemb : paylist) {
			cash = new OldTicketPayment();
			cash.id = itemb.getSkfs().toString();
			cash.money = itemb.getSkje().toString();
			cash.overage = itemb.getYyje().toString();
			SKFS skfs = skfsService.selectByPrimaryKey(itemb.getSkfs());
			if (skfs != null) {
				cash.name = skfs.getName();
				cash.type = skfs.getType().toString();
			}
			otplist.add(cash);
		}
		// 银行卡信息
		SALE_BANKDETAILKey sbkey = new SALE_BANKDETAILKey();
		sbkey.setSktno(sale.getSktno());
		sbkey.setJlbh(sale.getJlbh());
		List<SALE_BANKDETAIL> sb = salebankService.selectByskt(sbkey);
		OldTicketbankpay otb = null;
		for (SALE_BANKDETAIL itemb : sb) {
			otb = new OldTicketbankpay();
			otb.transtype = itemb.getJylx().toString();
			otb.cardno = itemb.getCardno();
			otb.amount = itemb.getJe().toString();
			otb.decmoney = itemb.getZkje().toString();
			ooti.bankpaylist.add(otb);
		}
		// 第三方支付方式
		SALE_THIRDPAYKey stkey = new SALE_THIRDPAYKey();
		stkey.setSktno(sale.getSktno());
		stkey.setJlbh(sale.getJlbh());
		List<SALE_THIRDPAY> st = salethirdpayService.selectByskt(stkey);
		if (st.size() > 0) {
			Map<Integer, SALE_THIRDPAY> dic = new HashMap<Integer, SALE_THIRDPAY>();
			for (SALE_THIRDPAY item : st) {
				if (item.getJylx() != 1) {
					for (SALE_THIRDPAY aa : dic.values()) {
						if (aa.getOuttradeno() == item.getOuttradeno()) {
							dic.remove(aa.getInx());
							break;
						}
					}
				} else if (item.getJylx() == 1) {
					dic.put(item.getInx(), item);
				}
			}
			thirdpartypay tpay = null;
			for (SALE_THIRDPAY item : dic.values()) {
				tpay = new thirdpartypay();
				tpay.trade_no = item.getOuttradeno();
				tpay.pay_total_fee = (item.getAmount()).toString();
				tpay.pay_type = item.getChannel().toString();
				ooti.thirdpartypaylist.add(tpay);

			}
		}
		List<SALE_FQ> fq = salefqService.selectByskt(salekey);
		List<SALE_YQ> yq = saleyqService.selectByskt(salekey);
		// 用券，返券列表；
		grantcoupon getcoupon = null;
		for (SALE_YQ item : yq) {
			getcoupon = new grantcoupon();
			getcoupon.couponno = item.getCouponcode();
			getcoupon.name = item.getCoupname();
			getcoupon.availablemoney = item.getMoney().toString();// 真实金额
			getcoupon.facevalue = getcoupon.availablemoney;
			ooti.usedcouponlist.add(getcoupon);
		}
		for (SALE_FQ item : fq) {
			getcoupon = new grantcoupon();
			getcoupon.couponno = item.getCouponcode();
			getcoupon.name = item.getCoupname();
			getcoupon.availablemoney = item.getMoney().toString();// 真实金额
			getcoupon.facevalue = getcoupon.availablemoney;
			ooti.grantcouponlist.add(getcoupon);
		}

		result.setRetcode("00");
		result.setData(oot);

		return result;
	}
//历史数据
	public ResultData GetHisReprintInfo(String posno, String billid) {
		ResultData result = new ResultData();
		if (CommonUtils.Isnullstr(posno) || CommonUtils.Isnullstr(billid)) {
			result.setRetmsg("参数错误");
			return result;
		}
		SALEKey salekey = new SALEKey();
		salekey.setJlbh(Long.valueOf(billid));
		salekey.setSktno(posno);
		salekey.setStatus(1);
		HIS_SALE sale = hissaleService.selectByPrimaryKey(salekey);
		if (sale == null) {
			result.setRetmsg("该订单不存在");
			return result;
		}
		OutOldTicket oot = new OutOldTicket();
		OutOldTicketInfo ooti = new OutOldTicketInfo();
		oot.billInfo = ooti;
		ooti.billid = sale.getJlbh().toString();
		ooti.posno = sale.getSktno();
		ooti.totalmoney = sale.getXsje().toString();
		int i = sale.getXsje().compareTo(BigDecimal.ZERO);
		if (i >= 0) {
			ooti.saletype = "0";
		} else {
			if (sale.getJlbhOld() == 0) {
				ooti.saletype = "2";
			} else {
				ooti.saletype = "1";
			}
		}
		ooti.totalpoint = "0";
		ooti.saletime = CommonUtils.getDateTimeStr(sale.getJysj());
		ooti.changeMoney = String.valueOf(sale.getZlje());// 找零；
		ooti.awardpoint = String.valueOf(sale.getJf());
		ooti.usedPoint = String.valueOf(sale.getSyjf());
		ooti.exchangedPoint = CommonUtils.ToString(sale.getDkjf());

		if (!CommonUtils.Isnullstr(sale.getCardno())) {
			OldTicketBillMember otbm = new OldTicketBillMember();
			otbm.id = sale.getVipid().toString();
			otbm.memberno = sale.getCardno();
			otbm.membertype = sale.getViptype().toString();
			MEM_TYPEDEF type = typeService.selectByPrimaryKey(Long.valueOf(sale.getViptype()));
			if (type != null)
				otbm.membertypename = type.getTypename();
			ooti.member = otbm;

		} else
			ooti.member = null;

		// 缺获取会员总积分；
		if (sale.getBackreason() != null) {
			ooti.backreason = sale.getBackreason().toString();
		}
		PERSONINFO personinfo = personService.selectByPrimaryKey(sale.getSky());
		if (personinfo != null) {
			ooti.cashier = personinfo.getRydm();
			ooti.cashierName = personinfo.getPersonName();
		}
		SALE_CLERKKey clerkkey = new SALE_CLERKKey();
		clerkkey.setSktno(salekey.getSktno());
		clerkkey.setJlbh(salekey.getJlbh());
		List<HIS_SALE_CLERK> clerks = hissaleclerkService.selectByskt(clerkkey);
		if (clerks.size() > 0) {
			ooti.saleman = clerks.get(0).getYyy().toString();
			PERSONINFO scpersoninfo = personService.selectByPrimaryKey(clerks.get(0).getYyy());
			if (scpersoninfo != null) {
				ooti.salemanName = scpersoninfo.getPersonName();
			}
		}

		List<OldTicketBillgood> otbglist = new ArrayList<OldTicketBillgood>();
		OldTicketBillgood otbg = null;
		ooti.goodslist = otbglist;// 商品列表
		SALE_DETAILKey goodkey = new SALE_DETAILKey();
		goodkey.setSktno(sale.getSktno());
		goodkey.setJlbh(sale.getJlbh());
		List<HIS_SALE_DETAIL> goods = hissaledetailService.selectByskt(goodkey);
		for (HIS_SALE_DETAIL item : goods) {
			otbg = new OldTicketBillgood();
			otbg.id = item.getSpId().toString();
			otbg.code = item.getBarcode();
			otbg.barcode = item.getBarcode();
			GOODS good = goodsService.selectByPrimaryKey(item.getSpId());
			if (good != null) {
				otbg.goodsname = good.getName();
				if (good.getSptype() == GOODSTYPE.BFJFSP.ordinal() || good.getSptype() == GOODSTYPE.JFSP.ordinal()) {
					otbg.sptype = "1";
				} else
					otbg.sptype = "0";
			}
			otbg.inx = item.getInx().toString();
			otbg.price = item.getLsdj().toString();
			otbg.usedpoint = item.getPoint().toString();
			otbg.saleamt = item.getXsje().toString();
			otbg.salecount = item.getXssl().toString();
			otbg.discmoney = item.getZkje().toString();
			otbg.preferentialmoney = item.getYhje().toString();
			otbg.grantpoint = CommonUtils.ToString(item.getGrantpoint());
			otbglist.add(otbg);
		}
		// 支付方式
		List<OldTicketPayment> otplist = new ArrayList<OldTicketPayment>();
		OldTicketPayment cash = null;
		ooti.paymentslist = otplist;
		SALE_PAYMENTSKey spkey = new SALE_PAYMENTSKey();
		spkey.setSktno(sale.getSktno());
		spkey.setJlbh(sale.getJlbh());
		List<HIS_SALE_PAYMENTS> paylist = hissalepaymentsService.selectByskt(spkey);
		for (HIS_SALE_PAYMENTS itemb : paylist) {
			cash = new OldTicketPayment();
			cash.id = itemb.getSkfs().toString();
			cash.money = itemb.getSkje().toString();
			cash.overage = itemb.getYyje().toString();
			SKFS skfs = skfsService.selectByPrimaryKey(itemb.getSkfs());
			if (skfs != null) {
				cash.name = skfs.getName();
				cash.type = skfs.getType().toString();
			}
			otplist.add(cash);
		}
		// 银行卡信息
		SALE_BANKDETAILKey sbkey = new SALE_BANKDETAILKey();
		sbkey.setSktno(sale.getSktno());
		sbkey.setJlbh(sale.getJlbh());
		List<HIS_SALE_BANKDETAIL> sb = hissalebankService.selectByskt(sbkey);
		OldTicketbankpay otb = null;
		for (HIS_SALE_BANKDETAIL itemb : sb) {
			otb = new OldTicketbankpay();
			otb.transtype = itemb.getJylx().toString();
			otb.cardno = itemb.getCardno();
			otb.amount = itemb.getJe().toString();
			otb.decmoney = itemb.getZkje().toString();
			ooti.bankpaylist.add(otb);
		}
		// 第三方支付方式
		SALE_THIRDPAYKey stkey = new SALE_THIRDPAYKey();
		stkey.setSktno(sale.getSktno());
		stkey.setJlbh(sale.getJlbh());
		List<HIS_SALE_THIRDPAY> st = hissalethirdpayService.selectByskt(stkey);
		if (st.size() > 0) {
			Map<Integer, HIS_SALE_THIRDPAY> dic = new HashMap<Integer, HIS_SALE_THIRDPAY>();
			for (HIS_SALE_THIRDPAY item : st) {
				if (item.getJylx() != 1) {
					for (HIS_SALE_THIRDPAY aa : dic.values()) {
						if (aa.getOuttradeno() == item.getOuttradeno()) {
							dic.remove(aa.getInx());
							break;
						}
					}
				} else if (item.getJylx() == 1) {
					dic.put(item.getInx(), item);
				}
			}
			thirdpartypay tpay = null;
			for (HIS_SALE_THIRDPAY item : dic.values()) {
				tpay = new thirdpartypay();
				tpay.trade_no = item.getOuttradeno();
				tpay.pay_total_fee = (item.getAmount()).toString();
				tpay.pay_type = item.getChannel().toString();
				ooti.thirdpartypaylist.add(tpay);

			}
		}
		List<HIS_SALE_FQ> fq = hissalefqService.selectByskt(salekey);
		List<HIS_SALE_YQ> yq = hissaleyqService.selectByskt(salekey);
		// 用券，返券列表；
		grantcoupon getcoupon = null;
		for (HIS_SALE_YQ item : yq) {
			getcoupon = new grantcoupon();
			getcoupon.couponno = item.getCouponcode();
			getcoupon.name = item.getCoupname();
			getcoupon.availablemoney = item.getMoney().toString();// 真实金额
			getcoupon.facevalue = getcoupon.availablemoney;
			ooti.usedcouponlist.add(getcoupon);
		}
		for (HIS_SALE_FQ item : fq) {
			getcoupon = new grantcoupon();
			getcoupon.couponno = item.getCouponcode();
			getcoupon.name = item.getCoupname();
			getcoupon.availablemoney = item.getMoney().toString();// 真实金额
			getcoupon.facevalue = getcoupon.availablemoney;
			ooti.grantcouponlist.add(getcoupon);
		}

		result.setRetcode("00");
		result.setData(oot);

		return result;
	}
}
