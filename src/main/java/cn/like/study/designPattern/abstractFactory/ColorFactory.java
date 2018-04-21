package cn.like.study.designPattern.abstractFactory;

/**
 * @program: MyCode
 * @description: 扩展AbstractFactory，基于给定的信息生产实体类对象
 * @author: like
 * @create: 2018-04-21 09:58
 **/
public class ColorFactory extends AbstractFactory {
    @Override
    Color getColor(String color) {
        if (color == null) {
            return null;
        }
        if (color.equalsIgnoreCase("Blue")) {
            return new Blue();
        } else if (color.equalsIgnoreCase("Green")) {
            return new Green();
        } else if (color.equalsIgnoreCase("Red")) {
            return new Red();
        }
        return null;
    }

    @Override
    Shape getShape(String shape) {
        return null;
    }
}
