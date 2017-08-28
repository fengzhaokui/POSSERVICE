package xb.posservice.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import net.sf.json.JSONObject;
import xb.posservice.dao.vo.ResultData;
import xb.posservice.dao.vo.TOKEN;
import xb.posservice.service.TokenService;

/*
 所有接口检验token；记录接口调用输入日记；记录接口响应时间；
 */
public class CheckToken extends HandlerInterceptorAdapter {
	@Autowired
	@Qualifier("TokenServiceImpl")
	private TokenService tokenService;

	Logger logger = Logger.getLogger(CheckToken.class);
    //打印输入日记 获取token；
	private String getUserToken(HttpServletRequest request) {
		StringBuffer url = request.getRequestURL();
		if (request.getQueryString() != null) {
			url.append("?");
			url.append(request.getQueryString());
		}
		// logger.info(url);
		//String str = getBodyData(request);
		// System.out.print(str);
		//logger.info(url + ";boby:" + str);
		//System.out.print(url + ";boby:" + str);
		return request.getParameter("token");

	}

	private String getBodyData(HttpServletRequest request) {
		StringBuffer data = new StringBuffer();
		String line = null;
		BufferedReader reader = null;
		try {
			reader = request.getReader();
			while (null != (line = reader.readLine()))
				data.append(line);
		} catch (IOException e) {
		} finally {
		}
		return data.toString();
	}

	private void SetErrorRespon(HttpServletResponse response, ResultData result) {
		response.setContentType("application/json");
		JSONObject responseJSONObject = JSONObject.fromObject(result);
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json; charset=utf-8");
		PrintWriter out = null;
		try {
			out = response.getWriter();
			out.append(responseJSONObject.toString());
			logger.info("返回是\n");
			logger.info(responseJSONObject.toString());
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (out != null) {
				out.close();
			}
		}
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		long startTime = System.currentTimeMillis();
		request.setAttribute("startTime", startTime);
		// StringBuffer url = request.getRequestURL();
		// if (request.getQueryString() != null) {
		// url.append("?");
		// url.append(request.getQueryString());
		// }
		// logger.info(url);
		ResultData result = new ResultData();
		result.setRetcode("00");
		// 检查用户所传递的 token 是否合法
		String token = getUserToken(request);
		if (token == null) {
			result.setRetmsg("错误, Token不可以为空!");
			SetErrorRespon(response, result);
			// response.setStatus(500);
			return false;
		} else {
			TOKEN data = tokenService.selectByPrimaryKey(token);
			if (data == null) {
				result.setRetmsg("错误, Token不存在!");
				// response.setStatus(500);
				SetErrorRespon(response, result);
				return false;
			}
		}

		return true;
	}

	//
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		StringBuffer url = request.getRequestURL();
		long startTime = (Long) request.getAttribute("startTime");
		long endTime = System.currentTimeMillis();
		long executeTime = endTime - startTime;
		if (handler instanceof HandlerMethod) {
			StringBuilder sb = new StringBuilder(1000);
			sb.append(url + "接口耗时  : ").append(executeTime).append("ms").append("\n");
			sb.append("-------------------------------------------------------------------------------");
			//System.out.println(sb.toString());
			logger.info(sb.toString());
		}

	}

	//
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		if(ex!=null)
		{
			logger.error(ex);
		}
		//ServletOutputStream aa = response.getOutputStream();
		
	}
	
}
