package cn.like.study.designPattern.decorator;

/**
 * @author like
 * @Title: ConcreteDecorator2
 * @ProjectName MyCode
 * @Description: 具体的装饰者
 * @date 2018/10/1716:15
 */
public class ConcreteDecorator2 extends Decorator {
    //定义被修饰者
    public ConcreteDecorator2(Component _component) {
        super(_component);
    }
    //定义自己的修饰方法
    private void method2(){
        System.out.println("method2 修饰");
    }
    //重写父类的Operate方法
    @Override
    public void operate() {
        super.operate();
        this.method2();
    }
}
