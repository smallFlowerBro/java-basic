package com.wei.generics;

import java.util.Collection;

/**
 * @Author weiyongjian
 * @Description //TODO
 * @Date
 */
public class GenericsMethod {

    public  static <T> T add(T element, Collection<T> collection){
        collection.add(element);
        return element;
    }
}
