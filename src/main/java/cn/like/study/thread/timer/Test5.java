package cn.like.study.thread.timer;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @program: MyCode
 * @description:
 * @author: like
 * @create: 2018-06-05 23:48
 **/
public class Test5 {
    static class MyTask extends TimerTask {
        public void run() {
            try {
                System.out.println("begin time=" + System.currentTimeMillis());
                Thread.sleep(1000);
                System.out.println("  end time=" + System.currentTimeMillis());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        MyTask task = new MyTask();
        Calendar calendar = Calendar.getInstance();
        Date runDate = calendar.getTime();
        System.out.println("当前时间：" + System.currentTimeMillis());
        Timer timer = new Timer();
        //timer.schedule(task, runDate, 3000);
        timer.scheduleAtFixedRate(task, runDate, 3000);
    }
}
