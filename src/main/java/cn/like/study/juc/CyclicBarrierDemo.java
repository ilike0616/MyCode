package cn.like.study.juc;

import java.util.concurrent.CyclicBarrier;

/**
 * @program: MyCode
 * @description: 并发工具类：同步屏障CyclicBarrier
 * 让一组线程到达一个屏障（同步点）时被阻塞，直到最后一个线程到达屏障时，
 * 屏障才会开门，所有被屏障拦截的线程才会继续执行。
 * 计数器可以实用reset()方法重置
 * getNumberWaiting()方法获得阻塞的线程数；
 * isBroken()方法用来了解阻塞的线程是否被中断。
 * @author: like
 * @create: 2018-05-06 10:56
 **/
public class CyclicBarrierDemo {
    //构造方法的参数表示屏障拦截的线程数
    //static CyclicBarrier c = new CyclicBarrier(2);
    static CyclicBarrier c = new CyclicBarrier(2, new A());

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    c.await();          //告诉CyclicBarrier当前线程已经到了屏障
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println(1);
            }
        }).start();
        try {
            c.await();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(2);
    }

    static class A implements Runnable {

        @Override
        public void run() {
            System.out.println(3);
        }
    }
}
