package com.wei.thread.thread;

/**
 * @Author weiyongjian
 * @Description //TODO
 * @Date
 */
public class Platform  implements  Runnable{
    private  Ticket ticket;

    private String name;

    public Platform(Ticket ticket, String name) {
        this.ticket = ticket;
        this.name = name;
    }

    public Platform() {
    }


    @Override
    public void run() {
        for (int i = 0; i <200 ; i++) {
            if(i%2==0){
                if(this.ticket.sell()){
                    System.out.println("车站："+this.name+",售出了一张车票");
                }else{
                    System.out.println("车站"+this.name+",车票不足无法售出");
                }
            }else{
                if(this.ticket.back()){
                    System.out.println("车站："+this.name+",退回了一张车票");
                }else{
                    System.out.println("车站："+this.name+",退回失败");
                }
            }
        }
    }
}
