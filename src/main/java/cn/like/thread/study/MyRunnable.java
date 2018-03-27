package cn.like.thread.study;

public class MyRunnable implements Runnable {

    public void run() {
        System.out.println("运行中！");
    }

    public static void main(String[] args) {
        Runnable runnable = new MyRunnable();
        /*
         java是单根继承，已经有父类的通过实现Runnable接口。
         Thread.java也实现了Runnable接口，所以Thread(Runnable target)还可以传入一个Thread类的对象，
         可以将一个Thread对象中的run方法交给其他线程调用
         */
        Thread thread = new Thread(runnable);
        thread.start();
        System.out.println("运行结束！");
    }
}
