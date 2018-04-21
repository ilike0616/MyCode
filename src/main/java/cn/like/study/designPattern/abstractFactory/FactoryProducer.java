package cn.like.study.designPattern.abstractFactory;

/**
 * @program: MyCode
 * @description: 工厂创造器/生成器类，通过传递形状或颜色信息来获取工厂
 * @author: like
 * @create: 2018-04-21 10:03
 **/
public class FactoryProducer {
    public static AbstractFactory getFactory(String choice) {
        if ("Shape".equalsIgnoreCase(choice)) {
            return new ShapeFactory();
        } else if ("Color".equalsIgnoreCase(choice)) {
            return new ColorFactory();
        }
        return null;
    }
}
