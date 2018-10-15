package cn.like.study.spring.factory;

import cn.like.study.spring.bean.UserService;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

import java.io.File;

public class FactoryTest {

    public void getPath(){
        File f = new File(this.getClass().getResource("/").getPath());
        System.out.println("getPath():"+f);
    }

    public void testSimpleLoad(){
        BeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("spring/application-context.xml"));
        UserService userService = (UserService)beanFactory.getBean("userService");
    }

    public void classPath(){
        ApplicationContext context = new ClassPathXmlApplicationContext("spring/application-context.xml");
        UserService userService = (UserService) context.getBean("userService");
        userService.update();
    }

    public void fileSystem(){
        ApplicationContext context = new FileSystemXmlApplicationContext("target/classes/spring/application-context.xml");
        UserService userService = (UserService) context.getBean("userService");
        userService.update();
    }

    public static void main(String[] args){
        FactoryTest factoryTest = new FactoryTest();
        //factoryTest.getPath();
        factoryTest.classPath();
//        factoryTest.fileSystem();
    }
}
