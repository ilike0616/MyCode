package cn.like.study.volatiledemo;

/**
 * @program: MyCode
 * @description:
 * @author: like
 * @create: 2018-05-22 23:18
 **/
public class Run {
    public static void main(String[] args){
        try {
            Service service = new Service();
            ThreadA a = new ThreadA(service);
            a.start();
            Thread.sleep(1000);
            ThreadB b = new ThreadB(service);
            b.start();
            System.out.println("已经发起停止的命令了！");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
