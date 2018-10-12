package cn.like.study.juc;

import java.util.concurrent.CountDownLatch;

/**
 * @program: MyCode
 * @description: 并发工具类：等待多线程完成的CountDownLatch
 * 计数器只能实用一次
 * @author: like
 * @create: 2018-05-06 10:44
 **/
public class CountDownLatchDemo {
    //构造函数接收一个int类型的参数作为计数器，等待节点的个数N
    static CountDownLatch countDownLatch = new CountDownLatch(2);

    public static void main(String[] args) throws InterruptedException {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(1);
                countDownLatch.countDown();         //N减去1
                System.out.println(2);
                countDownLatch.countDown();         //N减去1
            }
        }).start();

        countDownLatch.await();                 //阻塞当前线程，知道N编程零

        System.out.println(3);
    }
}
