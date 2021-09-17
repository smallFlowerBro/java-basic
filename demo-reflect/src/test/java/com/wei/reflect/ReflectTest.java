package com.wei.reflect;

import com.wei.reflect.demo.Duck;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Author weiyongjian
 * @Description //TODO
 * @Date
 */
public class ReflectTest {
    @Test
    public void  test() throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Class<?>[] interfaces = Duck.class.getInterfaces();

        Method[] methods = Duck.class.getMethods();
        for (Method method : methods) {
            if("swim".equals(method.getName())){
                method.invoke(Duck.class.newInstance(),  new Field[]{});
            }
        }
    }
}
