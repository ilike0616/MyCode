package cn.like.study.designPattern.decorator;

/**
 * @author like
 * @Title: Client
 * @ProjectName MyCode
 * @Description: 装饰模式场景类
 * 使用场景：
 * 1.需要扩展一个类的功能，或者给一个类增强附加功能
 * 2.需要动态地给一个对象增加功能，这些功能可以再动态地撤销
 * 3.需要为一批的兄弟类进行改装或加装功能，当然是首选装饰模式
 * @date 2018/10/1716:23
 */
public class Client {
    public static void main(String[] args){
        Component component = new ConcreteComponent();
        //第一次修饰
        component = new ConcreteDecorator1(component);
        //第二次修饰
        component = new ConcreteDecorator2(component);
        //修饰后运行
        component.operate();
    }
}
