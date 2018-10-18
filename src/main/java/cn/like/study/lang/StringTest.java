package cn.like.study.lang;

/**
 * @author like
 * @Title: StringTest
 * @ProjectName MyCode
 * @Description: TODO
 * @date 2018/10/1618:03
 */
public class StringTest {
    public static void main(String[] args){
        //堆中开辟一块存放引用str1，str1指向常量池中的"和谐"
        String str1 = "和谐";
        //堆中开辟一块存放引用str2，str1指向常量池中的"社会"
        String str2 = "社会";
        //堆中开辟一块存放引用str3，str1指向常量池中的"和谐社会"
        String str3 = "和谐社会";
        //堆中开辟一块存放引用str4
        String str4;
        //str1 + str2通过StringBuilder的最后一步toString()方法还原一个新的String对象"和谐社会"，因此堆中开辟一块空间存放此对象。
        //引用str4指向堆中(str1+str2)所还原的新的String对象
        str4 = str1 + str2;
        //常量池中没有两个完全一样的常量
        System.out.println(("和谐"+"社会") == "和谐社会");  //true
        //不同的引用
        System.out.println(str3 == str4);   //false
        //intern方法使用：一个初始为空的字符串池，它由类String独自维护。当调用 intern方法时，
        // 如果池已经包含一个等于此String对象的字符串（用equals(oject)方法确定），则返回池中的字符串。
        // 否则，将此String对象添加到池中，并返回此String对象的引用。
        //它遵循以下规则：对于任意两个字符串 s 和 t，当且仅当 s.equals(t) 为 true 时，s.intern() == t.intern() 才为 true。
        str4 = (str1+str2).intern();
        System.out.println(str3 == str4);   //true

    }
}
