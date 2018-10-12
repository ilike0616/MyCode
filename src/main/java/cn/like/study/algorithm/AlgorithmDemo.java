package cn.like.study.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: MyCode
 * @description: 算法测试
 * @author: like
 * @create: 2018-04-21 19:00
 **/
public class AlgorithmDemo {

    public static void main(String[] args) throws InterruptedException {
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < 10000; i++) {
            list.add((int) (Math.random() * 100000000));
        }
        System.out.println("数组长度："+list.size());

        long quickStart = System.currentTimeMillis();
        ArrayList quick = QuickSort.quickSort(list);
        long quickEnd = System.currentTimeMillis();
        System.out.println("快速排序耗时：" + (quickEnd - quickStart) + "ms");

        long selectStart = System.currentTimeMillis();
        ArrayList select = SelectSort.selectSort(list);
        long selectEnd = System.currentTimeMillis();
        System.out.println("选择排序耗时：" + (selectEnd - selectStart) + "ms");

        System.out.println(quick.containsAll(select));
    }
}
