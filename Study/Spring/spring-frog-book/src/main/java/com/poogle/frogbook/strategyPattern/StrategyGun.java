package com.poogle.frogbook.strategyPattern;

public class StrategyGun implements Strategy {
    @Override
    public void runStrategy() {
        System.out.println("탕");
    }
}
