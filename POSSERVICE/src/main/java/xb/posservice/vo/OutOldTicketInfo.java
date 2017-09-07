package xb.posservice.vo;

import java.util.ArrayList;
import java.util.List;

public class OutOldTicketInfo {
	 public String posno ;
     public String billid ;
     public String backreason ;
     public String randomcode ;
     /// <summary>
     /// //原收款员工号
     /// </summary>
     public String cashier ;
     public String cashierxtm ;
     public String cashierName ;
     public String saleman ;
     public String salemanxtm ;
     public String salemanName ;
     public String totalmoney ;
     public String discmoney ;
     public String saletime ;
     /// <summary>
     ///  //原交易获得积分
     /// </summary>
     public String awardpoint ;
     public String usedPoint ;
     public String totalpoint ;
     
     public String usedpointmoney ;
     public String changeMoney ;
     public String exchangedPoint ;
    
     public String saletype ;

     public String carno ;
     public String parkcouponhour ;
     public OldTicketBillMember member = new OldTicketBillMember();

     public List<OldTicketBillgood> goodslist = new ArrayList<OldTicketBillgood>();//原交易商品信息 

     public List<OldTicketPayment> paymentslist = new ArrayList<OldTicketPayment>(); //
     public OldTicketPayment cash = null; 
     public List<OldTicketbankpay> bankpaylist = new ArrayList<OldTicketbankpay>();
     public List<thirdpartypay> thirdpartypaylist = new ArrayList<thirdpartypay>();

     public List<grantcoupon> usedcouponlist = new ArrayList<grantcoupon>(); //原交易用券信息

     public List<grantcoupon> grantcouponlist = new ArrayList<grantcoupon>();//原交易返券信息
}
