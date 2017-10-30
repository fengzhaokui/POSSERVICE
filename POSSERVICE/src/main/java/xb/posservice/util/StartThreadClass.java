package xb.posservice.util;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

import xb.posservice.dao.vo.ResultData;
import xb.posservice.test.Consumer;
import xb.posservice.test.Producer;
import xb.posservice.test.test;

///程序启动时候自动调用，启动线程；
@Service
public class StartThreadClass implements InitializingBean {

	public void afterPropertiesSet() throws Exception {
		
		System.out.println("线程启动----------------------------");
		test tt=new test();
		tt.add();
		//startNotify();
	}

	public ExecutorService fixedThreadPool = Executors.newFixedThreadPool(5);

	public void startNotify() {
		fixedThreadPool.execute(new Runnable() {
			public void run() {
//				while (1 == 1) {
//					try {
//						Thread.sleep(6000);
//						System.out.print("当前时间：" + CommonUtils.getNowDate());
//					} catch (InterruptedException e) {
//						e.printStackTrace();
//					}
//				}
				
				List<ResultData> queue = new ArrayList<ResultData>();
		        int length = 10;
		        Producer p1 = new Producer(queue,length);
		        Producer p2 = new Producer(queue,length);
		        Producer p3 = new Producer(queue,length);
		        Consumer c1 = new Consumer(queue);
		        Consumer c2 = new Consumer(queue);
		        Consumer c3 = new Consumer(queue);
		        ExecutorService service = Executors.newCachedThreadPool();
		        service.execute(p1);
		        service.execute(p2);
		        service.execute(p3);
		        service.execute(c1);
		        service.execute(c2);
		        service.execute(c3);
				
			}
		});
	}
}
