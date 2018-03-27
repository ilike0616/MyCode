package cn.like.thread.study;

public class MyThread extends Thread {
    @Override
    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                int time = (int) (Math.random() * 1000);
                Thread.sleep(time);
                System.out.println("run=" + Thread.currentThread().getName());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            MyThread thread = new MyThread();
            thread.setName("myThread");
            /*
            Thread.java勒种的start()方法通知“线程规划器”此线程已经准备就绪，等待调用run()。
            这个过程是让系统安排一个时间来调用Thread的run()方法,具有异步执行的效果。
             */
            thread.start();
            /*
            直接调用run()不是异步执行，而是同步，那么此线程对象并不交给“线程规划器”来处理，
            而是由main主线程来调用run()方法，必须等run()方法中的代码执行完后才可以执行后面的代码
             */
            //thread.run();
            for (int i = 0; i < 10; i++) {
                int time = (int) (Math.random() * 1000);
                //Thread的sleep(time)方法是static的;
                Thread.sleep(time);
                System.out.println("main=" + Thread.currentThread().getName());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}