package com.interview.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectSample {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
        Class clazz = Class.forName("com.interview.reflect.Robot");
        Robot robot = (Robot) clazz.newInstance();
        System.out.println(robot.getClass().getName());

        Method throwHello = clazz.getDeclaredMethod("sayHello", String.class);
        throwHello.setAccessible(true);
        System.out.println(throwHello.invoke(robot, "haochuan"));

        Field field = clazz.getDeclaredField("name");
        field.setAccessible(true);
        field.set(robot, "kuanghaochuan");

        Method getName = clazz.getDeclaredMethod("getName");
        getName.setAccessible(true);
        System.out.println(getName.invoke(robot));
    }
}
