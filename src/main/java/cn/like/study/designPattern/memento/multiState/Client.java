package cn.like.study.designPattern.memento.multiState;

/**
 * @program: MyCode
 * @description: 场景类
 * @author: like
 * @create: 2018-10-12 17:39
 **/
public class Client {
    public static void main(String[] args){
        //定义出发起人
        Originator originator = new Originator();
        //定义出备忘录管理员
        Caretaker caretaker = new Caretaker();
        //初始化
        originator.setState1("中国");
        originator.setState2("强盛");
        originator.setState3("繁荣");
        System.out.println("===初始化状态===\n"+originator);
        //创建一个备忘录
        caretaker.setMemento(originator.createMemento());
        //修改状态值
        originator.setState1("软件");
        originator.setState2("结构");
        originator.setState3("优秀");
        System.out.println("===修改后状态===\n"+originator);
        //恢复一个备忘录
        originator.restoreMemento(caretaker.getMemento());
        System.out.println("===恢复后状态===\n"+originator);
    }
}
