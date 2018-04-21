package cn.like.study.designPattern.abstractFactory;

/**
 * @program: MyCode
 * @description: 使用 FactoryProducer 来获取 AbstractFactory，通过传递类型信息来获取实体类的对象
 * @author: like
 * @create: 2018-04-21 10:09
 **/
public class AbstractFactoryPatternDemo {
    public static void main(String[] args) {

        //获取形状工厂
        AbstractFactory shapeFactory = FactoryProducer.getFactory("Shape");
        //获取形状为Circle的对象
        Shape circle = shapeFactory.getShape("Circle");
        circle.draw();

        Shape rectangle = shapeFactory.getShape("Rectangle");
        rectangle.draw();

        Shape square = shapeFactory.getShape("Square");
        square.draw();

        //获取颜色工厂
        AbstractFactory colorFactory = FactoryProducer.getFactory("color");

        Color blue = colorFactory.getColor("Blue");
        blue.fill();

        Color green = colorFactory.getColor("Green");
        green.fill();

        Color red = colorFactory.getColor("Red");
        red.fill();
    }
}
