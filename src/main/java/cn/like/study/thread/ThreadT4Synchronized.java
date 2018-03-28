package cn.like.study.thread;

/**
 * 多个线程访问同一个变量，存在非线程安全的问题，比如投票票数、销售商品数量
 * 通过在run方法前加入synchronized关键字，使多个线程在执行run方法时，以排队的方式进行处理
 */
public class ThreadT4Synchronized extends Thread {

    private int count = 8;

    @Override
    public synchronized void run() {
        //super.run();
//        count--;
//        System.out.println("由" + this.currentThread().getName() + " 计算，count=" + count);
        System.out.println("i=" + (count--) + " threadName=" + Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        ThreadT4Synchronized thread = new ThreadT4Synchronized();
        Thread a = new Thread(thread, "A");
        Thread b = new Thread(thread, "B");
        Thread c = new Thread(thread, "C");
        Thread d = new Thread(thread, "D");
        Thread e = new Thread(thread, "E");
        Thread f = new Thread(thread, "F");
        Thread g = new Thread(thread, "G");
        Thread h = new Thread(thread, "H");
        a.start();
        b.start();
        c.start();
        d.start();
        e.start();
        f.start();
        g.start();
        h.start();
    }
}
