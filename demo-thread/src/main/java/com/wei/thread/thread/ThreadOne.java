package com.wei.thread.thread;

/**
 * @Author weiyongjian
 * @Description //TODO
 * @Date
 */
public class ThreadOne implements Runnable {

    @Override
    public void run() {
        for(int i =0;i<10;i++){
            System.out.println(ThreadTwo.currentThread().getName()+";"+i);
        }

    }
}
