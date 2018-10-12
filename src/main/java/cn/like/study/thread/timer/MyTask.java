package cn.like.study.thread.timer;

import java.util.Date;
import java.util.TimerTask;

/**
 * @program: MyCode
 * @description:
 * @author: like
 * @create: 2018-06-05 22:32
 **/
public class MyTask extends TimerTask {
    @Override
    public void run() {
        System.out.println("任务执行了，时间为：" + new Date());
    }
}
