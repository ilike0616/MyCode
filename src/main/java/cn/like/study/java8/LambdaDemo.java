package cn.like.study.java8;

import java.util.Arrays;

/**
 * @program: MyCode
 * @description: Java8新特性：Lambda表达式
 * @author: like
 * @create: 2018-05-04 20:49
 **/
public class LambdaDemo {
    public static void main(String[] args) {
        //参数e的类型是由编译器推测出来的
        Arrays.asList("a", "b", "c").forEach(e ->
                System.out.println(e));
        //通过把参数类型与参数包括在括号中的形式直接给出参数的类型
        Arrays.asList("a", "b", "c").forEach((String e) ->
                System.out.println(e));
        //函数体多行时可以把函数体放在一对花括号中
        Arrays.asList("a", "b", "d").forEach(e -> {
            System.out.print(e);
            System.out.print(e);
        });

        //有没有final事等价的，lambda可以引用类的成员边磊和局部变量，如果变量不是final的，会被隐含的转为final
        //String separator = ",";
        final String separator = ",";
        Arrays.asList("a", "b", "d").forEach(
                (String e) -> System.out.print(e + separator));

        //下面这两种写法是等价的，lambda的函数体只有一行的话可以省略return语句
        Arrays.asList( "a", "b", "d" ).sort( ( e1, e2 ) -> e1.compareTo( e2 ) );
        Arrays.asList( "a", "b", "d" ).sort( ( e1, e2 ) -> {
            int result = e1.compareTo( e2 );
            System.out.println(e1+"=="+e2+":"+result);
            return result;
        } );
    }
}
