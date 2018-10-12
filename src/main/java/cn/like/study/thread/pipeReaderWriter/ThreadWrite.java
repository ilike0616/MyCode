package cn.like.study.thread.pipeReaderWriter;

import java.io.PipedWriter;

/**
 * @program: MyCode
 * @description:
 * @author: like
 * @create: 2018-05-24 22:30
 **/
public class ThreadWrite extends Thread {
    private WriteData write;
    private PipedWriter out;

    public ThreadWrite(WriteData write, PipedWriter out) {
        super();
        this.write = write;
        this.out = out;
    }

    @Override
    public void run() {
        write.writeMethod(out);
    }
}
