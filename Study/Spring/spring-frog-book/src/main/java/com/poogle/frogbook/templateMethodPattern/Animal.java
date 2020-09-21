package com.poogle.frogbook.templateMethodPattern;

public abstract class Animal {
    //템플릿 메서드

    public void playWithOwner() {
        System.out.println("Come on");
        play();
        runSomething();
        System.out.println("Good");
    }
    //추상 메서드
    abstract void play();

    //Hook 메서드
    void runSomething() {
        System.out.println("꼬리");
    }
}
