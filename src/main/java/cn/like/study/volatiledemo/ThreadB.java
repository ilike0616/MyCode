package cn.like.study.volatiledemo;

/**
 * @program: MyCode
 * @description:
 * @author: like
 * @create: 2018-05-22 23:21
 **/
public class ThreadB extends Thread {
    private Service service;

    public ThreadB(Service service) {
        super();
        this.service = service;
    }

    @Override
    public void run() {
        service.stopMehtod();
    }
}
