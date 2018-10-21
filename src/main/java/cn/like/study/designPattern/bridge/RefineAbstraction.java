package cn.like.study.designPattern.bridge;

/**
 * @author like
 * @Title: RefineAbstraction
 * @ProjectName MyCode
 * @Description: 具体抽象化角色
 * @date 2018/10/1711:06
 */
public class RefineAbstraction extends Abstraction {
    //覆写构造函数
    public RefineAbstraction(Implementor _imp) {
        super(_imp);
    }
    //修正父类的行为
    @Override
    public void request() {
        super.request();
        super.getImp().doAnything();
    }
}
