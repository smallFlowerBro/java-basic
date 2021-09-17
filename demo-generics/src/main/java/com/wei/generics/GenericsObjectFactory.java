package com.wei.generics;

/**
 * @Author weiyongjian
 * @Description //TODO
 * @Date
 */
public class GenericsObjectFactory<T> {
    private Class<T> aClass;

    public GenericsObjectFactory(Class<T> aClass) {
        this.aClass = aClass;
    }

    public T createNewInstance() throws IllegalAccessException, InstantiationException {
        return (T)aClass.newInstance();
    }
    public static  <S> S createNewInstance(Class<S> tClass) throws IllegalAccessException, InstantiationException {
        return (S)tClass.newInstance();
    }
}
