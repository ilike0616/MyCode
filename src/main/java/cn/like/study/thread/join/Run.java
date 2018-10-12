package cn.like.study.thread.join;

/**
 * @program: MyCode
 * @description:
 * @author: like
 * @create: 2018-05-27 19:35
 **/
public class Run {
    public static void main(String[] args) {
        try {
            ThreadB b = new ThreadB();
            ThreadD d = new ThreadD();
            ThreadA a = new ThreadA(b, d);
            a.start();
            Thread.sleep(1000);
            ThreadC c = new ThreadC(b);
            c.start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
