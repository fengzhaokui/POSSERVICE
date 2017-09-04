package xb.posservice.web;

import java.math.BigDecimal;
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
import xb.posservice.dao.vo.MEM_COUPON_ACCOUNT;
import xb.posservice.dao.vo.MEM_COUPON_DEF;
import xb.posservice.dao.vo.ResultData;
import xb.posservice.service.ApiService;
import xb.posservice.service.MemBaseInfoService;
import xb.posservice.service.MemCouponAccountService;
import xb.posservice.service.MemCouponDefService;
import xb.posservice.util.CommonUtils;
import xb.posservice.util.JsonUtils;

@Controller
public class ConfirmBillController {
	Logger logger = Logger.getLogger(ConfirmBillController.class);

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
	@Qualifier("ApiServiceImpl")	
	private ApiService apiService;

	// 交易
	// @AuthChecker @RequestBody InConfirmBillInfo info,
	@RequestMapping(value = "/confirmbill", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public String ConfirmBill(@RequestParam(value="token", required=false) String token,@RequestParam(value="billinfo", required=false) String billinfo) throws Exception {
		Gson gson = new Gson();
		ResultData result = new ResultData();

		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("billinfo",billinfo);
		paramMap.put("token",token);
		//logger.info(JsonUtils.hashMap2Json(paramMap));
		String apiresult = apiService.sendRequest("LMConfirmBill", paramMap);
		if (CommonUtils.Isnullstr(apiresult)) {
			result.setRetcode("01");
			result.setRetmsg("交易失败");
			return gson.toJson(result) ;
			}
		
		
		return apiresult;

	}

}
