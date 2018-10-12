package cn.like.study.thread.pipeInputOutput;

import java.io.PipedInputStream;

/**
 * @program: MyCode
 * @description:
 * @author: like
 * @create: 2018-05-24 22:33
 **/
public class ThreadRead extends Thread {
    private ReadData read;
    private PipedInputStream input;

    public ThreadRead(ReadData read, PipedInputStream input) {
        super();
        this.read = read;
        this.input = input;
    }

    public void run() {
        read.readMethod(input);
    }
}
