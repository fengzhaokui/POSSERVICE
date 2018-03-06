package xb.posservice.web;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import xb.posservice.vo.*;
import xb.posservice.dao.vo.SKT;
import xb.posservice.dao.vo.TOKEN;
import xb.posservice.dao.vo.XTCZY;
import xb.posservice.dao.vo.GOODS;
import xb.posservice.dao.vo.HIS_SALE;
import xb.posservice.dao.vo.MALLDEF;
import xb.posservice.dao.vo.PERSONINFO;
import xb.posservice.dao.vo.POSCONFIG;
import xb.posservice.dao.vo.REFUNDREASON;
import xb.posservice.dao.vo.ResultData;
import xb.posservice.dao.vo.SALE;
import xb.posservice.dao.vo.SHOPDEF;
import xb.posservice.dao.vo.SKFS;
import xb.posservice.service.GoodsService;
import xb.posservice.service.HisSaleService;
import xb.posservice.service.MallService;
import xb.posservice.service.PersoninfoService;
import xb.posservice.service.PosconfigService;
import xb.posservice.service.RefundreasonService;
import xb.posservice.service.SaleService;
import xb.posservice.service.ShopService;
import xb.posservice.service.SkfsService;
import xb.posservice.service.SktService;
import xb.posservice.service.TokenService;
import xb.posservice.service.XtczyService;
import xb.posservice.util.AuthChecker;
import xb.posservice.util.CommonUtils;
import xb.posservice.util.JsonUtils;
import xb.posservice.vo.InLoginInfo;

@Controller
// @RequestMapping("/gethyxx")
public class LoginController {
	Logger logger = Logger.getLogger(LoginController.class);

	@Autowired
	@Qualifier("SktServiceImpl")
	private SktService sktService;

	@Autowired
	@Qualifier("SaleServiceImpl")
	private SaleService saleService;

	@Autowired
	@Qualifier("HisSaleServiceImpl")
	private HisSaleService hissaleService;

	@Autowired
	@Qualifier("TokenServiceImpl")
	private TokenService tokenService;

	@Autowired
	@Qualifier("ShopServiceImpl")
	private ShopService shopService;

	@Autowired
	@Qualifier("PosconfigServiceImpl")
	private PosconfigService posconfigService;

	@Autowired
	@Qualifier("MallServiceImpl")
	private MallService mallService;

	@Autowired
	@Qualifier("XtczyServiceImpl")
	private XtczyService xtczyService;

	@Autowired
	@Qualifier("PersoninfoServiceImpl")
	private PersoninfoService personinfoService;

	@Autowired
	@Qualifier("GoodsServiceImpl")
	private GoodsService goodsService;

	@Autowired
	@Qualifier("RefundreasonServiceImpl")
	private RefundreasonService refundreasonService;

	@Autowired
	@Qualifier("SkfsServiceImpl")
	private SkfsService skfsService;

