package cn.like.utils;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

/**
 * Class工具类
 */
public class ClassUtils {
    /**
     * 根据父类获得子类
     * 谨慎使用，在核心的应用中尽量不要使用，它会严重影响性能
     * @param fatherClass
     * @return
     */
    public static List<Class> getSonClass(Class fatherClass){
        //定义一个返回值
        List<Class> returnClassList = new ArrayList<Class>();
        //获得包名称
        String packageName = fatherClass.getPackage().getName();
        //获得包中的所有类
        List<Class> packClasses = getClasses(packageName);
        //判断是否是子类
        for (Class c : packClasses){
            if(fatherClass.isAssignableFrom(c) && !fatherClass.equals(c)){
                returnClassList.add(c);
            }
        }
        return returnClassList;
    }

    //从一个包中查找出所有的类，在jar包中不能查找
    private static List<Class> getClasses(String packageName){
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        String path = packageName.replace('.', '/');
        Enumeration<URL> resources = null;
        try {
            resources = classLoader.getResources(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<File> dirs = new ArrayList<File>();
        while (resources.hasMoreElements()){
            URL resource = resources.nextElement();
            dirs.add(new File(resource.getFile()));
        }
        ArrayList<Class> classes = new ArrayList<Class>();
        for (File directory : dirs){
            classes.addAll(findClassess(directory,packageName));
        }
        return classes;
    }

    private static List<Class> findClassess(File directory, String packageName){
        List<Class> classess = new ArrayList<Class>();
        if(!directory.exists()){
            return classess;
        }
        File[] files = directory.listFiles();
        for (File file : files){
            if(file.isDirectory()){
                assert !file.getName().contains(".");
                classess.addAll(findClassess(file,packageName+"."+file.getName()));
            } else if (file.getName().endsWith(".class")){
                try {
                    classess.add(Class.forName(packageName+"."+file.getName().substring(0,file.getName().length()-6)));
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }
        return classess;
    }
}
