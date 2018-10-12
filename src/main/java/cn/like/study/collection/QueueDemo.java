package cn.like.study.collection;


import java.util.LinkedList;

/**
 * @program: MyCode
 * @description: 队列示例
 * @author: like
 * @create: 2018-04-22 10:38
 **/
public class QueueDemo {

    public static void meth(){
        System.out.println("静态方法");
    }



    public static void main(String[] args){
        QueueDemo a = new QueueDemo();
        a.meth();
        LinkedList<Integer> linkedList = new LinkedList<Integer>();
        for(int i=0;i<20;i++){
            linkedList.add(i);
        }
        System.out.println(linkedList);
    }
}
