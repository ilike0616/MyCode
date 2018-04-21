package cn.like.study.jvm.oom;

import java.util.ArrayList;
import java.util.List;
/**
 * VM Args：-Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
 * -Xms：堆的最小值
 * -Xmx：堆的最大值
 * -XX:+HeapDumpOnOutOfMemoryError：可以让虚拟机在出现内存溢出异常时Dump出当前的内存堆转储快照以便事后分析
 * @author zzm
 */
public class HeapOOM {

    static class OOMObject {
    }

    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<OOMObject>();

        while (true) {
            list.add(new OOMObject());
        }
    }
}