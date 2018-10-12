package cn.like.study.designPattern.observer;

import java.util.Observer;

/**
 * @program: MyCode
 * @description:场景类
 * 观察者模式的使用场景：
 * 1.关联行为场景。
 * 2.时间多级触发场景。
 * 3.跨系统的消息交换场景，如消息队列的处理机制。
 * @author: like
 * @create: 2018-10-12 14:51
 **/
public class Client {
    public static void main(String[] agrs){
        //创建一个被观察者
        ConcreteSubjcet subjcet = new ConcreteSubjcet();
        //定义一个观察者
        Observer obs = new ConcreteObserver();
        //观察者观察被观察者
        subjcet.addObserver(obs);
        //观察者开始活动了
        subjcet.doSomething();
    }
}
