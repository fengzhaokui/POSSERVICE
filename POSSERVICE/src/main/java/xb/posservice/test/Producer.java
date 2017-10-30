package xb.posservice.test;
import java.util.List;
import java.util.Random;

import xb.posservice.dao.vo.ResultData;

/**
 * 生产者
 * 
 * @author MacBook
 *
 */
public class Producer implements Runnable {
    private List<ResultData> queue;
    private int length;

    public Producer(List<ResultData> queue, int length) {
        this.queue = queue;
        this.length = length;
    }

    public void run() {
        try {
            while (true) {

                if (Thread.currentThread().isInterrupted())
                    break;
                Random r = new Random();
                long temp = r.nextInt(100);
                System.out.println(Thread.currentThread().getId() + " 生产了：" + temp);
                ResultData data = new ResultData();
                data.setData(temp);
                synchronized (queue) {
                    if (queue.size() >= length) {
                        queue.notifyAll();
                        queue.wait();
                        System.out.println("生产等待中。。");
                    } else
                    {
                        queue.add(data);
                       // queue.notifyAll();
                    }
                }
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}