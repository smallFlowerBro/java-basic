package com.wei.thread.thread;

/**
 * @Author weiyongjian
 * @Description //TODO
 * @Date
 */
public class UserTwo implements  Runnable {

    private  IBank bank;

    public UserTwo(IBank bank) {
        this.bank = bank;
    }

    public UserTwo() {
    }

    @Override
    public void run() {
        for (int i = 0; i <1000 ; i++) {
            this.bank.add();
        }
    }
}
