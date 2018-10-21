package cn.like.study.designPattern.decorator;

/**
 * @author like
 * @Title: ConcreteComponent
 * @ProjectName MyCode
 * @Description: 具体构件
 * @date 2018/10/1716:05
 */
public class ConcreteComponent extends Component {
    //具体实现
    @Override
    public void operate() {
        System.out.println("do something");
    }
}
