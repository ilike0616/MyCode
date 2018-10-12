package cn.like.study.java8;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

/**
 * @program: MyCode
 * @description: Java8新特性：方法引用
 * @author: like
 * @create: 2018-05-04 23:04
 **/
public class MethodReferenceDemo {

    static class Car {
        //构造器引用，它的语法是Class::new，或者更一般的Class< T >::new。注意构造器没有参数
        public static Car create(final Supplier<Car> supplier) {
            return supplier.get();
        }

        //静态方法引用，它的语法是Class::static_method。注意这个方法接受一个Car类型的参数。
        public static void collide(final Car car) {
            System.out.println("Collided " + car.toString());
        }

        //特定类的任意对象的方法引用，它的语法是Class::method。注意这个方法没有参数.
        public void repair() {
            System.out.println("Repaired " + this.toString());
        }

        //特定对象的方法引用，它的语法是instance::method。请注意，这个方法接受一个Car类型的参数。
        public void follow(final Car another) {
            System.out.println("Following the " + another.toString());
        }
    }

    public static void main(String[] args) {
        //构造器引用
        final Car car = Car.create(Car::new);
        final List<Car> cars = Arrays.asList(car);

        //静态方法引用
        cars.forEach(Car::collide);

        //特定类的任意对象的方法引用
        cars.forEach(Car::repair);

        //特定对象的方法引用
        final Car police = Car.create(Car::new);
        cars.forEach(police::follow);
    }
}
