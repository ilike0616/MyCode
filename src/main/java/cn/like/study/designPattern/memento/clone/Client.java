package cn.like.study.designPattern.memento.clone;


/**
 * @program: MyCode
 * @description: 场景类
 * @author: like
 * @create: 2018-10-12 16:33
 **/
public class Client {
    public static void main(String[] args) {
        //定义出发起人
        Originator originator = new Originator();
        originator.setState("初始状态。。。");
        System.out.println("初始状态是：" + originator.getState());
        //建立备份
        originator.createMemento();
        //修改状态
        originator.setState("修改后的状态。。。");
        System.out.println("修改后状态是：" + originator.getState());
        //恢复原有状态
        originator.restoreMemento();
        System.out.println("恢复后状态是：" + originator.getState());
    }
}
