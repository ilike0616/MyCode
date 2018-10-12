package cn.like.study.thread.pipeReaderWriter;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedReader;

/**
 * @program: MyCode
 * @description: 字符流
 * @author: like
 * @create: 2018-05-24 21:20
 **/
public class ReadData {
    public void readMethod(PipedReader input) {
        try {
            System.out.println("read :");
            char[] byteArray = new char[20];
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
