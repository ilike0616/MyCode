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
    /**
     * 第一把锁volatile
     * 为什么要加这把锁，如果不加会怎样？
     * 若不加锁，instance = new SingletonDCL();可以分解为下面3行伪代码：
     * memory = allocate()      //1：分配对象的内存空间
     * ctorInstance(memory);    //2：初始化对象
     * instance = memory；       //3：设置instance指向刚分配的内存空间
     * 伪代码2和3可能会发生重排序(在一些JIT编译器上)，线程A先执行3，再执行2，
     * 若线程B再线程A的3和2之间判断instance是否为空的结果是不为null，线程B访问instance引用的对象还未初始化
     * 当声明对象的引用为volatile后，上述2和3之间的重排序，再多线程环境中将会禁止，
     * 如此才能保证线程安全的延迟初始化
     */
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
