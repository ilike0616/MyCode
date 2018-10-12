package cn.like.study.volatiledemo;

/**
 * @program: MyCode
 * @description:
 * @author: like
 * @create: 2018-05-22 23:19
 **/
public class ThreadA extends Thread {
    private Service service;

    public ThreadA(Service service) {
        super();
        this.service = service;
    }

    @Override
    public void run() {
        service.runMethod();
    }
}
