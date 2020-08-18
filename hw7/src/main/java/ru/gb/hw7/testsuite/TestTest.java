package ru.gb.hw7.testsuite;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

public class TestTest {

    public static void start(Class c){
        Method beforeSuite = null;
        Method afterSuite = null;

        SortedMap<Integer, Method> testMethods = new TreeMap<>();

        for (Method method : c.getMethods()) {
            if (method.isAnnotationPresent(BeforeSuite.class)) {
                if (beforeSuite != null){
                    throw new RuntimeException("Multiple BeforeSuite annotations in class " + c.getName());
                }else{
                    beforeSuite = method;
                }
            }
            if (method.isAnnotationPresent(AfterSuite.class)) {
                if (afterSuite != null){
                    throw new RuntimeException("Multiple AfterSuite annotations in class " + c.getName());
                }else{
                    afterSuite = method;
                }
            }
            if (method.isAnnotationPresent(Test.class)){
                testMethods.put(method.getAnnotation(Test.class).order(), method);
            }
        }

        try {
            if (beforeSuite != null){
                beforeSuite.invoke(null);
            }
            for(Method m : testMethods.values()){
                m.invoke(null);
            }
            if (afterSuite != null){
                afterSuite.invoke(null);
            }
        }catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    public static void start(String className){
        try{
            start(Class.forName(className));
        }catch (ClassNotFoundException e){
            throw new RuntimeException(e);
        }
    }
}
