package cn.like.study.designPattern.abstractFactory;

/**
 * @program: MyCode
 * @description: 接口Shape的实体类
 * @author: like
 * @create: 2018-04-21 09:37
 **/
public class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("Inside Rectangle::draw() method.");
    }
}
