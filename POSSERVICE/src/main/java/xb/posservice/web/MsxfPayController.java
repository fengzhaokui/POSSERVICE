package xb.posservice.web;

import java.math.BigDecimal;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.gson.Gson;

import net.sf.json.JSONObject;
import xb.posservice.vo.*;
import xb.posservice.dao.vo.MEMQRCODE;
import xb.posservice.dao.vo.MEM_BASEINFO;
import xb.posservice.dao.vo.MEM_COUPON_ACCOUNT;
import xb.posservice.dao.vo.MEM_COUPON_DEF;
import xb.posservice.dao.vo.ResultData;
import xb.posservice.service.ApiService;
import xb.posservice.service.MemBaseInfoService;
import xb.posservice.service.MemCouponAccountService;
import xb.posservice.service.MemCouponDefService;
import xb.posservice.service.MemQrcodeService;
import xb.posservice.util.CommonUtils;
import xb.posservice.util.JsonUtils;

@Controller
// @RequestMapping("/gethyxx")
public class MsxfPayController {
	Logger logger = Logger.getLogger(MsxfPayController.class);

	@Autowired
	@Qualifier("MemBaseInfoServiceImpl")
	private MemBaseInfoService memService;

	@Autowired
	@Qualifier("MemCouponDefServiceImpl")
	private MemCouponDefService coupondefService;