	// @AuthChecker
	@RequestMapping(value = "/getskt", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public ResultData getskt(@RequestBody SKT hyxx) {
		SKT skt = sktService.selectByPrimaryKey(hyxx.getSktno());
		ResultData result = new ResultData();
		if (skt != null) {
			result.setData(skt);
			result.setRetcode("00");
		} else {
			result.setRetcode("01");
			result.setRetmsg("没有数据");
		}
		return result;

	}

	// 登录接口 public ResultData login(@RequestBody InLoginInfo info) {
	// @AuthChecker
	@RequestMapping(value = "/login", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public ResultData login(@RequestParam(value = "machinecode", required = false) String machinecode,
			@RequestParam(value = "password", required = false) String password,
			@RequestParam(value = "personcode", required = false) String personcode) throws Exception {
		ResultData result = new ResultData();
		InLoginInfo info = new InLoginInfo();
		info.machinecode = machinecode;
		info.password = password;
		info.personcode = personcode;
		if (info == null || CommonUtils.Isnullstr(info.machinecode) || CommonUtils.Isnullstr(info.personcode)
				|| CommonUtils.Isnullstr(info.password)) {
			result.setRetcode("01");
			result.setRetmsg("输入参数错误");
			return result;
		}
		SKT skt = sktService.selectByMaCode(info.machinecode);
		if (skt == null) {
			result.setRetcode("01");
			result.setRetmsg("没有收款台数据");
			return result;
		}
		OutLoginInfo oinfo = new OutLoginInfo();
		oinfo.setPosno(skt.getSktno());
		SHOPDEF shop = shopService.selectByPrimaryKey(skt.getShopid());
		OutShopInfo sinfo = new OutShopInfo();
		oinfo.shopmsg = sinfo;
		if (shop != null) {
			sinfo.id = shop.getId().toString();
			sinfo.code = shop.getCode();
			sinfo.name = shop.getName();
		} else {
			result.setRetcode("01");
			result.setRetmsg("没有店铺数据");
			return result;
		}
		// 门店信息
		OutShopInfo minfo = new OutShopInfo();
		MALLDEF mall = mallService.selectByPrimaryKey(shop.getMallid());
		if (mall != null) {
			minfo.id = mall.getId().toString();
			minfo.code = mall.getCode();
			minfo.name = mall.getName();
			minfo.yeepaysubno=mall.getYeepaysubno();
			minfo.yttype=mall.getYttype().toString();
		}
		oinfo.mallmsg = minfo;
		long rydm = Long.valueOf(info.personcode);
		PERSONINFO pinfo = personinfoService.selectByrydm(rydm, shop.getId());
		if (pinfo != null) {
			oinfo.setPerson_id(pinfo.getPersonId().toString());
			oinfo.setPerson_name(pinfo.getPersonName());
			oinfo.setPersoncode(pinfo.getRydm());
		} else {
			result.setRetcode("06");
			result.setRetmsg("您不是本门店营业员");
			return result;
		}
		// 验证密码
		XTCZY czy = new XTCZY();
		czy.setPersonId(pinfo.getPersonId());
		czy.setLoginPassword(info.password.toUpperCase());
		XTCZY xtczy = xtczyService.selectByPWD(czy);
		if (xtczy == null) {
			result.setRetcode("01");
			result.setRetmsg("密码错误");
			return result;
		}

		oinfo.ismallpos = skt.getBjTyzf();
		oinfo.mac1 = skt.getMac1();
		oinfo.mac2 = skt.getMac2();
		oinfo.thirdpayuser = skt.getThirdpayuser();
		oinfo.thirdpaypwd = skt.getThirdpaypwd();
		// 登录人集合；
		LoginPersonInfo lpinfo = null;
		List<PERSONINFO> plist = personinfoService.selectByshop((long) shop.getId());
		for (PERSONINFO x : plist) {
			lpinfo = new LoginPersonInfo();
			oinfo.loginpresonlist.add(lpinfo);
			lpinfo.rydm = x.getRydm();
			lpinfo.personid = x.getPersonId().toString();
			lpinfo.personname = x.getPersonName();

		}
		// 获取最大小票号
		long maxjlbh = 0;
		SALE sale = saleService.selectMaxJlbh(skt.getSktno());
		if (sale != null) {
			maxjlbh = sale.getJlbh();
			// oinfo.setBillid(Long.toString(sale.getJlbh() + 1));
		}
		HIS_SALE hissale = hissaleService.selectMaxJlbh(skt.getSktno());
		if (hissale != null) {
			if (maxjlbh < hissale.getJlbh()) {
				maxjlbh = hissale.getJlbh();
			}
			// oinfo.setBillid(Long.toString(sale.getJlbh() + 1));
		}
		oinfo.setBillid(Long.toString(maxjlbh + 1));
		// POSCONFIG配置信息；
		OutPosConfigInfo opc = null;
		List<POSCONFIG> listconfig = posconfigService.getAllPosconfig();
		for (POSCONFIG x : listconfig) {
			opc = new OutPosConfigInfo();
			oinfo.configinfolist.add(opc);
			opc.id = x.getJlbh().toString();
			opc.value = x.getCurVal().toString();
			opc.desc = x.getName();

		}

		TOKEN token = new TOKEN();
		token.setSktno(skt.getSktno());
		token.setPersonId(pinfo.getPersonId().intValue());
		token.setCreatetime(new Date());
		token.setTokenguid(java.util.UUID.randomUUID().toString().replaceAll("-", "") + skt.getSktno());
		oinfo.setToken(token.getTokenguid());
		tokenService.insert(token);
		result.setData(oinfo);
		result.setRetcode("00");
		return result;

	}

	@RequestMapping(value = "/getposinitializeinfo", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public ResultData GetPosInitializeInfo(@RequestParam(value = "token", required = false) String token)
			throws Exception {
		ResultData result = new ResultData();
		if (CommonUtils.Isnullstr(token)) {
			result.setRetcode("01");
			result.setRetmsg("输入参数错误");
			return result;
		}
		TOKEN tokendata = tokenService.selectByPrimaryKey(token);

		SKT skt = sktService.selectByPrimaryKey(tokendata.getSktno());
		if (skt == null) {
			result.setRetcode("01");
			result.setRetmsg("没有收款台数据");
			return result;
		}
		OutInitializeInfo oinfo = new OutInitializeInfo();
		OutSpxx good = null;
		List<GOODS> goods = goodsService.selectByshopid((long) skt.getShopid());
		for (GOODS item : goods) {
			good = new OutSpxx();
			good.barcode = item.getBarcode();
			good.goodsname = item.getName();
			good.id = item.getSpId().toString();
			good.code = item.getSpcode().toString();
			if (item.getLsdj() != null)
				good.price = item.getLsdj().toString();
			else
				good.price = "0";
			good.sptype = item.getSptype().toString();
			good.unit = item.getUnit();
			oinfo.brandgoodslist.add(good);
		}
		List<SKFS> skfs = skfsService.selectByskt(skt.getSktno());
		OutpayInfo pay = null;
		for (SKFS item : skfs) {
			pay = new OutpayInfo();
			oinfo.paymentslist.add(pay);
			pay.id = item.getCode().toString();
			pay.name = item.getName();
			pay.type = item.getType().toString();
			if (item.getYhqid() != null)
				pay.couponid = item.getYhqid().toString();

		}
		List<REFUNDREASON> reflist = refundreasonService.selectall();
		oinfo.refundreasonlist = reflist;
		result.setData(oinfo);

		result.setRetcode("00");
		return result;
	}

	// 解锁
	// @AuthChecker
	@RequestMapping(value = "/unlock", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public ResultData unlock(@RequestParam(value = "token", required = false) String token,
			@RequestParam(value = "password", required = false) String password) throws Exception {
		ResultData result = new ResultData();
		if (CommonUtils.Isnullstr(password)) {
			result.setRetcode("-1");
			result.setRetmsg("密码不可为空");
			return result;
		}
		TOKEN tokendata = tokenService.selectByPrimaryKey(token);
		if (tokendata == null) {
			result.setRetcode("01");
			result.setRetmsg("token失效");
			return result;
		}
		// 验证密码
		XTCZY czy = new XTCZY();
		czy.setPersonId(tokendata.getPersonId().longValue());
		czy.setLoginPassword(password.toUpperCase());
		XTCZY xtczy = xtczyService.selectByPWD(czy);
		if (xtczy == null) {
			result.setRetcode("01");
			result.setRetmsg("密码错误");
			return result;
		}
		SKT skt = sktService.selectByPrimaryKey(tokendata.getSktno());
		PERSONINFO person = personinfoService.selectByPrimaryKey(tokendata.getPersonId().longValue());
		if (person != null && skt != null) {
			if (person.getDeptid() == skt.getShopid().longValue()) {
				result.setRetcode("00");
				// result.setRetmsg("密码错误");
				return result;
			}
		}
		result.setRetcode("01");
		result.setRetmsg("款员非本店铺，不允许操作");
		return result;
		// Map<String, String> paramMap = new HashMap<String, String>();
		// paramMap.put("password", password);
		// paramMap.put("token", token);
		// logger.info(JsonUtils.hashMap2Json(paramMap));
		// String apiresult = apiService.sendRequest("unlock", paramMap);
		//
		// return apiresult;

	}

	// 修改密码
	// @AuthChecker
	@RequestMapping(value = "/repassword", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public ResultData RePassword(@RequestParam(value = "token", required = false) String token,
			@RequestParam(value = "personcode", required = false) String personcode,
			@RequestParam(value = "newpwd", required = false) String newpwd,
			@RequestParam(value = "oldpwd", required = false) String oldpwd) throws Exception {
		ResultData result = new ResultData();
		if (CommonUtils.Isnullstr(newpwd) || CommonUtils.Isnullstr(oldpwd) || CommonUtils.Isnullstr(personcode)) {
			result.setRetcode("-1");
			result.setRetmsg("参数不可为空");
			return result;
		}
		TOKEN tokendata = tokenService.selectByPrimaryKey(token);
		if (tokendata == null) {
			result.setRetcode("01");
			result.setRetmsg("token失效");
			return result;
		}
		SKT skt = sktService.selectByPrimaryKey(tokendata.getSktno());
		PERSONINFO person = personinfoService.selectByrydm(Long.valueOf(personcode), skt.getShopid());
		if(person==null)
		{
			result.setRetcode("01");
			result.setRetmsg("营业员不存在");
			return result;
		}
		
		// 验证密码
		XTCZY czy = new XTCZY();
		czy.setPersonId(person.getPersonId().longValue());
		czy.setLoginPassword(oldpwd.toUpperCase());
		XTCZY xtczy = xtczyService.selectByPWD(czy);
		if (xtczy == null) {
			result.setRetcode("01");
			result.setRetmsg("密码错误");
			return result;
		}
		XTCZY xt=new XTCZY();
		xt.setPersonId(person.getPersonId().longValue());
		xt.setLoginPassword(newpwd.toUpperCase());
		int num=xtczyService.updateByPrimaryKeySelective(xt);
		if(num>0)
		{
			result.setRetcode("00");
			//result.setRetmsg("密码错误");
		}
		else
		{
			result.setRetcode("01");
			result.setRetmsg("修改密码失败");
		}

		return result;
		// Map<String, String> paramMap = new HashMap<String, String>();
		// paramMap.put("oldpwd", oldpwd);
		// paramMap.put("personcode", personcode);
		// paramMap.put("newpwd", newpwd);
		// paramMap.put("token", token);
		// logger.info(JsonUtils.hashMap2Json(paramMap));
		// String apiresult = apiService.sendRequest("repassword", paramMap);
		//
		// return apiresult;

	}
}
