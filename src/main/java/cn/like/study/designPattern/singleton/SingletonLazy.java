package cn.like.study.designPattern.singleton;

/**
 * @program: MyCode
 * @description: 单例模式（懒汉模式）
 * @author: like
 * @create: 2018-04-20 21:45
 **/
public class SingletonLazy {

    private static SingletonLazy instance;

    private SingletonLazy() {
    }
    //这是线程不安全的，多线程时不能正常工作。
    //比如线程A调用方法判断instance为null，此时CPU切换线程B调用方法判断instance也为null，创建实例，然后切线线程A也创建了实例
    public static SingletonLazy getIntance() {
        if (instance == null) {
            instance = new SingletonLazy();
        }
        return instance;
    }

    //线程安全，但效率低下，99%（泛指）的情况下并不需要同步（另外那1%会出现线程不安全）
    //优点：第一次调用时才初始化，避免资源浪费
    //缺点：必须加锁synchronized才能保证单例，浪费资源
    public static synchronized SingletonLazy getIntance1() {
        if (instance == null) {
            instance = new SingletonLazy();
        }
        return instance;
    }

}
