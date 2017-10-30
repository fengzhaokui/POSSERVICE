package xb.posservice.test;

import java.util.List;

import xb.posservice.dao.vo.ResultData;

/**
 * 消费者
 * 
 * @author ctk
 *
 */

public class Consumer implements Runnable {
    private List<ResultData> queue;

    public Consumer(List<ResultData> queue) {
        this.queue = queue;
    }

    public void run() {
        try {
            while (true) {
                if (Thread.currentThread().isInterrupted())
                    break;
                ResultData data = null;
                synchronized (queue) {
                    if (queue.size() == 0) {
                        queue.wait();
                        queue.notifyAll();
                        System.out.println("消费者等待。。");
                    }
                    data = queue.remove(0);
                   
                }
                System.out.println(
                        Thread.currentThread().getId() + " 消费了:" + data.getData());
                Thread.sleep(1000);
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
