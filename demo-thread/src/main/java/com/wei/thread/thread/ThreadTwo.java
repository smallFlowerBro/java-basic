package com.wei.thread.thread;

/**
 * @Author weiyongjian
 * @Description //TODO
 * @Date
 */
public class ThreadTwo extends  Thread {
    @Override
    public void run() {
        for(int i =0;i<10;i++){
            System.out.println(ThreadTwo.currentThread().getName()+";"+i);
        }
    }
}