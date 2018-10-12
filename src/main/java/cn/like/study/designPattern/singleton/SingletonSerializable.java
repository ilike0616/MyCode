package cn.like.study.designPattern.singleton;

import java.io.Serializable;

/**
 * @program: MyCode
 * @description:
 * @author: like
 * @create: 2018-06-06 19:48
 **/
public class SingletonSerializable implements Serializable {
    private static final long serialVersionUID = 888L;

    private SingletonSerializable() {
    }

    private static class MyObjectHandler {
        private static final SingletonSerializable myobject = new SingletonSerializable();
    }

    public static SingletonSerializable getInstance() {
        return MyObjectHandler.myobject;
    }

    /**
     * ObjectInputStream.java的方法readOrdinaryObject中反射调用方法（invokeReadResolve）
     * 以此保证经过序列化和反序列化后仍是单例的
     * @return
     */
    protected Object readResolve() {
        System.out.println("调用了readResole方法");
        return MyObjectHandler.myobject;
    }
}
