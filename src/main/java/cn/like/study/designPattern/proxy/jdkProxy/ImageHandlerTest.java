package cn.like.study.designPattern.proxy.jdkProxy;

import cn.like.study.designPattern.proxy.Image;
import cn.like.study.designPattern.proxy.RealImage;

import java.lang.reflect.Proxy;

/**
 * @program: MyCode
 * @description: JDK动态代理测试
 * @author: like
 * @create: 2018-04-12 18:50
 **/
public class ImageHandlerTest {
    public static void main(String[] args) throws Exception {
        RealImage image = new RealImage("test.png");

        ImageHandler handler = new ImageHandler(image);

        Class<?> aClass = image.getClass();
        /**
         * 动态创建代理实例
         * lassLoader loader:类加载器
         * Class<?>[] interfaces：被代理类实现的接口
         * InvocationHandler h：事务处理器
         */
        Image i = (Image)Proxy.newProxyInstance(aClass.getClassLoader(),aClass.getInterfaces(),handler);

        i.display();

        System.getProperties().put("sun.misc.ProxyGenerator.saveGenerateFiles","true");
    }
}
