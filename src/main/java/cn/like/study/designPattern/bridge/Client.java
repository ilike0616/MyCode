package cn.like.study.designPattern.bridge;

/**
 * @author like
 * @Title: Client
 * @ProjectName MyCode
 * @Description: 场景类：桥梁模式
 * 使用场景：
 * 1.不希望或不适用使用继承的场景
 * 2.接口或抽象类不稳定的场景
 * 3.重要性要求较高的场景
 * @date 2018/10/1711:09
 */
public class Client {
    public static void main(String[] args){
        //定义一个实现化角色
        Implementor imp = new ConcreteImplementor1();
        //定义一个抽象化角色
        Abstraction abs = new RefineAbstraction(imp);
        //执行
        abs.request();
    }
}
