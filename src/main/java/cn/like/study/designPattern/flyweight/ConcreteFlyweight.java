package cn.like.study.designPattern.flyweight;

/**
 * @author like
 * @Title: ConcreteFlyweight
 * @ProjectName MyCode
 * @Description: 具体享元角色
 * 具体的一个产品了，实现抽象角色定义的业务。该角色中需要注意的是内部状态处理应该与环境无关，
 * 不应出现一个操作改变了内部状态，同事修改了外部状态，这是绝对不允许的。
 * @date 2018/10/1617:35
 */
public class ConcreteFlyweight extends Flyweight {
    //接受外部状态
    public ConcreteFlyweight(String _extrinsic){
        super(_extrinsic);
    }
    //根据外部状态进行逻辑处理
    public void operate(){
        //业务逻辑
    }
}
