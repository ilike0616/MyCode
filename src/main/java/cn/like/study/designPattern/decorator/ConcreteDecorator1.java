package cn.like.study.designPattern.decorator;

/**
 * @author like
 * @Title: ConcreteDecorator1
 * @ProjectName MyCode
 * @Description: 具体的装饰者
 * @date 2018/10/1716:11
 */
public class ConcreteDecorator1 extends Decorator {
    //定义被修饰着
    public ConcreteDecorator1(Component _component) {
        super(_component);
    }
    //定义自己的修饰方法
    private void method1(){
        System.out.println("method1 修饰");
    }
    //重写父类的Operate方法
    @Override
    public void operate() {
        this.method1();
        super.operate();
    }
}
