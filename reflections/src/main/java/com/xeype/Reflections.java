package com.xeype;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Reflections {

    public static void main(String[] args) {
        Person person = new Person();

        person.setName("This is person Name");
        System.out.println("person = " + person);

        Class<?> personClass = person.getClass();
        Field[] declaredFields = personClass.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            if (declaredField.getType().isAssignableFrom(String.class)) {
                if (declaredField.getName().equals("name")) {
                    try {
                        declaredField.setAccessible(true);
                        Object name = declaredField.get(person);
                        String nameValue = name.toString();
                        System.out.println(nameValue);
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        Method[] declaredMethods = personClass.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            if (declaredMethod.getName().equals("run")) {
                System.out.println("declaredMethod = " + declaredMethod);
                declaredMethod.setAccessible(true);
                try {
                    declaredMethod.invoke(person);
                } catch (IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }

        System.out.println("person = " + person);

    }
}