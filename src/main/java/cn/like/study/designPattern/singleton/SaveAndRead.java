package cn.like.study.designPattern.singleton;

import java.io.*;

/**
 * @program: MyCode
 * @description:
 * @author: like
 * @create: 2018-06-06 19:53
 **/
public class SaveAndRead {
    public static void main(String[] args) {
        try {
            SingletonSerializable myObject = SingletonSerializable.getInstance();
            FileOutputStream fosRef = new FileOutputStream(new File("myObjectFile.txt"));
            ObjectOutputStream oosRef = new ObjectOutputStream(fosRef);
            oosRef.writeObject(myObject);
            oosRef.close();
            fosRef.close();
            System.out.println(myObject.hashCode());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            FileInputStream fisRef = new FileInputStream(new File("myObjectFile.txt"));
            ObjectInputStream oisRef = new ObjectInputStream(fisRef);
            SingletonSerializable myObject = (SingletonSerializable) oisRef.readObject();
            oisRef.close();
            fisRef.close();
            System.out.println(myObject.hashCode());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
