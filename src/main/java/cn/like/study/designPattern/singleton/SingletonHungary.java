package cn.like.study.designPattern.singleton;


/**
 * @program: MyCode
 * @description: 单例模式（饿汉模式）
 * 这种方法比较常用，但会产生垃圾对象
 * 优点：不加锁，执行效率会提高
 * 确定：类加载时初始化，浪费资源
 * 没有synchronized为什么是线程安全的：基于classloder机制避免了多线程的同步问题，类加载时就创建了实例对象
 * @author: like
 * @create: 2018-04-20 20:40
 **/
public class SingletonHungary {
    private static SingletonHungary instance = new SingletonHungary();

    /**
     * 关键代码：构造函数private保证该类不会被实例化
     */
    private SingletonHungary() {
    }

    //饿汉模式不加synchronized关键字也是线程安全的
    public static SingletonHungary getInstance() {
        return instance;
    }

    public void showMessage() {
        System.out.println("Hello World!");
    }

    public static void main(String[] args) {
        //不合法的构造函数
        //编译时错误：构造函数SingleObject()是不可见的
        //SingleObject object = new SingleObject();

        SingletonHungary object = SingletonHungary.getInstance();
        object.showMessage();
    }
}
