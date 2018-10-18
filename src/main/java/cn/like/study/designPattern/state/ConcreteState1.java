package cn.like.study.designPattern.state;

/**
 * 具体状态角色：每一个具体状态必须完成两个职责，
 * 本状态下要做的事情，以及本状态如何过渡到其他状态。
 */
public class ConcreteState1 extends State {
    @Override
    public void handle1() {
        //本状态下必须处理的逻辑
    }

    @Override
    public void handle2() {
        //设置当前状态为state2
        super.context.setCurrentState(Context.STATE2);
        //过度到state2状态，由Context实现
        super.context.handle2();
    }
}
