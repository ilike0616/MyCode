package cn.like.study.designPattern.memento.multiState;

/**
 * @program: MyCode
 * @description: 备忘录管理员角色
 * @author: like
 * @create: 2018-10-12 16:35
 **/
public class Caretaker {
    //备忘录对象
    private Memento memento;

    public Memento getMemento() {
        return memento;
    }

    public void setMemento(Memento memento) {
        this.memento = memento;
    }
}
