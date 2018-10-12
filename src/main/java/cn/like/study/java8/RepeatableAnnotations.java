package cn.like.study.java8;

import java.lang.annotation.*;

/**
 * @program: MyCode
 * @description: Java8新特性：重复注解
 * Java5引入了注解机制，但相同的注解在同一位置只能声明一次。
 * Java8引入了重复注解机制，相同的注解就可以在同一位置声明多次。
 * 重复注解机制本身必须用@Repeatable注解。
 * 反射相关的API提供了新的函数getAnnotationsByType()来返回重复注解的类型
 * @author: like
 * @create: 2018-05-04 23:32
 **/
public class RepeatableAnnotations {

    @Target(ElementType.TYPE)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface Filters {
        Filter[] value();
    }

    @Target(ElementType.TYPE)
    @Retention(RetentionPolicy.RUNTIME)
    @Repeatable(Filters.class)      //该注解开启重复注解机制
    public @interface Filter {
        String value();
    }

    @Filter("filter1")
    @Filter("filter2")
    public interface Filterable {

    }

    public static void main(String[] args) {
        for (Filter filter : Filterable.class.getAnnotationsByType(Filter.class)) {
            System.out.println(filter.value());
        }
    }
}
