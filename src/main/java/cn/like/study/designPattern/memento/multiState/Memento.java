package cn.like.study.designPattern.memento.multiState;

import java.util.HashMap;

/**
 * @program: MyCode
 * @description: 备忘录角色
 * @author: like
 * @create: 2018-10-12 16:29
 **/
public class Memento {
    //接受HashMap作为状态
    private HashMap<String, Object> stateMap;

    //构造函数传递参数
    public Memento(HashMap<String, Object> map) {
        this.stateMap = map;
    }

    public HashMap<String, Object> getStateMap() {
        return stateMap;
    }

    public void setStateMap(HashMap<String, Object> stateMap) {
        this.stateMap = stateMap;
    }
}
