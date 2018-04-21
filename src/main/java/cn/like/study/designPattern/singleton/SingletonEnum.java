package cn.like.study.designPattern.singleton;

/**
 * @program: MyCode
 * @description: 枚举实现的单例模式
 * 这种实现方式还没有被广泛采用，但这是实现单例模式的最佳方法。它更简洁，自动支持序列化机制，绝对防止多次实例化。
 * 这种方式是 Effective Java 作者 Josh Bloch 提倡的方式，它不仅能避免多线程同步问题，而且还自动支持序列化机制，
 * 防止反序列化重新创建新的对象，绝对防止多次实例化。不过，由于 JDK1.5 之后才加入 enum 特性，用这种方式写不免让人
 * 感觉生疏，在实际工作中，也很少用。
 * 不能通过 reflection attack 来调用私有构造方法。
 * @author: like
 * @create: 2018-04-20 23:02
 **/
public enum SingletonEnum {
    INSTANCE;

    public void whateverMethod() {
        System.out.println("枚举实现单例模式");
    }

    public static void main(String[] args){
        SingletonEnum.INSTANCE.whateverMethod();
    }
}
