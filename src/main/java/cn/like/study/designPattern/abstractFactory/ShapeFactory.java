package cn.like.study.designPattern.abstractFactory;

/**
 * @program: MyCode
 * @description: 扩展AbstractFactory，基于给定的信息生产实体类对象
 * @author: like
 * @create: 2018-04-21 09:51
 **/
public class ShapeFactory extends AbstractFactory {
    @Override
    Color getColor(String color) {
        return null;
    }

    @Override
    Shape getShape(String shape) {
        if (shape == null) {
            return null;
        }
        if (shape.equalsIgnoreCase("Rectangle")) {
            return new Rectangle();
        } else if (shape.equalsIgnoreCase("Circle")) {
            return new Circle();
        } else if (shape.equalsIgnoreCase("Square")) {
            return new Square();
        }
        return null;
    }
}
