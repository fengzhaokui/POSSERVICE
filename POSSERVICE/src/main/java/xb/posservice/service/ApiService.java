package xb.posservice.service;

import java.util.Map;

public interface ApiService {
	
	String sendRequest(String method, Map<String,String> parameters);
}
