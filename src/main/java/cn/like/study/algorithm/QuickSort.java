package cn.like.study.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: MyCode
 * @description: 快速排序算法
 * @author: like
 * @create: 2018-04-21 18:46
 **/
public class QuickSort {
    public static ArrayList<Integer> quickSort(ArrayList<Integer> list) throws InterruptedException {
        //基线条件，为空或只包含一个元素的数组是"有序"的
        if (list.size() < 2) {
            return list;
        }
        int first = list.get(0);
        ArrayList<Integer> small = new ArrayList<Integer>();
        ArrayList<Integer> big = new ArrayList<Integer>();
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) <= first) {
                small.add(list.get(i));
            } else if (list.get(i) > first) {
                big.add(list.get(i));
            }
        }
        ArrayList<Integer> sortList = new ArrayList<Integer>();
        sortList.addAll(quickSort(small));
        sortList.add(first);
        sortList.addAll(quickSort(big));
        return sortList;
    }
}
