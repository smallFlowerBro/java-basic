package com.wei.proxy.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Author weiyongjian
 * @Description //TODO
 * @Date
 */
public class MyProxy<T> {
    private T target;

    public MyProxy(T object) {
        this.target = object;
    }

    public MyProxy() {
    }

    public T getProxy(){
        T o = (T) Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println(method.getName() + " 执行前");
                Object return_value = method.invoke(target, args);
                System.out.println(method.getName() + " 执行后");
                return return_value;
            }
        });
        return  o;
    }


}
