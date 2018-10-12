package cn.like.study.juc;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @program: MyCode
 * @description: Atomic变量自增运算测试
 * @author: like
 * @create: 2018-04-29 15:28
 **/
public class AtomicIntegerTest {
    public static AtomicInteger race = new AtomicInteger(0);

    public static void increase(){
        race.incrementAndGet();
    }

    /**
     * 一下代码与{@link cn.like.study.thread.VolatileIncrease}中代码一致
     */
    private static final int THREADS_COUNT = 20;

    public static void main(String[] args){
        Thread[] threads = new Thread[THREADS_COUNT];
        for (int i=0;i<THREADS_COUNT;i++){
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    for(int i=0;i<10000;i++){
                        increase();
                    }
                }
            });
            threads[i].start();
        }
        //等待所有累加线程都结束
        while (Thread.activeCount() > 1){
            Thread.yield();
        }

        System.out.println(race);
    }
}
