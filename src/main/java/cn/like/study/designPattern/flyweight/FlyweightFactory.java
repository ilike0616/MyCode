package cn.like.study.designPattern.flyweight;

import java.util.HashMap;

/**
 * @author like
 * @Title: FlyweightFactory
 * @ProjectName MyCode
 * @Description: 享元工厂
 * 享元模式的使用场景：
 * 1.系统中存在大量的相似对象
 * 2.细粒度的对象都具备较接近的外部状态，而且内部状态与环境无关，也就是说对象没有特定身份。
 * 3.需要缓冲池的场景
 * 注意事项：线程安全问题
 * @date 2018/10/1617:40
 */
public class FlyweightFactory {
    //定义一个池容器
    private static HashMap<String,Flyweight> pool = new HashMap<String,Flyweight>();
    //享元工厂
    public static Flyweight getFlyweight(String extrinsic){
        //需要返回的对象
        Flyweight flyweight = null;
        //在池中有该对象
        if(pool.containsKey(extrinsic)){
            flyweight = pool.get(extrinsic);
        }else {
            //根据外部状态创建享元对象
            flyweight = new ConcreteFlyweight(extrinsic);
            //放置到池中
            pool.put(extrinsic,flyweight);
        }
        return flyweight;
    }
}
