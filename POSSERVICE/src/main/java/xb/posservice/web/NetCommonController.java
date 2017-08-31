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
import xb.posservice.dao.vo.MEMQRCODE;
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
public class NetCommonController {
	Logger logger = Logger.getLogger(NetCommonController.class);

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

	// 解锁
	// @AuthChecker
	@RequestMapping(value = "/unlock", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public String unlock(@RequestParam(value="token", required=false) String token, @RequestParam(value="password", required=false) String password) throws Exception {

		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("password", password);
		paramMap.put("token", token);
		logger.info(JsonUtils.hashMap2Json(paramMap));
		String apiresult = apiService.sendRequest("unlock", paramMap);

		return apiresult;

	}

	// 修改密码
	// @AuthChecker
	@RequestMapping(value = "/repassword", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public String RePassword(@RequestParam(value="token", required=false) String token, @RequestParam(value="personcode", required=false) String personcode, @RequestParam(value="newpwd", required=false) String newpwd,
			@RequestParam(value="oldpwd", required=false) String oldpwd) throws Exception {

		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("oldpwd", oldpwd);
		paramMap.put("personcode", personcode);
		paramMap.put("newpwd", newpwd);
		paramMap.put("token", token);
		logger.info(JsonUtils.hashMap2Json(paramMap));
		String apiresult = apiService.sendRequest("repassword", paramMap);

		return apiresult;

	}

	// 获取小票
	// @AuthChecker
	@RequestMapping(value = "/gettick", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public String GetTick(@RequestParam(value="token", required=false) String token) throws Exception {

		Map<String, String> paramMap = new HashMap<String, String>();

		paramMap.put("token", token);
		logger.info(JsonUtils.hashMap2Json(paramMap));
		String apiresult = apiService.sendRequest("gettick", paramMap);
		return apiresult;
	}

	// 获取班报 日报
	@RequestMapping(value = "/getreportdata", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public String GetReportData(@RequestParam(value="token", required=false) String token, @RequestParam(value="posno", required=false) String posno, @RequestParam(value="person_id", required=false) String person_id)
			throws Exception {

		Map<String, String> paramMap = new HashMap<String, String>();

		paramMap.put("token", token);
		paramMap.put("posno", posno);
		paramMap.put("person_id", person_id);
		logger.info(JsonUtils.hashMap2Json(paramMap));
		String apiresult = apiService.sendRequest("getreportdata", paramMap);
		return apiresult;
	}
	
	// 交易补打
		@RequestMapping(value = "/getreprintinfo", method = RequestMethod.POST, produces = "application/json")
		@ResponseBody
		public String GetReprintInfo(@RequestParam(value="token", required=false) String token, @RequestParam(value="posno", required=false) String posno, @RequestParam(value="newposno", required=false) String newposno
				, @RequestParam(value="billid", required=false) String billid)throws Exception {

			Map<String, String> paramMap = new HashMap<String, String>();

			paramMap.put("token", token);
			paramMap.put("posno", posno);
			paramMap.put("newposno", newposno);
			paramMap.put("billid", billid);
			logger.info(JsonUtils.hashMap2Json(paramMap));
			String apiresult = apiService.sendRequest("getreprintinfo", paramMap);
			return apiresult;
		}
		//获取原单数据；
		@RequestMapping(value = "/getoldticket", method = RequestMethod.POST, produces = "application/json")
		@ResponseBody
		public String GetOldTicket(@RequestParam(value="token", required=false) String token, @RequestParam(value="posno", required=false) String posno, @RequestParam(value="newposno", required=false) String newposno
				, @RequestParam(value="billid", required=false) String billid)throws Exception {

			Map<String, String> paramMap = new HashMap<String, String>();

			paramMap.put("token", token);
			paramMap.put("posno", posno);
			paramMap.put("newposno", newposno);
			paramMap.put("billid", billid);
			logger.info(JsonUtils.hashMap2Json(paramMap));
			String apiresult = apiService.sendRequest("getoldticket", paramMap);
			return apiresult;
		}

}
