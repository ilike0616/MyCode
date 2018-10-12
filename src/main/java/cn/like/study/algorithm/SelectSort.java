package cn.like.study.algorithm;

import java.util.ArrayList;

/**
 * @program: MyCode
 * @description: 选择排序算法
 * @author: like
 * @create: 2018-04-21 19:18
 **/
public class SelectSort {
    public static ArrayList<Integer> selectSort(ArrayList<Integer> list) {
        ArrayList<Integer> newList = new ArrayList<Integer>();
        while (list.size() > 0) {
            int minIndex = 0;//最小值的坐标
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i) < list.get(minIndex)) {
                    minIndex = i;
                }
            }
            newList.add(list.get(minIndex));
            list.remove(minIndex);
        }
        return newList;
    }
}
