package cn.like.study.designPattern.builder;

/**
 * @author like
 * @Title: Builder
 * @ProjectName MyCode
 * @Description: 抽象建造者
 * @date 2018/10/1714:08
 */
public abstract class Builder {
    //设置产品的不同部分，以获得不同的产品
    public abstract void setPart();
    //建造产品
    public abstract Product buildProduct();
}
