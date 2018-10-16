package cn.like.study.designPattern.state;

/**
 * 状态模式
 *
 * 有点：结构清晰，遵循设计原则（开闭原则、单一职责原则），封装性、扩展性好
 * 缺点：子类会太多，即类膨胀
 * 使用创景：1.行为随状态改变而改变的场景，例如权限设计
 * 2.条件、分支判断语句的替代者
 */
public class Client {
    public static void main(String[] args){
        //定义环境角色
        Context context = new Context();
        //初始化状态
        context.setCurrentState(new ConcreteState1());
        //执行状态
        context.handle1();
        context.handle2();
    }
}
