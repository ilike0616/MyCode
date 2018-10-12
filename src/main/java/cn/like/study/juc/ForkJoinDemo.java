package cn.like.study.juc;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;

/**
 * @program: MyCode
 * @description: Fork/Join框架示例《Java并发编程的艺术》
 * Fork/Join框架是一个用于并行执行任务的框架，是一个把大人物分割成若干小任务，
 * 最终汇总每个小任务结果后得到大任务结果的框架。
 * 工作窃取算法：为了减少窃取任务线程和被窃取任务线程之间的竞争，使用双端队列，
 * 被窃取任务线程永远从双端队列头部拿任务执行，而窃取任务的线程永远从双端队列的尾部拿任务执行。
 * 实现方式：ForkJoinTask提供在任务中执行fork()和join()操作的机制，通常继承其子类来实现：
 *  RecursiveAction：用于没有返回结果的任务
 *  RecursiveTask：用于有返回结果的任务
 * ForkJoinPool：ForkJoinTask需要通过ForkJoinPool来执行。
 * @author: like
 * @create: 2018-05-04 00:51
 **/
public class ForkJoinDemo extends RecursiveTask<Integer> {
    //阈值
    private static final int THRESHOLD = 2;
    private int start;
    private int end;

    public ForkJoinDemo(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        int sum = 0;
        //如果任务足够小就计算任务
        boolean canCompute = (end - start) <= THRESHOLD;
        if (canCompute) {
            for (int i = start; i <= end; i++) {
                sum += i;
            }
        } else {
            //如果任务大于阈值，就分裂成两个子任务计算
            int middle = (start + end) / 2;
            ForkJoinDemo leftTask = new ForkJoinDemo(start, middle);
            ForkJoinDemo rightTask = new ForkJoinDemo(middle + 1, end);
            //执行子任务
            leftTask.fork();
            rightTask.fork();
            //等待子任务执行完，并得到其结果
            int leftResult = leftTask.join();
            int rightResult = rightTask.join();
            //合并子任务结果
            sum = leftResult + rightResult;
        }
        return sum;
    }

    public static void main(String[] args) {
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        //生产一个计算任务，负责计算1+2+3+4
        ForkJoinDemo task = new ForkJoinDemo(1, 4);
        //执行这个任务
        Future<Integer> result = forkJoinPool.submit(task);
        try {
            System.out.println(result.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
