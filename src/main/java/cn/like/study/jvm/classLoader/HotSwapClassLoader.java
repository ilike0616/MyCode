package cn.like.study.jvm.classLoader;

/**
 * @program: MyCode
 * @description: 《深入理解JVM虚拟机》
 * 为了多次载入执行类而加入的加载器
 * 把defineClass方法开放出来，只有外部显示调用的时候才会使用到loadByte方法
 * 由虚拟机调用时，仍然按照原有的双亲委派规则使用loadClass方法进行类加载
 * @author: like
 * @create: 2018-04-28 15:03
 **/
public class HotSwapClassLoader extends ClassLoader {
    /**
     * 构造函数中指定为加载HotSwapClassLoader的的类加载器作为父类加载器
     * 这一步时实现提交的代码可以访问服务器引用类库的关键。
     */
    public HotSwapClassLoader() {
        super(HotSwapClassLoader.class.getClassLoader());
    }

    /**
     * 公开父类中的protected方法defineClass()
     * 使用这个方法把提交执行的Java类的byte[]数组转变为Class类
     * @param classByte
     * @return
     */
    public Class loadByte(byte[] classByte) {
        return defineClass(null, classByte, 0, classByte.length);
    }
}
