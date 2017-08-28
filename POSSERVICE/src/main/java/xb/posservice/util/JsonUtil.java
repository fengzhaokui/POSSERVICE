package xb.posservice.util;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;

public class JsonUtil {
	private static Log log = LogFactory.getLog(JsonUtil.class);
	
	private  ObjectMapper mapper;
	/**
	 * 
	 */
	public JsonUtil(){
		mapper = new ObjectMapper();
		mapper.getSerializerProvider().setNullValueSerializer(new JsonSerializer<Object>(){
			@Override
			public void serialize(Object arg0, JsonGenerator arg1,
					SerializerProvider arg2) throws IOException,
					JsonProcessingException {
				// TODO Auto-generated method stub
				arg1.writeString("");
			}
		});
	}
	/**
	 * example:
	 * JsonUtil json = new JsonUtil(Include.NON_EMPTY);
	 * 
	 * @param include
	 */
	public JsonUtil(Include include){
		mapper = new ObjectMapper();
		mapper.setSerializationInclusion(include);
	}
	
	/**
	 * 格式化日期
	 * @param dateFormats
	 */
	public JsonUtil(String dateFormats){
		mapper = new ObjectMapper();
		SimpleDateFormat fmt = new SimpleDateFormat(dateFormats);  
		mapper.setDateFormat(fmt);  
	}
	
	/**
	 * 把对象转化成json
	 * @param map
	 * @return
	 */
	public  String toJson(Object obj) {
		String json = "";
		try {
			json = mapper.writeValueAsString(obj);
		} catch (JsonProcessingException e) {
			log.error(e);
		}
		return json;
	}
	/**
	 * 转化成单个对象
	 * @param json
	 * @param clazz
	 * @return
	 */
	public  <T> T fromToJson(String json, Class<T> clazz){
		try {
			return mapper.readValue(json, clazz);
		} catch (JsonParseException e) {
			log.error(e);
		} catch (JsonMappingException e) {
			log.error(e);
		} catch (IOException e) {
			log.error(e);
		}
		return null;
	}
	/**
	 * 把json转化成集合类型
	 * JavaType javaType = mapper.getTypeFactory().constructParametricType(List.class, PaiPicTagEntity.class);
	 * @param json
	 * @param collectionClass
	 * @param elementClasses
	 * @return
	 */
	public  <T> T fromToJsonMulti(String json, Class<?> collectionClass, Class<?>... elementClasses){
		JavaType javaType = mapper.getTypeFactory().constructParametricType(collectionClass, elementClasses);
		try {
			return mapper.readValue(json, javaType);
		} catch (JsonParseException e) {
			log.error(e);
		} catch (JsonMappingException e) {
			log.error(e);
		} catch (IOException e) {
			log.error(e);
		}
		return null;
	}
	
	public String manualToJson(int code, String msg, Collection<String> jsonStr) {
		StringBuilder sb = new StringBuilder("[");
		for(String s : jsonStr) {
			sb.append(s);
			sb.append(",");
		}
		String aa = sb.toString().substring(0, sb.length()-1);
		aa = aa+"]";
		
		if(jsonStr == null || jsonStr.size() == 0) {
			aa = "[]";
		}
		sb = new StringBuilder("{");
		sb.append("\"state_code\"");
		sb.append(":");
		sb.append(code);
		sb.append(",");
		
		sb.append("\"error_msg\"");
		sb.append(":");
		sb.append("\"");
		sb.append(msg);
		sb.append("\"");
		sb.append(",");
		
		sb.append("\"data\"");
		sb.append(":");
		sb.append(aa);
		sb.append("}");
		
		return sb.toString();
	}
	
	public String manualToJson(int code, String msg, String jsonStr) {
		
		StringBuilder sb = new StringBuilder("{");
		sb.append("\"state_code\"");
		sb.append(":");
		sb.append(code);
		sb.append(",");
		
		sb.append("\"error_msg\"");
		sb.append(":");
		sb.append("\"");
		sb.append(msg);
		sb.append("\"");
		sb.append(",");
		
		sb.append("\"data\"");
		sb.append(":");
		sb.append(jsonStr);
		sb.append("}");
		
		return sb.toString();
	}
	
}
