package xb.posservice.web;

import java.math.BigDecimal;
import java.util.Date;
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

import xb.posservice.dao.vo.ResultData;
import xb.posservice.dao.vo.SKTJYCS;
import xb.posservice.dao.vo.SKTJYCSKey;
import xb.posservice.dao.vo.SKTRB;
import xb.posservice.dao.vo.SKTRBKey;
import xb.posservice.service.FengService;
import xb.posservice.service.SktjycsService;
import xb.posservice.service.SktrbService;
import xb.posservice.util.CommonUtils;
import xb.posservice.util.JsonUtils;
import xb.posservice.vo.OutReportDataInfo;
import xb.posservice.vo.OutReportSalelist;

@Controller
public class ReportDataController {
	Logger logger = Logger.getLogger(ReportDataController.class);
	@Autowired
	@Qualifier("fengServiceImpl")
	private FengService fengService;
	@Autowired
	@Qualifier("SktrbServiceImpl")
	private SktrbService sktrbService;
	@Autowired
	@Qualifier("SktjycsServiceImpl")
	private SktjycsService sktjycsService;
	// 获取班报 日报
		@RequestMapping(value = "/getreportdata", method = RequestMethod.POST, produces = "application/json")
		@ResponseBody
		public ResultData GetReportData(@RequestParam(value="token", required=false) String token, @RequestParam(value="posno", required=false) String posno, @RequestParam(value="person_id", required=false) String person_id)
				throws Exception {
			ResultData result = new ResultData();
			Map<String,Object> mm=new HashMap<String,Object>();  
			mm.put("sktno", posno);  
			mm.put("rq", CommonUtils.getNowDateStr());  
			int personcode=-1;
			if(!CommonUtils.Isnullstr(person_id))
			{
				personcode=Integer.valueOf(person_id);
			}
			mm.put("person", personcode);
			logger.info(mm);
			fengService.WRITE_SKTRB(mm);
			 OutReportDataInfo ord = new OutReportDataInfo();
			 //sale；
			 SKTRBKey rbkey=new SKTRBKey();
			 rbkey.setSktno(posno);
			 rbkey.setLx(0);
			List<SKTRB> salerb=sktrbService.selectByPrimaryKey(rbkey);
			 SKTJYCSKey jycskey=new SKTJYCSKey();
			 jycskey.setSktno(posno);
			 jycskey.setLx(0);
			List<SKTJYCS> salejycs=sktjycsService.selectByPrimaryKey(jycskey);
			 int salenum=0;
			for(SKTJYCS item:salejycs)
			{
				salenum+=item.getJycs();
			}
			ord.sale.billcount=String.valueOf(salenum);
			BigDecimal salemoney=new BigDecimal(0);
			for(SKTRB item:salerb)
			{
				salemoney=salemoney.add(item.getXsje());
				OutReportSalelist ortlist=new OutReportSalelist();
				ortlist.code=String.valueOf(item.getSkfsid());
				ortlist.money=String.valueOf(item.getXsje());
				ortlist.name=item.getSkfsname();
				ortlist.billcount=String.valueOf(item.getXsbs());
				ord.sale.salelist.add(ortlist);
			}
			ord.sale.totalMoney=String.valueOf(salemoney);
			
			 //refund；
			 SKTRBKey refundrbkey=new SKTRBKey();
			 refundrbkey.setSktno(posno);
			 refundrbkey.setLx(1);
			List<SKTRB> refundrb=sktrbService.selectByPrimaryKey(refundrbkey);
			 SKTJYCSKey refundjycskey=new SKTJYCSKey();
			 refundjycskey.setSktno(posno);
			 refundjycskey.setLx(1);
			List<SKTJYCS> refundjycs=sktjycsService.selectByPrimaryKey(refundjycskey);
			 int refundnum=0;
			for(SKTJYCS item:refundjycs)
			{
				refundnum+=item.getJycs();
			}
			ord.refund.billcount=String.valueOf(refundnum);
			BigDecimal refundmoney=new BigDecimal(0);
			for(SKTRB item:refundrb)
			{
				refundmoney=refundmoney.add(item.getXsje());
				OutReportSalelist ortlist=new OutReportSalelist();
				ortlist.code=String.valueOf(item.getSkfsid());
				ortlist.money=String.valueOf(item.getXsje());
				ortlist.name=item.getSkfsname();
				ortlist.billcount=String.valueOf(item.getXsbs());
				ord.refund.salelist.add(ortlist);
			}
			ord.refund.totalMoney=String.valueOf(refundmoney);
			
			//total；
			 SKTRBKey totalrbkey=new SKTRBKey();
			 totalrbkey.setSktno(posno);
			 totalrbkey.setLx(2);
			List<SKTRB> totalrb=sktrbService.selectByPrimaryKey(totalrbkey);
			if(totalrb.size()==0)
			{
				result.setRetmsg("报表没有数据");
				return result;
			}
			 SKTJYCSKey totaljycskey=new SKTJYCSKey();
			 totaljycskey.setSktno(posno);
			 totaljycskey.setLx(2);
			List<SKTJYCS> totaljycs=sktjycsService.selectByPrimaryKey(totaljycskey);
			 int totalnum=0;
			for(SKTJYCS item:totaljycs)
			{
				totalnum+=item.getJycs();
			}
			ord.total.billcount=String.valueOf(totalnum);
			BigDecimal totalmoney=new BigDecimal(0);
			for(SKTRB item:totalrb)
			{
				totalmoney=totalmoney.add(item.getXsje());
				OutReportSalelist ortlist=new OutReportSalelist();
				ortlist.code=String.valueOf(item.getSkfsid());
				ortlist.money=String.valueOf(item.getXsje());
				ortlist.name=item.getSkfsname();
				ortlist.billcount=String.valueOf(item.getXsbs());
				ord.total.salelist.add(ortlist);
			}
			ord.total.totalMoney=String.valueOf(totalmoney);
			
			result.setData(ord);
			result.setRetcode("00");
			return result;
			

		}
}
