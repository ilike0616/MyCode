package cn.like.study.thread.join;

/**
 * @program: MyCode
 * @description:
 * @author: like
 * @create: 2018-05-27 19:27
 **/
public class ThreadA extends Thread {
    private ThreadB b;
    private ThreadD d;

    public ThreadA(ThreadB b, ThreadD d) {
        super();
        this.b = b;
        this.d = d;
    }

    @Override
    public void run() {
        try {
            synchronized (b) {
                b.start();
                d.join();
                Thread.sleep(6000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
