package cn.like.study.designPattern.memento.clone;

import cn.like.study.designPattern.memento.Memento;
import org.apache.tools.ant.taskdefs.condition.Or;

/**
 * @program: MyCode
 * @description: 发起人角色
 * @author: like
 * @create: 2018-10-12 16:27
 **/
public class Originator implements Cloneable {
    private Originator backup;
    //内部状态
    private String state = "";

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    //创建一个备忘录
    public Originator createMemento() {
        return this.backup = this.clone();
    }

    //恢复一个备忘录
    public void restoreMemento() {
        //在进行恢复前应该进行断言，防止空指针
        this.setState(this.backup.getState());
    }

    //克隆当前对象
    @Override
    protected Originator clone() {
        try {
            return (Originator) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }

}
