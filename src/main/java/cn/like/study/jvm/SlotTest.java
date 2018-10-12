package cn.like.study.jvm;

/**
 * @program: MyCode
 * @description:
 * @author: like
 * @create: 2018-04-27 12:06
 **/
public class SlotTest {
    public static void main(String[] args) {
        /**
         * 执行System.gc()时，变量placeholder还处于作用于范围之内
         */
//        byte[] placeholder = new byte[64*1024*1024];
//        System.gc();

        /**
         * placeholder没有被回收
         * 原因：离开placeholder作用域之后没有任何对局部变量表的读写操作，
         * placeholder原本所占用的Slot还没有被其他变脸所复用，
         * 所以作为GC Roots一部分的局部变量表仍然保持着对它的关联
         */
//        {
//            byte[] placeholder = new byte[64 * 1024 * 1024];
//        }
//        System.gc();

        /**
         * placeholder被回收
         */
        {
            byte[] placeholder = new byte[64 * 1024 * 1024];
        }
        int a = 0;
        System.gc();
    }
}
