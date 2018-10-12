package cn.like.study.java8;

import java.util.concurrent.BlockingQueue;
import java.util.function.Supplier;

/**
 * Java8接口的新特性：默认方法和静态方法扩展接口的声明
 */
public interface NewFeatureInterface {
    /**
     * 抽象方法要求必须实现，但默认方法并不要求。
     * 实现类默认继承，也可以重写来覆盖这个方法。
     * 在JVM中，默认方法的实现是非常高效的，并且通过字节码指令为方法调用提供了支持。
     * 默认方法允许继续使用现有的Java接口，而同时能够保障正常的编译过程。
     * 这方面好的例子是大量的方法被添加到java.util.Collection接口中去：stream()，parallelStream()，forEach()，removeIf()，……
     *
     * 尽管默认方法非常强大，但是在使用默认方法时我们需要小心注意一个地方：
     * 在声明一个默认方法前，请仔细思考是不是真的有必要使用默认方法，因为默认方法会带给程序歧义，
     * 并且在复杂的继承体系中容易产生编译错误。更多详情请参考官方文档
     * @return
     */
    default String notRequired() {
        return "Default implementation";
    }

    /**
     * 接口可以声明静态方法，并且可以提供实现
     * @param supplier
     * @return
     */
    static BlockingQueue create(Supplier<BlockingQueue> supplier) {
        return supplier.get();
    }
}
