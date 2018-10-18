package cn.like.study.designPattern.flyweight;

/**
 * @author like
 * @Title: Flyweight
 * @ProjectName MyCode
 * @Description: 抽象享元角色
 * 定义出对象的外部状态和内部状态的接口实现
 * @date 2018/10/1617:25
 */
public abstract class Flyweight {
    //内部状态
    private String intrinsic;
    //外部状态
    protected final String extrinsic;
    //要求享元角色必须接受外部状态
    public Flyweight(String _extrinsic){
        this.extrinsic = _extrinsic;
    }
    //定义业务操作
    public abstract void operate();
    //内部状态的getter/setter
    public String getIntrinsic() {
        return intrinsic;
    }
    public void setIntrinsic(String intrinsic) {
        this.intrinsic = intrinsic;
    }
}
