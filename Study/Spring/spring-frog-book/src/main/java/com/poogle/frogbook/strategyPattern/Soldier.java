package com.poogle.frogbook.strategyPattern;

public class Soldier {
    void runContext(Strategy strategy) {
        System.out.println("start");
        strategy.runStrategy();
        System.out.println("finish");
    }
}
