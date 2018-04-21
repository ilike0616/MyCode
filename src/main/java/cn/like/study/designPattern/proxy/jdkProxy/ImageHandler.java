package cn.like.study.designPattern.proxy.jdkProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 动态代理的事务处理器
 */
public class ImageHandler implements InvocationHandler {

    private Object target;

    public ImageHandler(Object target){
        this.target = target;
    }

    /**
     *
     * @param proxy 被代理的对象
     * @param method    被代理的方法
     * @param args  方法的参数
     * @return
     * @throws Throwable
     */
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("JDK动态代理------before");
//        System.out.println(proxy.getClass());
//        System.out.println(method.getName());
        method.invoke(target,args);
        System.out.println("JDK动态代理------end");
        return null;
    }
}
