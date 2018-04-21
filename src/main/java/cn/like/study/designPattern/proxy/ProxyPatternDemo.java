package cn.like.study.designPattern.proxy;

public class ProxyPatternDemo {
    public static void main(String[] args) {
        Image image = new ProxyImage("test_10mb.jpg");

        //图像将从磁盘加载
        image.display();
        System.out.println("");
        //图像将无法从磁盘加载
        image.display();
    }
}
/****输出**********************
 *  Loading test_10mb.jpg
 *  Displaying test_10mb.jpg
 *
 *  Displaying test_10mb.jpg
 * ***************************/