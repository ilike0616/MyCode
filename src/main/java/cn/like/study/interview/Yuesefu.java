package cn.like.study.interview;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: MyCode
 * @description: 约瑟夫环问题
 * @author: like
 * @create: 2018-04-20 14:05
 **/
public class Yuesefu {

    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        System.out.print("请输入总人数：");
//        int totalNum = scanner.nextInt();
//        System.out.print("请输入报数的大小：");
//        int cycleNum = scanner.nextInt();
//        System.out.print("请输入开始编号：");
//        int  startNO= scanner.nextInt();
//        yuesefu(totalNum, cycleNum,startNO);
        yuesefu(10, 3,3);
    }

    public static void yuesefu(int totalNum, int countNum,int startNO) {
        // 初始化人数
        List<Integer> start = new ArrayList<Integer>();
        for (int i = 1; i <= totalNum; i++) {
            start.add(i);
        }
        //从下标为K开始计数
        int k = startNO-1;
        while (start.size() >0) {
            System.out.println(start);
            //第m人的索引位置
            k = (k + countNum) % (start.size()) - 1;
            // 判断是否到队尾  到队尾时候k=-1
            if (k < 0) {
                System.out.println(start.get(start.size()-1));
                start.remove(start.size() - 1);
                k = 0;
            } else {
                System.out.println(start.get(k));
                start.remove(k);
            }
        }
    }
}
