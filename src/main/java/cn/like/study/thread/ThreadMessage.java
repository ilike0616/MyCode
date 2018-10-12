package cn.like.study.thread;


import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

/**
 * @program: MyCode
 * @description: 使用JMX查看一个普通Java程序包含哪些线程
 * @author: like
 * @create: 2018-04-30 22:46
 **/
public class ThreadMessage {
    public static void main(String[] args) {
        //获取Java线程的管理MXBean
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();

        ThreadInfo[] threadInfos = threadMXBean.dumpAllThreads(false, false);

        for (ThreadInfo threadInfo : threadInfos) {
            System.out.println("[" + threadInfo.getThreadId() + "] " + threadInfo.getThreadName());
        }
        /**
         * [4] Signal Dispatcher    //分发处理发送给JVM信号的线程
         * [3] Finalizer            //调用对象finalize方法的线程
         * [2] Reference Handler    //清除Reference的线程
         *[1] main                  //main线程，用户程序入口
         */
    }
}