	@Autowired
	@Qualifier("MemCouponAccountServiceImpl")
	private MemCouponAccountService couponService;
	@Autowired
	@Qualifier("MemQrcodeServiceImpl")
	private MemQrcodeService memqrcodeService;
	@Autowired
	@Qualifier("ApiServiceImpl")
	private ApiService apiService;
	@Autowired
	@Qualifier("MemBaseInfoServiceImpl")
	private MemBaseInfoService membs;
	
	
	// 马上交易消费
	@RequestMapping(value = "/msxfpay", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public ResultData msxfpay(@RequestParam String token, @RequestParam String xsje, @RequestParam String sktNo,
			@RequestParam String jlbh, @RequestParam String qrcode, 
			@RequestParam String goodsInfo, @RequestParam String goodsName,
			@RequestParam String industryCode, @RequestParam String goodsDescription, @RequestParam String amount,
			@RequestParam String orderId,@RequestParam String type,@RequestParam String partnerId,@RequestParam String partnerName) throws Exception {
		// 验证二维码是否合法；
		ResultData result = new ResultData();
		if (type == "2")//易宝
        {
            //skfs = 23;
            if (qrcode.substring(0, 1) != "5")
            {
                result.setRetmsg("二维码无效"); 
                return result;
            }
        }
        else if (type == "1")
        {
           // skfs = 15;
            if (qrcode.substring(0, 1) != "6")
            {
            	result.setRetmsg("二维码无效");
                return result;
            }
        }
        else if (type == "3")
        {
           // skfs = 15;
            if (qrcode.substring(0, 1) != "7")
            {
            	result.setRetmsg("二维码无效");
                return result;
            }
        }
		MEMQRCODE memqrcode = memqrcodeService.selectByQRCODE(qrcode);
		if (memqrcode == null) {
			result.setRetmsg("二维码扫描失败");
			return result;
		}
		Date currentTime = new Date();
		long xc = currentTime.getTime()-memqrcode.getMaketime().getTime();

		if (xc > 300000) {
			result.setRetmsg("二维码过期，请重新扫描");
			return result;
		}

		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("ms", "mspay");
		paramMap.put("xsje", xsje);
		paramMap.put("sktNo", sktNo);
		paramMap.put("jlbh", jlbh);
		paramMap.put("hyId", memqrcode.getHyid().toString());
		paramMap.put("direction", "1");
		paramMap.put("partnerId", partnerId);
		paramMap.put("partnerName", partnerName);
		paramMap.put("goodsInfo", goodsInfo);
		paramMap.put("orderId", orderId);
		paramMap.put("goodsName", goodsName);
		paramMap.put("industryCode", industryCode);
		paramMap.put("goodsDescription", goodsDescription);
		paramMap.put("amount", amount);
		paramMap.put("type", type);
		paramMap.put("qrcode", qrcode);
		paramMap.put("loanTerm", "0");
		paramMap.put("payTime", CommonUtils.getNowDate());
		logger.info(JsonUtils.hashMap2Json(paramMap));
		String apiresult = apiService.sendRequest("pay.do", paramMap);
		logger.info("马上交易返回：" + apiresult);
		Gson gson = new Gson();
		Outmsxfpaydata res = gson.fromJson(apiresult, Outmsxfpaydata.class);

		if (res == null) {
			result.setRetmsg("交易失败");
			return result;
		}
		if (res.getCode().equals("0")) {
			result.setRetcode("00");
		} else {
			result.setRetcode(res.getCode());
		}
		result.setRetmsg(res.getMessage());
		return result;
	}
	
	// 马上交易退货
		@RequestMapping(value = "/msxfrefund", method = RequestMethod.POST, produces = "application/json")
		@ResponseBody
		public ResultData msxfrefund(@RequestParam String token, @RequestParam String nsktNo, @RequestParam String njlbh,
				@RequestParam String jlbh, @RequestParam String reason, @RequestParam String refundAmount,
				@RequestParam String refundSign,@RequestParam String hyid,@RequestParam String paytype, @RequestParam String sktNo, @RequestParam String type
				) throws Exception {
			
			ResultData result = new ResultData();
			Map<String, String> paramMap = new HashMap<String, String>();
			paramMap.put("ms", "mspay");
			paramMap.put("nsktNo", nsktNo);
			paramMap.put("njlbh", njlbh);
			paramMap.put("jlbh", jlbh);
			paramMap.put("reason", reason);
			paramMap.put("refundAmount", refundAmount);
			paramMap.put("refundSign", refundSign);
			paramMap.put("sktNo", sktNo);
			paramMap.put("type", type);
			paramMap.put("hyId", hyid);
			paramMap.put("paytype", paytype);
			logger.info(JsonUtils.hashMap2Json(paramMap));
			String apiresult = apiService.sendRequest("refund.do", paramMap);
			logger.info("马上退货返回：" + apiresult);
			Gson gson = new Gson();
			Outmsxfpaydata res = gson.fromJson(apiresult, Outmsxfpaydata.class);

			if (res == null) {
				result.setRetmsg("退货失败");
				return result;
			}
			if (res.getCode().equals("0")) {
				result.setRetcode("00");
			} else {
				result.setRetcode(res.getCode());
			}
			result.setRetmsg(res.getMessage());
			return result;
		}
		
		// 马上交易查询
				@RequestMapping(value = "/msxfquery", method = RequestMethod.POST, produces = "application/json")
				@ResponseBody
				public ResultData msxfquery(@RequestParam String token,@RequestParam String qrcode
						) throws Exception {
					
					ResultData result = new ResultData();
					MEMQRCODE memqrcode = memqrcodeService.selectByQRCODE(qrcode);
					if (memqrcode == null) {
						result.setRetmsg("二维码扫描失败");
						return result;
					}
					MEM_BASEINFO hy= membs.selectByPrimaryKey(memqrcode.getHyid());
					if (hy == null||hy.getPureopenid()==null) {
						result.setRetmsg("微信会员不存在");
						return result;
					}
					
					Map<String, String> paramMap = new HashMap<String, String>();
					paramMap.put("ms", "mspay");
					paramMap.put("openId",URLEncoder.encode(hy.getPureopenid(), "GBK"));
					paramMap.put("type", "1");
					paramMap.put("qrcode", qrcode);
					logger.info(JsonUtils.hashMap2Json(paramMap));
					String apiresult = apiService.sendRequest("yeepaytradequery.do", paramMap);
					logger.info("交易查询返回：" + apiresult);
					Gson gson = new Gson();
					Outmsxfpaydata res = gson.fromJson(apiresult, Outmsxfpaydata.class);

					if (res == null) {
						result.setRetmsg("交易查询");
						return result;
					}
					if (res.getCode().equals("0")) {
						result.setRetcode("00");
						
					} else {
						result.setRetcode(res.getCode());
					}
					result.setData(res.getData());
					result.setRetmsg(res.getMessage());
					return result;
				}
}
