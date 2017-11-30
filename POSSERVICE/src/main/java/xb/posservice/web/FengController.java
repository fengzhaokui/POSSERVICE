package xb.posservice.web;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import xb.posservice.service.ApiService;
//import xb.posservice.util.PropertyUtils;

import xb.posservice.dao.vo.MemberBaseInfo;
import xb.posservice.dao.vo.ResultData;
import xb.posservice.service.FengService;
import xb.posservice.service.TokenService;
import xb.posservice.util.AuthChecker;
import xb.posservice.util.JsonUtils;
//import com.symboltech.msxfInterface.vo.BaseResultInfo;

@Controller
// @RequestMapping("/gethyxx")
public class FengController {
	Logger logger = Logger.getLogger(FengController.class);
	private static DateFormat format = new SimpleDateFormat("yyyy-MM-dd");

	private String returnErr(String message) {
		ResultData baseResultInfo = new ResultData();
		baseResultInfo.setRetcode("-1");
		baseResultInfo.setRetmsg(message);
		try {
			return JsonUtils.object2Json(baseResultInfo);
		} catch (IOException e1) {
			e1.printStackTrace();
			logger.error(e1);
		}
		return "";
	}

	@Autowired
	@Qualifier("fengServiceImpl")
	private FengService fengService;
	@Autowired
	@Qualifier("TokenServiceImpl")
	private TokenService tokenService;

	@Autowired
	@Qualifier("ApiServiceImpl")	
	private ApiService apiService;

	@RequestMapping(value = "/checkcouponapi", method = RequestMethod.GET)
	@ResponseBody
	public String checkcouponapi() {
		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("posno", "004");
		paramMap.put("billid", "14");
		paramMap.put("token", "e1c90916768748708c10f31ab18fec551001");
		paramMap.put("coupon", "0fdee462ed414507930a811b1ee68878,0fdee462ed414507930a811b1ee68878");


		logger.info(JsonUtils.hashMap2Json(paramMap));

		String result = apiService.sendRequest("checkcouponbycode", paramMap);
		return result;
	}

	@RequestMapping(value = "/gethyxx/{hyid}", method = RequestMethod.GET)
	@ResponseBody
	public String gethyxx(@PathVariable int hyid) {
		System.out.print(hyid);
		MemberBaseInfo info = fengService.getMemberInfoByhyId(hyid);
		// return returnErr("获取会员数据失败");
		// return JsonUtils.object2Json(info);
		if (info != null)
			System.out.print(info.getHyName());
		else
			System.out.print("没有查到会员");

		try {
			return JsonUtils.object2Json(info);
		} catch (IOException e1) {
			e1.printStackTrace();
			logger.error(e1);
		}
		return "";

	}
	public  String getNowDate() {  
		 Date currentTime = new Date();  
		    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
		    String dateString = formatter.format(currentTime);
		return  dateString;
	} 

	// @RequestMapping("/getallhyxx")
   // @AuthChecker
   // @SystemControllerLog(description = "删除用户")  
	@Transactional
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	@ResponseBody
	public ResultData getallhyxx1(@RequestParam(value="hyid", required=false) String hyid) throws Exception{
		ResultData result=new ResultData();
		Logger logger = Logger.getLogger(FengController.class);
		logger.info("打日记成功");
		Map<String,Object> mm=new HashMap<String,Object>();  
		mm.put("sktno", "1001");  
		mm.put("rq", "20170828");  
		mm.put("person", -1);  
		fengService.WRITE_SKTRB(mm);
		//m.queryTeacher(mm);  
	//	System.out.println(mm.get("num"));  
	//	result.setData(mm.get("num"));
		result.setRetcode("00");
		return result;
//		TOKEN token = new TOKEN();
//		token.setSktno("123");
//		token.setPersonId(123);
//		token.setCreatetime(new Date());
//		token.setTokenguid(java.util.UUID.randomUUID().toString());
//		tokenService.insert(token);
//		String str=null;
//		//int a=Integer.parseInt(str);
//		TOKEN token1 = new TOKEN();
//		token1.setSktno("1234");
//		token1.setPersonId(1234);
//		token1.setCreatetime(new Date());
//		token1.setTokenguid(java.util.UUID.randomUUID().toString());
//		tokenService.insert(token1);
//		//事物主动回滚
//		TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
//		return result;
		
//		System.out.print("ok");
//		 Date currentTime = new Date();  
//		    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
//		    String dateString = formatter.format(currentTime);
//		    Date currentTime2 = new Date();  
//			long aa = currentTime.getTime();
//			long aa2 = currentTime2.getTime();
//			long xc=aa2-aa;
//		return  dateString;

	}

	@AuthChecker
	@RequestMapping(value = "/gethyxx", method = RequestMethod.GET)
	@ResponseBody
	public ResultData getallhyxx() {
		List<MemberBaseInfo> info = fengService.getAllMemberInfo();
		ResultData result = new ResultData();
		result.setData(info);
		result.setRetcode("00");
		/*
		 * try { return JsonUtils.object2Json(info); } catch (IOException e1) {
		 * e1.printStackTrace(); logger.error(e1); } return "";
		 */
		return result;

	}

	@RequestMapping(value = "/sethyxx", method = RequestMethod.POST)
	@ResponseBody
	public String sethyxx(@RequestParam int hyid, int hyktype) {
		System.out.print(hyid + hyktype);
		MemberBaseInfo hyxx = new MemberBaseInfo();
		hyxx.setHyId(hyid);
		hyxx.setHykType(hyktype);
		long info = fengService.addMemberInfo(hyxx);

		try {
			return JsonUtils.object2Json(info);
		} catch (IOException e1) {
			e1.printStackTrace();
			logger.error(e1);
		}
		return "";

	}

	@RequestMapping(value = "/sethyxxbody", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public String sethyxxbody(@RequestBody MemberBaseInfo hyxx) {

		System.out.print("收到请求");
		long info = 0;
		String errstr = "";
		try {
			info = fengService.addMemberInfo(hyxx);
		} catch (Exception e1) {
			e1.printStackTrace();
			logger.error(e1);
			errstr = e1.getMessage();
		}
		ResultData data = new ResultData();
		if (info > 0) {
			data.setRetcode("00");
		} else {
			data.setRetcode("01");
			data.setRetmsg(errstr);
		}
		data.setData(info);

		try {
			return JsonUtils.object2Json(data);
		} catch (IOException e1) {
			e1.printStackTrace();
			logger.error(e1);
		}
		return "";

	}

}
