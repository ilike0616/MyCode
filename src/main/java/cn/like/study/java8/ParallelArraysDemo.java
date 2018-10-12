package cn.like.study.java8;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @program: MyCode
 * @description: Java8新特性：并行数组
 * Java 8增加了大量的新方法来对数组进行并行处理。
 * 可以说，最重要的是parallelSort()方法，因为它可以在多核机器上极大提高数组排序的速度。
 * @author: like
 * @create: 2018-05-05 17:49
 **/
public class ParallelArraysDemo {
    public static void main(String[] args) {
        long[] arrayOfLong = new long[20000];

        //对数组进行随机赋值
        Arrays.parallelSetAll(arrayOfLong,
                index -> ThreadLocalRandom.current().nextInt(1000000));
        Arrays.stream(arrayOfLong).limit(10).forEach(
                i -> System.out.print(i + " "));
        System.out.println();

        //并行排序，parallelSort通过Fork/Join并行框架来实现
        Arrays.parallelSort(arrayOfLong);
        Arrays.stream(arrayOfLong).limit(10).forEach(
                i -> System.out.print(i + " "));
    }
}
