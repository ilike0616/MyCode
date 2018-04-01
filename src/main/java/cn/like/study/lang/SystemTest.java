package cn.like.study.lang;

public class SystemTest {
    public static void main(String[] args){
        long max = Runtime.getRuntime().maxMemory();
        System.out.println(max/1024);
    }
}
