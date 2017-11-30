package xb.posservice.util;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;

import net.sf.json.JSONObject;
/*
 * 切面 打印接口输出日记；
 */
@Component
@Aspect
public class AOPLog {

	private Logger logger = LoggerFactory.getLogger(getClass());

	// @Pointcut("@within(xb.posservice.web.*)")
	// @Pointcut("execution(* cn.us.service.impl.UserServiceImpl.*(..))")
	@Pointcut("execution(* xb.posservice.web..*(..))")
	public void before() {

	}

	@Before("before()")
	public void beforelog() {
		//System.out.print("");
		//System.out.println("####切面日记");
	}

	@Around("before()")
	public Object arroundLog(ProceedingJoinPoint pjp) throws Throwable {
		
		// System.out.println("切面拦截到了" + pjp.getSignature() +"方法...");
//		 Object[] args = pjp.getArgs();
//	        for(Object obj : args){
//	            System.out.println("切面接口参数: "+obj);
//	        }
		Object result = pjp.proceed();
		//Gson gson = new Gson();
		String str="【切面接口】" +pjp.getSignature()+"返回值"+ JSONObject.fromObject(result);
		logger.info(str);
		//System.out.println(str);

		return result;
	}

}
