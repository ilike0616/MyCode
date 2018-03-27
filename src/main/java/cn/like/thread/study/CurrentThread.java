package cn.like.thread.study;

/**
 * currentThread()方法可返回代码段正在被哪个线程调用的信息。
 */
public class CurrentThread extends Thread {
    public CurrentThread() {
        System.out.println("CurrentThread---begin");
        System.out.println("Thread.currentThread().getName()=" + Thread.currentThread().getName());
        System.out.println("this.getName()=" + this.getName());
        System.out.println("CurrentThread---end");
    }

    @Override
    public void run() {
        System.out.println("run---begin");
        System.out.println("Thread.currentThread().getName()=" + Thread.currentThread().getName());
        System.out.println("this.getName()=" + this.getName());
        System.out.println("run---end");
    }

    public static void main(String[] args) {
        CurrentThread thread = new CurrentThread();
//        thread.start();
        Thread t1 = new Thread(thread);
        t1.setName("A");
        t1.start();
    }
}
