package com.wei.thread.thread;

import java.util.concurrent.Callable;

/**
 * @Author weiyongjian
 * @Description //TODO
 * @Date
 */
public class ThreadThree implements Callable {

    @Override
    public String call() throws Exception {
        for(int i =0;i<10;i++){
            System.out.println(ThreadTwo.currentThread().getName()+";"+i);
        }
        return "Test";
    }
}
