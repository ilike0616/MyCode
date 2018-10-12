package cn.like.study.thread.join;

/**
 * @program: MyCode
 * @description:
 * @author: like
 * @create: 2018-05-27 19:33
 **/
public class ThreadC extends Thread {
    private ThreadB threadB;

    public ThreadC(ThreadB threadB) {
        super();
        this.threadB = threadB;
    }

    public void run() {
        threadB.bService();
    }
}
