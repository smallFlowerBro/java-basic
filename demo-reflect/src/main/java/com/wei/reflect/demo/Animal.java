package com.wei.reflect.demo;

/**
 * @Author weiyongjian
 * @Description //TODO
 * @Date
 */
public abstract class Animal {
    private  int eye;
    private  int mouth;
    private  int ear;
    private  int name;

    public Animal(int eye, int mouth, int ear, int name) {
        this.eye = eye;
        this.mouth = mouth;
        this.ear = ear;
        this.name = name;
    }

    public Animal() {
    }

    public int getName() {
        return name;
    }

    public void setName(int name) {
        this.name = name;
    }

    public int getEye() {
        return eye;
    }

    public void setEye(int eye) {
        this.eye = eye;
    }

    public int getMouth() {
        return mouth;
    }

    public void setMouth(int mouth) {
        this.mouth = mouth;
    }

    public int getEar() {
        return ear;
    }

    public void setEar(int ear) {
        this.ear = ear;
    }

    public abstract void eat(String something) ;
}
