package cn.like.study.thread.pipeReaderWriter;

import java.io.PipedReader;

/**
 * @program: MyCode
 * @description:
 * @author: like
 * @create: 2018-05-24 22:33
 **/
public class ThreadRead extends Thread {
    private ReadData read;
    private PipedReader input;

    public ThreadRead(ReadData read, PipedReader input) {
        super();
        this.read = read;
        this.input = input;
    }

    @Override
    public void run() {
        read.readMethod(input);
    }
}
