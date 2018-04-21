package cn.like.study.designPattern.abstractFactory;

/**
 * @program: MyCode
 * @description: 抽象工厂
 * @author: like
 * @create: 2018-04-21 09:49
 **/
public abstract class AbstractFactory {
    abstract Color getColor(String color);

    abstract Shape getShape(String shape);
}
