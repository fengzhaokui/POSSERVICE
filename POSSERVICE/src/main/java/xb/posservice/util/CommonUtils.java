package xb.posservice.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CommonUtils {

	public static boolean Isnullstr(String str)
	{
		if(str==null ||str.trim()=="")
		{
			return true;
		}
		return false;
	}
	public static String ToString(Object obj)
	{
		if(obj==null)
		{
			return "";
		}
		return String.valueOf(obj);
	}
	
	public static String  GetPosNo(String token)
    {
       
        if (token.length() > 32)
        {
            return token.substring(32, token.length() - 32);
        }
        else
            return "";
    }
	public static Date GetDate() throws ParseException
	{
		Date currentTime = new Date();  
	    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
	    String dateString = formatter.format(currentTime);
		String pattern="yyyy-MM-dd";
        return new SimpleDateFormat(pattern).parse(dateString); 
        
	}
	/** 
     * 使用参数Format将字符串转为Date 
	 * @throws ParseException 
     */  
    public static Date GetDate(String strDate, String pattern) throws ParseException  
    {  
    	if(Isnullstr(pattern))
    		pattern="yyyy-MM-dd HH:mm:ss";
        return new SimpleDateFormat(pattern).parse(strDate);  
    }
	public static String getNowDate() {  
		 Date currentTime = new Date();  
		    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
		    String dateString = formatter.format(currentTime);
		return  dateString;
	} 
	public static String getDateTimeStr(Date currentTime) {  
		
		    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
		    String dateString = formatter.format(currentTime);
		return  dateString;
	} 
	
	public static String getNowDateStr() {  
		 Date currentTime = new Date();  
		    SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");  
		    String dateString = formatter.format(currentTime);
		return  dateString;
	} 
	
}
