package cn.like.study.lang;

/**
 * @program: MyCode
 * @description: 枚举类型
 * @author: like
 * @create: 2018-04-22 23:19
 **/
public class EnumDemo {
    public static void main(String[] args) {
        //枚举类型实例默认的name和ordinal（命名的顺序，从0开始）
        for (DayOfWeed day : DayOfWeed.values()) {
            System.out.println(day.name() + ".ordinal()=" + day.ordinal());
        }
        System.out.println("-------------------------------------");
        //通过compareTo方法比较,实际上其内部是通过ordinal()值比较的
        System.out.println(DayOfWeed.MONDAY + ".compareTo(" + DayOfWeed.TUESDAY + "):" + DayOfWeed.MONDAY.compareTo(DayOfWeed.TUESDAY));
        System.out.println(DayOfWeed.MONDAY + ".compareTo(" + DayOfWeed.WEDNESDAY + "):" + DayOfWeed.MONDAY.compareTo(DayOfWeed.WEDNESDAY));

        System.out.println("class:"+DayOfWeed.MONDAY.getDeclaringClass());

        for (DayOfWeed day : DayOfWeed.values()) {
            System.out.println(day.name() + ".toString()=" + day.toString());
        }

        System.out.println(DayOfWeed.valueOf("MONDAY").equals(DayOfWeed.MONDAY));
    }
}
