package com.wei.thread.thread;

/**
 * @Author weiyongjian
 * @Description //TODO
 * @Date
 */
public class Ticket {
    private  volatile static   int total=0;
    private  volatile static   int left_num=0;

    public Ticket(int total) {
        Ticket.total = total;
        Ticket.left_num = total;
    }

    public Ticket() {
    }

    public  boolean  sell(){
        this.lookLeft();
        if(left_num>0){
             left_num--;

             return true;
        }
        return false;
    }
    public  boolean  back(){
        this.lookLeft();
        if(left_num<total){
            left_num++;
            return true;
        }
        return  false;
    }
    public void lookLeft(){
        System.out.println("当前余票："+left_num);
    }

}
