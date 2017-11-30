package xb.posservice.web;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


import xb.posservice.dao.vo.ResultData;
import xb.posservice.dao.vo.SKT;
import xb.posservice.dao.vo.TOKEN;
import xb.posservice.service.ApiService;
import xb.posservice.service.MemBaseInfoService;
import xb.posservice.service.MemCouponAccountService;
import xb.posservice.service.MemCouponDefService;
import xb.posservice.service.MemQrcodeService;
import xb.posservice.service.SktService;
import xb.posservice.service.TokenService;
import xb.posservice.util.JsonUtils;
import xb.posservice.util.RedisHelper;
import xb.posservice.util.TickCommon;
import xb.posservice.util.UOracleFRedis;

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
	@Autowired
	@Qualifier("SktServiceImpl")
	private SktService sktService;
	public  ExecutorService fixedThreadPool = Executors.newFixedThreadPool(50); 
	public  void startNotify(final String sktno){
		fixedThreadPool.execute(new Runnable() {
			
			//@Override
			public void run() {
				try {
					Thread.sleep(6000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				//AddToken(sktno);
			}
		});
	}
	@RequestMapping(value = "/redistest", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public ResultData test(@RequestParam(value="sktno", required=false) String sktno,@RequestParam(value="personid", required=false) String personid) throws Exception {
		ResultData result=new ResultData();
		RedisHelper redis=new RedisHelper();
		
		//redis.show();
		//result.setData(redis.GetString(key));
		//result.setData("token:"+redis.GetToken(key));
		//UOracleFRedis oo=new UOracleFRedis();
		//AddToken();
		//存入redis同时返回；
		result.setData(redis.GetToken(sktno, personid));
		
		//开个线程睡眠1分钟存入oracle；
		String ss="我";
		ss.length();
		startNotify(sktno);
		
		return result;
	}
	public void AddToken(String sktno)
	{
		RedisHelper redis=new RedisHelper();
		TOKEN token=redis.GetTokenHash(sktno);
		tokenService.insert(token);
	}
	@Autowired
	@Qualifier("TokenServiceImpl")
	private TokenService tokenService;
	
	@Autowired
	//@Qualifier("TickCommon")
	private TickCommon tc;
	public void AddToken()
	{
		RedisHelper redis=new RedisHelper();
		List<String> keys= redis.GetAllRedisKeys();
		for(String key:keys)
		{
			String value=redis.GetString(key);
			TOKEN token = new TOKEN();
			token.setSktno(key);
			token.setPersonId(-1);
			token.setCreatetime(new Date());
			token.setTokenguid(value);
			tokenService.insert(token);
			
		}
	}

	// 获取小票
		// @AuthChecker
		@RequestMapping(value = "/gettick", method = RequestMethod.POST, produces = "application/json")
		@ResponseBody
		public ResultData GetTick(@RequestParam(value="token", required=false) String token,@RequestParam(value="posno", required=false) String posno) throws Exception {
			ResultData result=new ResultData();
			//TickCommon tc=new TickCommon();
			SKT skt = sktService.selectByPrimaryKey(posno);
			result.setData(tc.GetTickList(posno));
			if(result.getData()!=null)
			{
				result.setRetcode("00");
				result.setRetmsg("成功");
			}
			else
			{
				result.setRetcode("01");
				result.setRetmsg("失败");
			}
			
			return result;
		}

//	// 获取小票g
//	// @AuthChecker
//	@RequestMapping(value = "/gettick", method = RequestMethod.POST, produces = "application/json")
//	@ResponseBody
//	public String GetTick(@RequestParam(value="token", required=false) String token) throws Exception {
//
//		Map<String, String> paramMap = new HashMap<String, String>();
//
//		paramMap.put("token", token);
//		logger.info(JsonUtils.hashMap2Json(paramMap));
//		String apiresult = apiService.sendRequest("gettick", paramMap);
//		return apiresult;
//	}

//	// 获取班报 日报
//	@RequestMapping(value = "/getreportdata", method = RequestMethod.POST, produces = "application/json")
//	@ResponseBody
//	public String GetReportData(@RequestParam(value="token", required=false) String token, @RequestParam(value="posno", required=false) String posno, @RequestParam(value="person_id", required=false) String person_id)
//			throws Exception {
//
//		Map<String, String> paramMap = new HashMap<String, String>();
//
//		paramMap.put("token", token);
//		paramMap.put("posno", posno);
//		paramMap.put("person_id", person_id);
//		logger.info(JsonUtils.hashMap2Json(paramMap));
//		String apiresult = apiService.sendRequest("getreportdata", paramMap);
//		return apiresult;
//	}
	
//	// 交易补打
//		@RequestMapping(value = "/getreprintinfo", method = RequestMethod.POST, produces = "application/json")
//		@ResponseBody
//		public String GetReprintInfo(@RequestParam(value="token", required=false) String token, @RequestParam(value="posno", required=false) String posno, @RequestParam(value="newposno", required=false) String newposno
//				, @RequestParam(value="billid", required=false) String billid)throws Exception {
//
//			Map<String, String> paramMap = new HashMap<String, String>();
//			paramMap.put("token", token);
//			paramMap.put("posno", posno);
//			paramMap.put("newposno", newposno);
//			paramMap.put("billid", billid);
//			logger.info(JsonUtils.hashMap2Json(paramMap));
//			String apiresult = apiService.sendRequest("getreprintinfo", paramMap);
//			return apiresult;
//		}
//		//获取原单数据；
//		@RequestMapping(value = "/getoldticket", method = RequestMethod.POST, produces = "application/json")
//		@ResponseBody
//		public String GetOldTicket(@RequestParam(value="token", required=false) String token, @RequestParam(value="posno", required=false) String posno, @RequestParam(value="newposno", required=false) String newposno
//				, @RequestParam(value="billid", required=false) String billid)throws Exception {
//
//			Map<String, String> paramMap = new HashMap<String, String>();
//
//			paramMap.put("token", token);
//			paramMap.put("posno", posno);
//			paramMap.put("newposno", newposno);
//			paramMap.put("billid", billid);
//			logger.info(JsonUtils.hashMap2Json(paramMap));
//			String apiresult = apiService.sendRequest("getoldticket", paramMap);
//			return apiresult;
//		}

}
