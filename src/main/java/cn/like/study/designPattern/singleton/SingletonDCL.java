package cn.like.study.designPattern.singleton;

/**
 * @program: MyCode
 * @description: 单例模式（双检锁/双重校验锁）
 * 这种双锁机制，在多线程情况下安全且保持高性能
 * getInstance()的性能对应用程序很关键
 * @author: like
 * @create: 2018-04-20 22:28
 **/
public class SingletonDCL {
    //第一把锁volatile
    private static volatile SingletonDCL instance;

    private SingletonDCL() {
    }

    public static SingletonDCL getInstance() {
        if (instance == null) {
            //第二把锁
            synchronized (SingletonDCL.class) {
                if (instance == null) {
                    instance = new SingletonDCL();
                }
            }
        }
        return instance;
    }
}
