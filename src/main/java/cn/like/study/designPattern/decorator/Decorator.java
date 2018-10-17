package cn.like.study.designPattern.decorator;

/**
 * @author like
 * @Title: Decorator
 * @ProjectName MyCode
 * @Description: 抽象装饰者
 * @date 2018/10/1716:07
 */
public abstract class Decorator extends Component{
    private Component component = null;
    //通过构造函数传递被修饰者
    public Decorator(Component _component){
        this.component = _component;
    }
    //委托给被修饰者执行
    @Override
    public void operate() {
        this.component.operate();
    }
}
