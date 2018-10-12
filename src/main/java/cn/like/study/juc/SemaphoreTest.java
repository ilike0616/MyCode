package cn.like.study.juc;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @program: MyCode
 * @description: 并发工具类：控制并发线程数的Semaphore
 * Semaphore是用来控制同时访问特定资源的线程数量，它通过协调各个线程，以保证合理的使用公共资源。
 * acquire()：获取许可证
 * tryAcquire()：尝试获取许可证
 * release()：归还许可证
 * int availablePermits()：返回信号量中当前可用的许可证数
 * int getQueueLength()：返回正在等待获取许可证的线程数
 * boolean hasQueuedThreads()：是否有现成正在等待获取许可证
 * void reducePermits(int reduction)：减少reduction个许可证，是个protected方法
 * Collection getQueuedThreads()：返回所有等待获取许可证的线程集合，是个protected方法
 * @author: like
 * @create: 2018-05-06 11:57
 **/
public class SemaphoreTest {
    private static final int THREAD_COUNT = 30;

    private static ExecutorService threadPool = Executors.newFixedThreadPool(THREAD_COUNT);

    private static Semaphore semaphore = new Semaphore(10);

    public static void main(String[] args) {
        for (int i = 0; i < THREAD_COUNT; i++) {
            threadPool.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        semaphore.acquire();                //获取一个许可证
                        System.out.println("save data");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        threadPool.shutdown();
    }
}
