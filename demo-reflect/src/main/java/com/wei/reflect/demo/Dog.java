package com.wei.reflect.demo;

import lombok.Data;


/**
 * @Author weiyongjian
 * @Description //TODO
 * @Date
 */
@Data
public class Dog extends Animal implements Run,Swim {
    private int tail;

    public Dog(int eye, int mouth, int ear, int name, int tail) {
        super(eye, mouth, ear, name);
        this.tail = tail;
    }

    public Dog() {
    }

    @Override
    public void eat(String something) {
        System.out.println("I am dog" +this.getName()+ ", I like eat shit");
    }

    public int getTail() {
        return tail;
    }

    public void setTail(int tail) {
        this.tail = tail;
    }

    @Override
    public void run() {
        System.out.println("I am dog" +this.getName()+"I can run");
    }

    @Override
    public void swim() {
        System.out.println("I am dog"+ this.getName()+"I can swim");
    }


}
