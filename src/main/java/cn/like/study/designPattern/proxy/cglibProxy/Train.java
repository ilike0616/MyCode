package cn.like.study.designPattern.proxy.cglibProxy;

/**
 * @program: MyCode
 * @description: 被代理类
 * @author: like
 * @create: 2018-04-12 19:48
 **/
public class Train {

    public void move() {
        System.out.println("火车行驶中…");
    }

    public void stop(){
        System.out.println("火车到站停止。");
    }
}
