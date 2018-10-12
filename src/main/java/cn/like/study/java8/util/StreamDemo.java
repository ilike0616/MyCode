package cn.like.study.java8.util;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @program: MyCode
 * @description: Java8类库新增类：Stream
 * 处理集合框架，并能够原生支持并行处理。
 * @author: like
 * @create: 2018-05-05 15:07
 **/
public class StreamDemo {
    private enum Status {
        OPEN, CLOSED
    }

    private static final class Task {
        private final Status status;
        private final Integer points;

        Task(final Status status, final Integer points) {
            this.status = status;
            this.points = points;
        }

        public Status getStatus() {
            return status;
        }

        public Integer getPoints() {
            return points;
        }

        public String toString() {
            return String.format("[%s, %d]", status, points);
        }
    }

    public static void main(String[] args) {
        final Collection<Task> tasks = Arrays.asList(
                new Task(Status.OPEN, 5),
                new Task(Status.OPEN, 13),
                new Task(Status.CLOSED, 8)
        );
        //所有状态为OPEN的任务一共有多少分数？
        //在Java 8以前，一般的解决方式用foreach循环,
        //但是在Java 8里面我们可以使用stream：一串支持连续、并行聚集操作的元素。
        final long totalPointsOfOpenTasks = tasks
                .stream()  //task集合被转换化为其相应的stream表示
                .filter(task -> task.getStatus() == Status.OPEN)    //过滤掉状态为CLOSED的task
                .mapToInt(Task::getPoints)  //调用每个task实例的getPoints方法把Task的stream转化为Integer的stream。
                .sum();
        System.out.println("Total points (open tasks): " + totalPointsOfOpenTasks);

        //并行计算所有任务的分数
        final Integer totalPoints = tasks
                .stream()
                .parallel()             //并行
                .map(task -> task.getPoints())  //// or map( Task::getPoints )
                .reduce(0, Integer::sum);
        System.out.println("Total points (all tasks): " + totalPoints);

        final Map<Status, List<Task>> map = tasks
                .stream()
                .collect(Collectors.groupingBy(Task::getStatus));
        System.out.println(map);

        final Collection<String> result = tasks
                .stream()                                       // Stream< String >
                .mapToInt(Task::getPoints)                      // IntStream
                .asLongStream()                                 // LongStream
                .mapToDouble(point -> point / totalPoints)      // DoubleStream
                .boxed()                                        // Stream< Double >
                .mapToLong(weight -> (long) (weight * 100))     // LongStream
                .mapToObj(percentage -> percentage + "%")       // Stream< String>
                .collect(Collectors.toList());                  // List< String >

        final Path path = new File("/Users/ilike/personal/身份证.jpg").toPath();

        //对一个stream对象调用onClose方法会返回一个在原有功能基础上新增了关闭功能的stream对象，
        // 当对stream对象调用close()方法时，与关闭相关的处理器就会执行。
        try {
            Stream<String> lines = Files.lines(path, StandardCharsets.UTF_8);
            lines.onClose(() -> System.out.println("Done!")).forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }


}
