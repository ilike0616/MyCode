package cn.like.study.jvm.oom;

/**
 * VM Args：-Xss128k
 * 栈容量由-Xss参数设定（对于HotSpot，设置本地方法栈大小的-Xoss参数实际上无效）
 * @author zzm
 */
public class JavaVMStackSOF {
    private int stackLength = 1;

    public void stackLeak() {
        stackLength++;
        stackLeak();
    }

    public static void main(String[] args) throws Throwable {
        JavaVMStackSOF oom = new JavaVMStackSOF();
        try {
            oom.stackLeak();
        } catch (Throwable e) {
            System.out.println("stack length:" + oom.stackLength);
            throw e;
        }
    }
}
