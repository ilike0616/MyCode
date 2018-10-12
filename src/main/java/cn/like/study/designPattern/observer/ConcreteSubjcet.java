package cn.like.study.designPattern.observer;

import java.util.Observable;

/**
 * @program: MyCode
 * @description: 具体被观察者
 * @author: like
 * @create: 2018-10-12 14:47
 **/
public class ConcreteSubjcet extends Observable implements Subject {
    @Override
    public void doSomething() {
        /*
        do something
         */
        //通知所有的观察者
        super.setChanged();
        super.notifyObservers("do something");
    }
}
