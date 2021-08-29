package com.wei.thread.thread;

/**
 * @Author weiyongjian
 * @Description //TODO
 * @Date
 */
public class BankTwo  implements IBank {
    private  volatile int  balance=0;

    @Override
    public   void add(){
        this.balance+=100;
        this.lookBalance();

    }

    public  void  lookBalance(){
        System.out.println(Thread.currentThread().getName()+ "账户余额："+this.balance);
    }
}
