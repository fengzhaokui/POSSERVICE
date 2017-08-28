package xb.posservice.util;

import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser.Feature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtils {
	
	public static ObjectMapper objectMapper;
	/**
	 * 使用泛型方法，把json字符串转换为相应的JavaBean对象。
	 * (1)转换为普通JavaBean：readValue(json,Student.class)
	 * (2)转换为List,如List<Student>,将第二个参数传递为Student
	 * [].class.然后使用Arrays.asList();方法把得到的数组转换为特定类型的List
	 * 
	 * @param jsonStr
	 * @param valueType
	 * @return
	 */
	public static <T> T readValue(String jsonStr, Class<T> valueType) {
		if (objectMapper == null) {
			objectMapper = new ObjectMapper();
		}

		try {
			return objectMapper.readValue(jsonStr, valueType);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}
	public static <T> T readObject(String jsonStr, Class<T> valueType) {
		
		//Object	object = new ObjectMapper();
		JSONObject obj = new JSONObject().fromObject(jsonStr);
		T jb = (T)JSONObject.toBean(obj,valueType);
		

		return jb;
	}
	
	/**
	 * 把JavaBean转换为json字符串
	 * 
	 * @param object
	 * @return
	 */
	public static String toJSon(Object object) {
		if (objectMapper == null) {
			objectMapper = new ObjectMapper();
		}

		try {
			return objectMapper.writeValueAsString(object);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}
	
	/**
	 * 将java对象转化为json
	 * @param object 要转化的Java对象
	 * @throws IOException 
	 */
	public static String object2Json(Object object) throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		StringWriter sw = new StringWriter();
		JsonGenerator jsonGenerator = new JsonFactory().createGenerator(sw);
		mapper.configure(Feature.ALLOW_SINGLE_QUOTES, true);
		mapper.writeValue(jsonGenerator, object);
		jsonGenerator.close();
		return sw.toString();
	}
	/**
	 * 将java对象转化为jsonArray
	 * @param object 要转化的Java对象
	 * @throws IOException 
	 */
	public static Object object2JsonArray(Object object) throws Exception {
		JSONArray array = JSONArray.fromObject(object);
		return array;
	}
	/**
	 * 将json数据转为List<?>
	 * @param json json字符串
	 * @param clazz 需要将json转化为的对象
	 * @return
	 * @throws Exception
	 */
	public static List<?> json2List(String json,Class<?> clazz) throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		JavaType javaType = mapper.getTypeFactory().constructParametricType(List.class, clazz);
		mapper.configure(Feature.ALLOW_SINGLE_QUOTES, true) ;
		return mapper.readValue(json, javaType);
	}
	
	/**
	 * 将json数据转为List<?>
	 * @param json json字符串
	 * @param clazz 需要将json转化为的对象
	 * @return
	 * @throws Exception
	 */
	public static Object json2Object(String json,Class<?> clazz) throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(Feature.ALLOW_SINGLE_QUOTES, true) ;
		return mapper.readValue(json, clazz);
	}
	
	@SuppressWarnings("unchecked")
	public static Map<String,Object> json2Map(String json) throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(Feature.ALLOW_SINGLE_QUOTES, true) ;
		return mapper.readValue(json, Map.class);
	}
	
    /** 
     * 将json格式的字符串解析成Map对象 <li> 
     * json格式：{"name":"admin","retries":"3fff","testname" 
     * :"ddd","testretries":"fffffffff"} 
     */  
	public static HashMap<String, String> json2HashMap(Object object)  
    {  
        HashMap<String, String> data = new HashMap<String, String>();  
        // 将json字符串转换成jsonObject  
        JSONObject jsonObject = JSONObject.fromObject(object);  
        Iterator it = jsonObject.keys();  
        // 遍历jsonObject数据，添加到Map对象  
        while (it.hasNext())  
        {  
            String key = String.valueOf(it.next()); 
            if(key!=null && key.length()>0 && jsonObject.get(key)!=null && jsonObject.get(key).toString().length()>0){
            	 String value = jsonObject.get(key).toString();  
            	 if(key!=null && key.length()>0){
            		 data.put(key, value);  
            	 }else{
            		 data.put(key, ""); 
            	 }
            }
        }  
        return data;  
    }  
	 /** 
     * 将json格式的字符串解析成Map对象 <li> 
     * json格式：{"name":"admin","retries":"3fff","testname" 
     * :"ddd","testretries":"fffffffff"} 
     */  
	public static String hashMap2Json(Map<String, String> map)  
    {  
		StringBuffer resultString=new StringBuffer();
		resultString.append("{");
		int i=0;
		for(String key:map.keySet()){
			resultString.append("\""+key+"\":\""+map.get(key)+"\"");
			i++;
			if(i<map.keySet().size()){
				resultString.append(",");
			}
		}
        resultString.append("}");
        return resultString.toString();  
    }

	public static List<Map<String, String>> json2ListHashMap(String jsonArrayString) {
/*		List<Map<String, String>> dataList = new ArrayList<Map<String, String>>();
		String tmp=jsonArrayString.replace("[", "");
		tmp=tmp.replace("]", "");
		tmp=tmp.replace("},{", "}@@{");
		String[] jsonArray=tmp.split("@@");
		for (String object : jsonArray) {
			HashMap<String, String> data = new HashMap<String, String>();  
	        // 将json字符串转换成jsonObject  
	        JSONObject jsonObject = JSONObject.fromObject(object);  
	        Iterator it = jsonObject.keys();  
	        // 遍历jsonObject数据，添加到Map对象  
	        while (it.hasNext())  
	        {  
	            String key = String.valueOf(it.next()); 
	            if(key!=null && key.length()>0 && jsonObject.get(key)!=null && jsonObject.get(key).toString().length()>0){
	            	 String value = jsonObject.get(key).toString();  
	            	 if(key!=null && key.length()>0){
	            		 data.put(key, value);  
	            	 }else{
	            		 data.put(key, ""); 
	            	 }
	            }
	        }  
	        dataList.add(data) ;  
		}*/
		
		List<Map<String, String>> dataList = new ArrayList<Map<String, String>>();
		JSONArray jsonArray = JSONArray.fromObject(jsonArrayString);
		int size = jsonArray.size();
		Iterator it = null;
		String key = null;
		String value = null;
		Map<String,String> map = null;
		JSONObject jsonObject = null;
        for(int i=0;i<size;i++){
        	//JSONObject 转化成map
        	map = new HashMap<String, String>();
        	jsonObject = jsonArray.getJSONObject(i);
        	if(jsonObject!=null){
        		it = jsonObject.keys();
        		while(it.hasNext()){
        			key = String.valueOf(it.next());
        			if(!StringUtils.isBlank(key)){
        				try{
        					value =	String.valueOf(jsonObject.get(key));
        				}catch(Exception e){
        					value = "";
        				}
        				map.put(key, value);
        			}
        		}
        	}
        	//将转化完成后的放入list
        	if(map!=null){
        		dataList.add(map);
        	}
        }
		
		return dataList;
	}  
	
    /**
     * 
    * @Title: getJsonStr 
    * @Description: TODO(将key和value组装成json的格式) 
    * @param @param key
    * @param @param value
    * @param @return    设定文件 
    * @return String    返回类型 
    * @throws
     */
    public static String getJsonStr(String key ,String value ) {
    	if (StringUtils.isEmpty( value )){
    		value = "0" ;
    	}
    	String result = "\""+key+"\":" + "\""+value+"\"" ;
    	return result ;
    }
    /**
	 * @throws Exception 
	 * 
	* @Title: parseRule 
	* @Description: TODO(解析json) 
	* @param @param rule
	* @param @return    设定文件 
	* @return Map<String,String>    返回类型 
	* @throws
	* @author yuhaijun
	 */
	public static Map<String,String> parseRule(String rule ) throws Exception {
		Map<String,String> ruleMap =new HashMap<String,String>();
		if(StringUtils.isEmpty( rule )) 
			return ruleMap ;
		List<Map<String, Object>> ruleList =   (List<Map<String, Object>>) json2List(rule, Map.class);
		if( ruleList == null || ruleList.size() == 0 )
			return ruleMap ;
		for(Map<String, Object> model : ruleList) {
			 for( Map.Entry<String, Object> temp : model.entrySet()) {
				    if( temp.getValue() instanceof  Map) {
				    	Map<String,String> mapObj = (Map<String,String>)temp.getValue();
				    	StringBuilder jsonStr = new StringBuilder("{");
						for( Map.Entry<String, String> mode : mapObj.entrySet() ) {
							 if( jsonStr.toString().equals( "{" )) {
								 jsonStr.append( "\""+mode.getKey()+"\":\""+mode.getValue()+"\"" );
							 }else{
								 jsonStr.append( ",\""+mode.getKey()+"\":\""+mode.getValue()+"\"" );
							 }
						 }
						jsonStr.append("}");
						ruleMap.put( temp.getKey(), jsonStr.toString());
				    }else{
				    	ruleMap.put( temp.getKey() , temp.getValue().toString()) ;
				    }
			 }
		}
		return ruleMap;
	}
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws Exception {
		
		String json = "{\"memberreceive\":{\"num\":\"1\",\"interval\":\"20\"},\"channelbudget\":{\"sms\":\"122\",\"app\":\"1111\"},\"markettime\":{\"starttime\":\"10:00\",\"endtime\":\"22:00\"},\"repeat\":{\"retimes\":\"1\",\"revalidity\":\"1\",\"reinterval\":\"1\"},\"marketcover\":{\"week\":{\"low\":\"0-1\",\"middle\":\"2-3\",\"high\":\"4\"},\"month\":{\"low\":\"0-3\",\"middle\":\"4-5\",\"high\":\"6\"},\"quarter\":{\"low\":\"0-5\",\"middle\":\"6-10\",\"high\":\"11\"},\"year\":{\"low\":\"0-10\",\"middle\":\"11-20\",\"high\":\"21\"}}}";
		
		Map<String,Object> map = (Map<String, Object>) json2Object(json,Map.class);
		
		for(String str : map.keySet()) {
			Map<String,Object> map1 = (Map<String, Object>) map.get(str);
			
			for(String key : map1.keySet()) {
				System.out.println(key + "="+map1.get(key));
				if("week".equals(key)) {
					Map<String,Object> map2 = (Map<String, Object>) map1.get("week");
					System.out.println(map2.get("low"));
					System.out.println(map2.get("middle"));
					System.out.println(map2.get("high"));
				} else if("month".equals(key)) {
					Map<String,Object> map2 = (Map<String, Object>) map1.get("month");
					System.out.println(map2.get("low"));
					System.out.println(map2.get("middle"));
					System.out.println(map2.get("high"));
				} else if("quarter".equals(key)) {
					Map<String,Object> map2 = (Map<String, Object>) map1.get("quarter");
					System.out.println(map2.get("low"));
					System.out.println(map2.get("middle"));
					System.out.println(map2.get("high"));
				} else if("year".equals(key)) {
					Map<String,Object> map2 = (Map<String, Object>) map1.get("year");
					System.out.println(map2.get("low"));
					System.out.println(map2.get("middle"));
					System.out.println(map2.get("high"));
				}
			}
			
		}
		
	}
}
