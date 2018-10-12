package cn.like.study.thread;

/**
 * @program: MyCode
 * @description: volatile变量自增运算测试
 * Java里面的运算并非原则操作，导致volatile变量的运算在并发下一样是不安全的
 * ---------------- 方法increase()的字节码举例 ----------------------
 * public static void increase();
 *  Code:
 *      0: getstatic     #2                  // Field race:I
 *      3: iconst_1
 *      4: iadd
 *      5: putstatic     #2                  // Field race:I
 *      8: return
 * ----------------------------------------------------------------
 * volatile关键字保证线程执行指令putstatic后其他线程执行指令getstatic时必
 * 须从主内存中刷新工作内存中变量的值，如果线程在另外一个线程putstatic之前就
 * getstatic，那么两个线程对相同的数值做自增运算，结果相当于一次自增，线程不
 * 安全。
 * @author: like
 * @create: 2018-04-29 11:17
 **/
public class VolatileIncrease {
    public static volatile int race = 0;

    public static void increase(){
        race++;
    }

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
