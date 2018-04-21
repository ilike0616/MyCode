package cn.like.study.designPattern.abstractFactory;

/**
 * @program: MyCode
 * @description: 接口Color的实现类
 * @author: like
 * @create: 2018-04-21 09:44
 **/
public class Green implements Color {

    @Override
    public void fill() {
        System.out.println("Inside Green::fill() method.");
    }
}
