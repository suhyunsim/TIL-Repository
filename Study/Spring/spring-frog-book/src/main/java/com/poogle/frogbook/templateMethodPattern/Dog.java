package com.poogle.frogbook.templateMethodPattern;

public class Dog extends Animal {

    @Override
    void play() {
        System.out.println("멍");
    }

    @Override
    void runSomething() {
        System.out.println("멍 꼬리");
    }
}
