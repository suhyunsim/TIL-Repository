package com.poogle.frogbook.strategyPattern;

public class Client {
    public static void main(String[] args) {
        Strategy strategy = null;
        Soldier poogle = new Soldier();

        //총 주기
        strategy = new StrategyGun();
        poogle.runContext(strategy);
        System.out.println();

        //칼 주기
        strategy = new StrategySword();
        poogle.runContext(strategy);
        System.out.println();

        //활 주기
        strategy = new StrategyBow();
        poogle.runContext(strategy);
    }
}
