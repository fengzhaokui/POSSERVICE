package xb.posservice.web;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
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
import com.google.gson.reflect.TypeToken;

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
// @RequestMapping("/gethyxx")
public class CouponController {
	Logger logger = Logger.getLogger(CouponController.class);

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
	 
	// 验证优惠券功能 通过code @RequestBody InCheckCouponInfo info
	// @AuthChecker
	@RequestMapping(value = "/checkcoupon", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public ResultData checkcoupon(@RequestParam String token,@RequestParam String billid,@RequestParam String billmoney,@RequestParam String posno,@RequestParam String couponlist) throws Exception {
		ResultData result = new ResultData();
		InCheckCouponInfo info=new InCheckCouponInfo();
		Gson gson = new Gson();
		info.token=token;				
		info.billid=billid;
		info.billmoney=billmoney;
		info.posno=posno;
		List<InCouponInfo> clist = gson.fromJson(couponlist, new TypeToken<List<InCouponInfo>>(){}.getType());  
		info.couponlist=clist;
		if (info == null || CommonUtils.Isnullstr(info.billmoney) || info.couponlist.size() <= 0) {
			result.setRetcode("01");
			result.setRetmsg("输入参数错误");
			return result;
		}
		BigDecimal money = new BigDecimal(info.billmoney);
		// logger.info("money:"+money);
		System.out.print("money:" + money);
		if (money.equals(0)) {
			result.setRetcode("01");
			result.setRetmsg("订单金额必须大于0");
			return result;
		}
		OutCheckCouponInfo out=new OutCheckCouponInfo();
		//SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		Long vipid=0l;
		List<String> codelist=new ArrayList<String>();
		for (InCouponInfo item : info.couponlist) {
			MEM_COUPON_ACCOUNT mca = couponService.selectBycode(item.code);
			if (mca != null) {

				codelist.add(item.code);
				if(vipid==0)
					vipid=mca.getHyid();
				if(vipid!=mca.getHyid())
				{
					result.setRetcode("01");
					result.setRetmsg("优惠券不属于同一个会员");
					return result;
				}
				//会员信息
			//MEM_BASEINFO mem=memService.selectByPrimaryKey(mca.getHdid());
			//out.vipid=mca.getHdid().toString();
			}
		}
		if(codelist.size()>0)
		{
			//判断券是否可用；
		
			String coupon=	StringUtils.join(codelist.toArray(),',');
			Map<String, String> paramMap = new HashMap<String, String>();
			paramMap.put("posno", info.posno);
			paramMap.put("billid", info.billid);
			paramMap.put("money", info.billmoney);
			paramMap.put("token", info.token);
			paramMap.put("coupon", coupon);
			logger.info(JsonUtils.hashMap2Json(paramMap));
			String apiresult = apiService.sendRequest("checkcouponbycode", paramMap);
			
			ResultDataRes apiresultdata = gson.fromJson(apiresult,ResultDataRes.class);
			
			if(apiresultdata!=null&&apiresultdata.getRetcode().equals("00")&&apiresultdata.getData()!=null)
			{
				
				for(grantcoupon gc : apiresultdata.getData().couponlist)
				{
					out.couponlist.add(gc);
				}
				out.vipid=vipid.toString();
				result.setRetcode("00");
				result.setData(out);
			}
			else
			{
				result.setRetcode("01");
				result.setRetmsg("没有可用优惠券");
			}
			
//			out.vipid=vipid.toString();
//			result.setRetcode("00");
//			result.setData(out);
		}
		else
		{
			result.setRetcode("01");
			result.setRetmsg("没有优惠券可用");
		}
		return result;

	}

}
