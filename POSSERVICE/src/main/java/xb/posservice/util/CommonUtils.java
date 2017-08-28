package xb.posservice.util;

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
	
	public static String  GetPosNo(String token)
    {
       
        if (token.length() > 32)
        {
            return token.substring(32, token.length() - 32);
        }
        else
            return "";
    }
	
	public static String getNowDate() {  
		 Date currentTime = new Date();  
		    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
		    String dateString = formatter.format(currentTime);
		return  dateString;
	} 
	
}
