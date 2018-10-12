package cn.like.study.jvm;


import cn.like.study.TestBean;

/**
 * @program: MyCode
 * @description: 类加载测试
 * @author: like
 * @create: 2018-04-24 18:37
 **/
public class ClassLoaderTest {
    public static void main(String[] args) {
        //默认ClassLoader是AppClassLoader
        System.out.println(ClassLoader.getSystemClassLoader());
        ClassLoader loder = TestBean.class.getClassLoader();
        //jdk.internal.loader.ClassLoaders$AppClassLoader@1de0aca6
        System.out.println(loder);

        //第一种获得Class的方式：对象得到类
        TestBean testBean = new TestBean();
        Class testCls = testBean.getClass();
        System.out.println(testCls);
        //第二种获得Class的方式：直接获取
        Class testCls2 = TestBean.class;
        System.out.println(testCls == testCls2);

        try {
            //第二种获得Class的方式：反射
            Class testCls3 = Class.forName("cn.like.study.TestBean");
            System.out.println(testCls2 == testCls3);
            ClassLoader.getSystemClassLoader().loadClass("cn.like.study.TestBean");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
