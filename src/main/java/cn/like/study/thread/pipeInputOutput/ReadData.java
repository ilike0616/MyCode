package cn.like.study.thread.pipeInputOutput;

import java.io.IOException;
import java.io.PipedInputStream;

/**
 * @program: MyCode
 * @description:
 * @author: like
 * @create: 2018-05-24 21:20
 **/
public class ReadData {
    public void readMethod(PipedInputStream input) {
        try {
            System.out.println("read :");
            byte[] byteArray = new byte[20];
            int readLength = input.read(byteArray);
            while (readLength != -1) {
                String newDate = new String(byteArray, 0, readLength);
                System.out.print(newDate);
                readLength = input.read(byteArray);
            }
            System.out.println();
            input.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
