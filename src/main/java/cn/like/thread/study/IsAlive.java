package cn.like.thread.study;

/**
 * 判断当前线程师傅处于活动状态,既线程已启动且未终止
 */
public class IsAlive extends Thread{
    @Override
    public void run() {
        System.out.println("run="+this.isAlive());
    }

    public static void main(String[] args) {
        IsAlive myThread = new IsAlive();
        System.out.println("begin=="+myThread.isAlive());
        myThread.start();
        System.out.println("end=="+myThread.isAlive());
    }
}
