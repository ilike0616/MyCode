package cn.like.study.java8;

/**
 * @program: MyCode
 * @description: Java8新特性：函数是接口
 * 函数式接口就是只有一个方法的普通接口，可以被隐式转换为lambda表达式。
 * 增加方法，接口就不再是函数式的了，编译过程也会失败，使用注解@FunctionalInterface约束避免增加其他方法。
 * 但默认方法和静态方法并不影响函数式接口的契约，可以任意使用。
 * {@java.lang.Runnable}与{@java.util.concurrent.Callable}是函数式接口最典型的两个例子。
 * @author: like
 * @create: 2018-05-04 21:19
 **/
@FunctionalInterface
public interface FunctionalInterfaceDemo {

    void method();

    default void defaultMethod(){
        System.out.println("This is a default method");
    }

    static void staticMethod(){
        System.out.println("This is a static method");
    }
}
