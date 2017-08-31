package xb.posservice.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Field;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.google.gson.Gson;

import net.sf.json.JSONObject;
import xb.posservice.dao.vo.ResultData;
import xb.posservice.dao.vo.TOKEN;
import xb.posservice.service.TokenService;
import org.apache.catalina.connector.CoyoteOutputStream;
import org.apache.catalina.connector.OutputBuffer;
import org.apache.tomcat.util.buf.ByteChunk;

/*
 所有接口检验token；记录接口调用输入日记；记录接口响应时间；
 */
public class CheckToken extends HandlerInterceptorAdapter {
	@Autowired
	@Qualifier("TokenServiceImpl")
	private TokenService tokenService;

	Logger logger = Logger.getLogger(CheckToken.class);

	// 打印输入日记 获取token；
	private String getUserToken(HttpServletRequest request) {
		StringBuffer url = request.getRequestURL();
		if (request.getQueryString() != null) {
			url.append("?");
			url.append(request.getQueryString());
		}
		Gson gson = new Gson();
		logger.info(request.getRequestURL() + "接口参数：" + gson.toJson(request.getParameterMap()));

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
			logger.info("接口报错，返回:" + responseJSONObject.toString());
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
		// return super.preHandle(request, response, handler);

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
			logger.info(sb.toString());
//			Gson gson = new Gson();
//			// 截取响应流
//			CoyoteOutputStream os =(CoyoteOutputStream)response.getOutputStream();
//			// 取到流对象对应的Class对象
//			Class<CoyoteOutputStream> c = CoyoteOutputStream.class;
//			// 取出流对象中的OutputBuffer对象，该对象记录响应到客户端的内容
//			Field fs = c.getDeclaredField("ob");
//			if (fs.getType().toString().endsWith("OutputBuffer")) {
//				fs.setAccessible(true);// 设置访问ob属性的权限
//				OutputBuffer ob = (OutputBuffer) fs.get(os);// 取出ob
//				logger.info("ob"+ob);
//				Class<OutputBuffer> cc = OutputBuffer.class;
//				Field ff = cc.getDeclaredField("outputChunk");// 取到OutputBuffer中的输出流
//				ff.setAccessible(true);
//				if (ff.getType().toString().endsWith("ByteChunk")) {
//					ByteChunk bc = (ByteChunk) ff.get(ob);// 取到byte流
//					String val = new String(bc.getBytes(), "UTF-8");// 最终的值
//					// System.out.println(val);
//					logger.info(url+"输出：" + val);
//				}
//				//ob.close();
//			}
		}
		super.postHandle(request, response, handler, modelAndView);
	}

	//
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		if (ex != null) {
			logger.error(ex);
			ResultData result = new ResultData();
			result.setRetcode("01");
			result.setRetmsg("参数错误!");
			SetErrorRespon(response, result);
		}
		super.afterCompletion(request, response, handler, ex);
	}

}
