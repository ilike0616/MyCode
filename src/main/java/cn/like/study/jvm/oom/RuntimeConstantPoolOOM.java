package cn.like.study.jvm.oom;

/**
 *在JDK1.6中，intern()方法会把首次遇到的字符串实例复制到永久代中，返回的也是永久代中这个字符串实例的引用。
 * 而JDK1.7的intern()实现不会再复制实例，只是在常量池中记录首次出现的实例引用。
 */
public class RuntimeConstantPoolOOM {
    public static void main(String[] args) {
        String str1 = new StringBuilder("中国").append("钓鱼岛").toString();
        System.out.println(str1.intern() == str1);//true（JDK1.7起，JDK1.6之前输出false）

        String str2 = new StringBuilder("ja").append("va").toString();
        System.out.println(str2.intern() == str2);//false
    }
}
