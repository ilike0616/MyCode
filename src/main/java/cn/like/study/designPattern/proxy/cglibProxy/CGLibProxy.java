package cn.like.study.designPattern.proxy.cglibProxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @program: MyCode
 * @description: CGLib动态代理
 * @author: like
 * @create: 2018-04-12 19:49
 **/
public class CGLibProxy implements MethodInterceptor {

    private Enhancer enhancer = new Enhancer();

    /**
     * 动态获取代理实例
     * @param clazz 被代理类
     * @return
     */
    public Object getProxy(Class<?> clazz) {
        enhancer.setSuperclass(clazz);
        enhancer.setCallback(this);
        return enhancer.create();
    }

    /**
     *
     * @param o 被代理类
     * @param method    被代理的方法
     * @param args   方法的参数
     * @param methodProxy   代理类的实例
     * @return
     * @throws Throwable
     */
    public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        System.out.println("CGLib动态代理--begin");
//        System.out.println("targetClass:"+o.getClass());
//        System.out.println("targetMethod:"+method.getName());
//        System.out.println("methodProxy:"+methodProxy.getSuperName());
        methodProxy.invokeSuper(o, args);
        System.out.println("CGLib动态代理--end");
        return null;
    }

    public static void main(String[] args) {
        CGLibProxy proxy = new CGLibProxy();
        //代理实例
        Train train = (Train) proxy.getProxy(Train.class);
        train.move();
        train.stop();
    }
}
