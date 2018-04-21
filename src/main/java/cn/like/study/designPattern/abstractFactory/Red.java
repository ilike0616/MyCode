package cn.like.study.designPattern.abstractFactory;

/**
 * @program: MyCode
 * @description: 接口Color的实现类
 * @author: like
 * @create: 2018-04-21 09:43
 **/
public class Red implements Color {
    @Override
    public void fill() {
        System.out.println("Inside Red::fill() method.");
    }
}
