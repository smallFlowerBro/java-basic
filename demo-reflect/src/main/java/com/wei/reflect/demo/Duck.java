package com.wei.reflect.demo;

import com.oracle.webservices.internal.api.databinding.DatabindingMode;
import lombok.Data;

/**
 * @Author weiyongjian
 * @Description //TODO
 * @Date
 */
@Data
public class Duck  extends Animal implements Fly,Swim{
    private  int wing;

    public Duck(int eye, int mouth, int ear, int name, int wing) {
        super(eye, mouth, ear, name);
        this.wing = wing;
    }

    public Duck() {
    }

    @Override
    public void eat(String something) {
        System.out.println("I am duck"+this.getName()+"I like eating fish");
    }

    public int getWing() {
        return wing;
    }

    public void setWing(int wing) {
        this.wing = wing;
    }

    @Override
    public void fly() {
        System.out.println("I am duck"+this.getName()+"I can fly");
    }

    @Override
    public void swim() {
        System.out.println("I am duck"+this.getName()+"I can swim");
    }

}
