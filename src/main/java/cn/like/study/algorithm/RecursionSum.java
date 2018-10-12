package cn.like.study.algorithm;

import java.util.LinkedList;
import java.util.Random;

/**
 * @program: MyCode
 * @description: 数组地柜求和
 * @author: like
 * @create: 2018-04-21 17:28
 **/
public class RecursionSum {
    public static int sum(LinkedList<Integer> list) {
        if (list.size() == 0) {
            return 0;
        }
        int first = list.getFirst();
        list.removeFirst();
        return first + sum(list);
    }

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<Integer>();
        Random random = new Random(1);
        for (int i = 0; i < 10; i++) {
            list.add((int) (Math.random() * 10));
        }
        System.out.println(list);
        System.out.println("sum:" + sum(list));

    }
}
