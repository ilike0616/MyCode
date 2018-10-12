package cn.like.study.thread.pipeInputOutput;

import java.io.PipedOutputStream;

/**
 * @program: MyCode
 * @description:
 * @author: like
 * @create: 2018-05-24 22:30
 **/
public class ThreadWrite extends Thread {
    private WriteData write;
    private PipedOutputStream out;

    public ThreadWrite(WriteData write, PipedOutputStream out) {
        super();
        this.write = write;
        this.out = out;
    }

    public void run() {
        write.writeMethod(out);
    }
}
