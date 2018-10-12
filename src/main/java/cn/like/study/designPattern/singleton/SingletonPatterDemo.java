package cn.like.study.designPattern.singleton;

/**
 * @program: MyCode
 * @description: 单例设计模式示例
 * 常见应用场景：
 * 1.数据库连接池的设计
 * 2.多线程的线程池
 * 3.任务管理器
 * 4.Spring中的Bean默认是单例的
 * 5.java.lang.Runtime
 * 6.java.lang.reflect.Proxy
 * @author: like
 * @create: 2018-04-20 20:51
 **/
public class SingletonPatterDemo {
    public static void main(String[] args) {
        //不合法的构造函数
        //编译时错误：构造函数SingleObject()是不可见的
        //SingleObject object = new SingleObject();

        SingletonHungary object = SingletonHungary.getInstance();
        object.showMessage();

        SingletonEnum.INSTANCE.whateverMethod();

    }
}
