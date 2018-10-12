package cn.like.study.jvm.classLoader;


import java.lang.reflect.Method;

/**
 * @program: MyCode
 * @description: JavaClass执行工具
 * @author: like
 * @create: 2018-04-28 17:13
 **/
public class JavaClassExecuter {
    /**
     * 执行外部传过来的代表一个Java类的byte[]数组
     * 将输入类的byte数组中代表java.lang.System的CONSTANT_Utf8_info常量修改为劫持后的HackSystem类
     * 执行方法为该类的static main(String[] args)方法，输入结果为该类向System.out/err输入的信息
     *
     * @param classByte 代表一个Java类的byte数组
     * @return 执行结果
     */
    public static String execute(byte[] classByte) {
        HackSystem.clearBuffer();
        ClassModifier cm = new ClassModifier(classByte);
        byte[] modiBytes = cm.modifyUTF8Constant("java/lang/System", "cn.like.study.jvm.classLoader.HackSystem");
        HotSwapClassLoader loader = new HotSwapClassLoader();
        Class clazz = loader.loadByte(modiBytes);
        try {
            Method method = clazz.getMethod("main", new Class[]{String[].class});
            method.invoke(null, new String[]{null});
        } catch (Throwable e) {
            e.printStackTrace(HackSystem.out);
        }
        return HackSystem.getBufferString();
    }
}
