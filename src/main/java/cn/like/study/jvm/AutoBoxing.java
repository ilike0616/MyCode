package cn.like.study.jvm;

/**
 * @program: MyCode
 * @description: 自动装箱的陷阱
 * @author: like
 * @create: 2018-04-29 00:20
 **/
public class AutoBoxing {
    public static void main(String[] args) {
        Integer a = 1;
        Integer b = 126;
        Integer c = 127;
        Integer d = 127;
        Integer e = 128;
        Integer f = 128;
        Long g = 127L;
        System.out.println(c == d);
        System.out.println(e == f);
        System.out.println(c == (a + b));
        System.out.println(c.equals(a + b));
        System.out.println(g == (a + b));
        System.out.println(g.equals(a + b));
    }
}
