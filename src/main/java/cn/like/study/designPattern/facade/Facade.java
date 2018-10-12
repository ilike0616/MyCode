package cn.like.study.designPattern.facade;

/**
 * @program: MyCode
 * @description: 门面对象
 * 门面不参与子系统的业务逻辑
 * @author: like
 * @create: 2018-10-12 15:59
 **/
public class Facade {
    //被委托的对象
    private ClassA a = new ClassA();
    private ClassB b = new ClassB();
    private ClassC c = new ClassC();
    //提供给外部访问的方法
    public void  methodA(){
        this.a.doSomethingA();
    }

    public void methodB(){
        this.b.doSomethingB();
    }

    public void methodC(){
        this.c.doSomethingC();
    }
}
