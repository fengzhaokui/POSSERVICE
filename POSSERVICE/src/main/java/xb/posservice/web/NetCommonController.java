package xb.posservice.web;

import java.util.HashMap;
import java.util.Map;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import xb.posservice.service.ApiService;
import xb.posservice.service.MemBaseInfoService;
import xb.posservice.service.MemCouponAccountService;
import xb.posservice.service.MemCouponDefService;
import xb.posservice.service.MemQrcodeService;
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
