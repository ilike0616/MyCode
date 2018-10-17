package cn.like.study.designPattern.builder;

/**
 * @author like
 * @Title: ConcreteBuilder
 * @ProjectName MyCode
 * @Description: 具体建造者
 * @date 2018/10/1714:56
 */
public class ConcreteBuilder extends Builder{
    private Product product = new Product();
    //设置产品零件
    public void setPart(){
        /*
         *  产品类内的逻辑处理
         */
    }

    public Product buildProduct(){
        return product;
    }
}
