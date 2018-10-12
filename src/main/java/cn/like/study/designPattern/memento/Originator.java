package cn.like.study.designPattern.memento;

/**
 * @program: MyCode
 * @description: 发起人角色
 * @author: like
 * @create: 2018-10-12 16:27
 **/
public class Originator {
    //内部状态
    private String state = "";

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    //创建一个备忘录
    public Memento createMemento() {
        return new Memento(this.state);
    }

    public void restoreMemento(Memento _memento) {
        this.setState(_memento.getState());
    }

}
