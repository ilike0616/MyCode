package cn.like.study.lang;

public class ObjectTest {
    private int num = 1;
    /**
     * 如果两个对象的equals返回ture，则hashCode必须相等，
     * 如果两个对象的equals返回false，则hashCode允许相等，
     * 但hashCode相等，equals不一定时true。
     * @param args
     */
    public static void main(String[] args){
        ClassA  a = new ClassA("A");
        ClassA b = new ClassA("A");
        System.out.println(a.hashCode());
        System.out.println(a.equals(b));
        a.setName("AA");
        System.out.println(a.hashCode());
        System.out.println(b.hashCode());
        System.out.println(a.equals(b));
        System.out.println(a==b);
    }
}
