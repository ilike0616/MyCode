package cn.like.study.thread;

/**
 * @program: MyCode
 * @description: 重排序对多线程的影响
 * 假设两个线程t1和t2，t1首先执行writer()方法，随后t2接着执行reader()方法
 * @author: 《Java并发编程的艺术》
 * @create: 2018-04-29 22:27
 **/
public class ReorderExample {
    int a = 0;
    volatile boolean flag = false;

    /**
     * 编译器和处理器可以对1和2两个操作重排序
     */
    public void writer() {
        a = 1;          //1
        flag = true;    //2
    }

    public void reader() {
        //flag可能是true，也可能是false
        if (flag) {
            //int i = a * a;
            System.out.println(a * a);
        }else{
            System.out.println("============================="+a);//此处a可能是0，也可能是1
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 1000; i++) {
            ReorderExample re = new ReorderExample();
            Thread t1 = new Thread(new Runnable() {
                @Override
                public void run() {
                    re.writer();
                }
            });
            Thread t2 = new Thread(new Runnable() {
                @Override
                public void run() {
                    re.reader();
                }
            });
            t1.start();
            t2.start();
        }
        while (Thread.activeCount() > 1) {
            Thread.yield();
        }
    }
}
