package cn.like.study.designPattern.builder;

/**
 * @author like
 * @Title: Director
 * @ProjectName MyCode
 * @Description: 导演类
 * 建造者模式的使用场景：
 * 1.相同的方法，不同的执行顺序，产生不同的事件结果
 * 2.产品类非常复杂，或者产品类中的调用顺序不同产生了不同的效能
 * 3.在对象创建过程中会使用到系统中的一些其他对象，这些对象在产品对象的创建过程中不易得到时
 * @date 2018/10/1714:59
 */
public class Director {
    private Builder builder = new ConcreteBuilder();

    public Product getAProduct(){
        builder.setPart();
        /**
         * 设置不同的零件，产生不同的产品
         */
        return builder.buildProduct();
    }
}
