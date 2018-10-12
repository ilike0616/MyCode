package cn.like.study.java8.util;

import java.util.Optional;

/**
 * @program: MyCode
 * @description: Java8类库新增类：Optional
 * Optional实际上是个容器：它可以保存类型T的值，或者仅仅保存null。
 * Optional提供很多有用的方法，这样我们就不用显式进行空值检测。
 * @author: like
 * @create: 2018-05-05 14:35
 **/
public class OptionalDemo {
    public static void main(String[] args) {
        Optional<String> fullName = Optional.ofNullable(null);
        //如果Optional类的实例为非空值的话，isPresent()返回true，否从返回false。
        System.out.println("Full Name is set? " + fullName.isPresent());
        //为了防止Optional为空值，orElseGet()方法通过回调函数来产生一个默认值。
        System.out.println("Full Name: " + fullName.orElseGet(() -> "[none]"));
        //map()函数对当前Optional的值进行转化，然后返回一个新的Optional实例。
        System.out.println(fullName.map(s -> "Hey " + s + "!"));
        //orElse()方法和orElseGet()方法类似，但是orElse接受一个默认值而不是一个回调函数。
        System.out.println(fullName.map(s -> "Hey " + s + "!").orElse("Hey Stranger!"));

        System.out.println();

        Optional<String> firstName = Optional.of("Tom");
        System.out.println("First Name is set? " + firstName.isPresent());
        System.out.println("First Name: " + firstName.orElseGet(() -> "[None]"));
        System.out.println(firstName.map(s -> "Hey " + s + "!").orElse("Hey Stranger"));

    }
}
