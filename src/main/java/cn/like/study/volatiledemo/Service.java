package cn.like.study.volatiledemo;

import javax.print.attribute.standard.Severity;

/**
 * @program: MyCode
 * @description:
 * @author: like
 * @create: 2018-05-22 22:16
 **/
public class Service {
    private boolean isContinueRun = true;

    public void runMethod() {
        String anyString = new String();
        while (isContinueRun == true) {
            synchronized (anyString){

            }
        }
        System.out.println("停下来了！");
    }

    public void stopMehtod() {
        isContinueRun = false;
    }

}
