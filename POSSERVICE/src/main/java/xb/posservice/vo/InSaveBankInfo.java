package xb.posservice.vo;

public class InSaveBankInfo {
	 /// <summary>
    /// 款台号 
    /// </summary>
    public String posno;

    /// <summary>
    /// 小票号
    /// </summary>
    public String billid ;
    /// <summary>
    /// 交易类型(1消费,2当日撤销,3隔日退货) 
    /// </summary>
    public String transtype ;
    /// <summary>
    /// 卡号(支付宝账号、微信账号) 
    /// </summary>
    public String cardno ;
    /// <summary>
    /// 银行代码 
    /// </summary>
    public String bankcode;
    /// <summary>
    /// 批次号 
    /// </summary>
    public String batchno ;
    /// <summary>
    /// 参考号
    /// </summary>
    public String refno ;
    /// <summary>
    /// 流水号
    /// </summary>
    public String tradeno ;
    /// <summary>
    /// 金额
    /// </summary>
    public String amount ;
    /// <summary>
    /// 扣减金额(预留，如果银行有扣减活动，则记录)
    /// </summary>
    public String decmoney ;

    public String skfsid ;
}
