package com.wei.proxy.cglibproxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import java.lang.reflect.Method;

/**
 * @Author weiyongjian
 * @Description //TODO
 * @Date
 */
public class CglibProxy implements MethodInterceptor {
    private  Object targer;

    public CglibProxy(Object targer) {
        this.targer = targer;
    }

    public CglibProxy() {
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println(method.getName()+" 执行前");
        Object invoke = methodProxy.invoke(targer, objects);
        System.out.println(method.getName()+" 执行后");
        return invoke;
    }
    public Object getProxy(){

        Enhancer enhancer = new Enhancer();
        enhancer.setCallback(this);
        enhancer.setSuperclass(targer.getClass());
        System.out.println("生成成功");
        return enhancer.create();

    }

}
