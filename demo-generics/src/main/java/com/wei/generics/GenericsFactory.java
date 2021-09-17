package com.wei.generics;

/**
 * @Author weiyongjian
 * @Description //TODO
 * @Date
 */
public class GenericsFactory<T> {
    private  Class aClass;

    public GenericsFactory(Class aClass) {
        this.aClass = aClass;
    }

    public T createInstance() throws IllegalAccessException, InstantiationException {
        return (T) aClass.newInstance();
    }
}
