package cn.like.study.thread;

/**
 * @program: MyCode
 * @description: Final域重排序规则
 * @author: like
 * @create: 2018-04-30 05:11
 **/
public class ReorderFinal {
    int i;                  //普通变量
    final int j;            //final变量
    static ReorderFinal obj;

    public ReorderFinal() {
        i = 1;
        j = 2;
    }

    public static void writer() {
        obj = new ReorderFinal();
    }

    public static void reader() {
        ReorderFinal object = obj;
        int a = object.i;
        int b = object.j;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 1000; i++) {
//            ReorderFinal re = new ReorderFinal();
            Thread t1 = new Thread(new Runnable() {
                @Override
                public void run() {
                    writer();
                }
            });
            Thread t2 = new Thread(new Runnable() {
                @Override
                public void run() {
                    reader();
                }
            });
            t1.start();
            t2.start();
        }
        while (Thread.activeCount() > 1) {
            Thread.yield();
        }
    }
}
