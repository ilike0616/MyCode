package cn.like.study.io;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;

/**
 * @program: MyCode
 * @description: 管道输入/输出流
 * @author: like
 * @create: 2018-05-01 02:42
 **/
public class Piped {
    public static void main(String[] args) throws Exception {
        PipedWriter out = new PipedWriter();
        PipedReader in = new PipedReader();

        out.connect(in);

        Thread printThread = new Thread(new Print(in), "PrintThread");
        printThread.start();
        int receive = 0;
        try {
            while ((receive = System.in.read()) != -1) {
                out.write(receive);
            }
        } finally {
            out.close();
        }
    }

    static class Print implements Runnable {
        private PipedReader in;

        public Print(PipedReader in) {
            this.in = in;
        }

        public void run() {
            int receive = 0;
            try {
                while ((receive = in.read()) != -1) {
                    System.out.println("receive:" + receive);
                }
            } catch (IOException ex) {
            }
        }
    }
}