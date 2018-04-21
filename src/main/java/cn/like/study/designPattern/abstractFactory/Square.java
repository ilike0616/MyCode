package cn.like.study.designPattern.abstractFactory;

/**
 * @program: MyCode
 * @description: 接口Shape的实现类
 * @author: like
 * @create: 2018-04-21 09:39
 **/
public class Square implements Shape {
    @Override
    public void draw() {
        System.out.println("Inside Square::draw() method.");
    }
}
