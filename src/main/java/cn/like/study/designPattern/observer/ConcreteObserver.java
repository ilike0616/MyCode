package cn.like.study.designPattern.observer;

import java.util.Observable;
import java.util.Observer;

/**
 * @program: MyCode
 * @description: 具体观察者
 * @author: like
 * @create: 2018-10-12 14:42
 **/
public class ConcreteObserver implements Observer {

    @Override
    public void update(Observable o, Object arg) {
        System.out.println("接收到消息，并进行处理！");
        System.out.println(o.getClass().getName()+" "+arg.toString());
    }
}
