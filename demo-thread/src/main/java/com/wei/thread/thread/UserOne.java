package com.wei.thread.thread;

/**
 * @Author weiyongjian
 * @Description //TODO
 * @Date
 */
public class UserOne implements  Runnable {

    private  IBank bank;

    public UserOne(IBank bank) {
        this.bank = bank;
    }

    public UserOne() {
    }

    @Override
    public void run() {
        for (int i = 0; i <1000 ; i++) {
            this.bank.add();
        }
    }
}
