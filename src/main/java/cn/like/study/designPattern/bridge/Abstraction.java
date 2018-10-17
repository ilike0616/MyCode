package cn.like.study.designPattern.bridge;

/**
 * @author like
 * @Title: Abstraction
 * @ProjectName MyCode
 * @Description: 抽象化角色
 * @date 2018/10/1711:02
 */
public abstract class Abstraction {
    //定义对实例化角色的引用
    private Implementor imp;
    //约束子类必须实现该构造函数
    public Abstraction(Implementor _imp){
        this.imp = _imp;
    }
    //自身的行为和属性
    public void request(){
        this.imp.doAnything();
    }
    //获得实现化角色
    public Implementor getImp(){
        return imp;
    }
}
