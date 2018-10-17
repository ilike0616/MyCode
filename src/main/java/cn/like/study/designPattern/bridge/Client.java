package cn.like.study.designPattern.bridge;

/**
 * @author like
 * @Title: Client
 * @ProjectName MyCode
 * @Description: 场景类
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
