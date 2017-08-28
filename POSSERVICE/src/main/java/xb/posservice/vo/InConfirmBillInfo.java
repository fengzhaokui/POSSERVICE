package xb.posservice.vo;

import java.util.ArrayList;
import java.util.List;

public class InConfirmBillInfo {
	 public String posno ;
     public String personid ;
     public String billid ;
     public String oldposno ;
     public String oldbillid ;
     public String cashier;
     public String vipid ;
     public String totalmoney ;
     public String saletype ;
     public String saletime ;
     public String backreason ;
     public String changemoney ;
     public String token ;
     public List<Billgood> goodslist = new ArrayList<Billgood>(); //商品信息
     public List<grantcoupon> usedcouponlist = new ArrayList<grantcoupon>();
     public List<Payments> paymentslist = new ArrayList<Payments>();
}
