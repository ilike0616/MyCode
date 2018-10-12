package cn.like.study.jvm;

/**
 * @program: MyCode
 * @description:
 * @author: like
 * @create: 2018-04-25 22:13
 **/
public class JVMBean {
    private int x;
    /**
     * 无异常返回1，catch到Exception时返回2
     * @return
     */
    public int inc() {
        try {
            x = 1;
            return x;
        } catch (Exception e) {
            x = 2;
            return x;
        } finally {
            x = 3;
        }
    }

    public static void main(String[] args){
        JVMBean bean = new JVMBean();
        System.out.println(bean.inc());
        System.out.println(bean.x);
    }
}
