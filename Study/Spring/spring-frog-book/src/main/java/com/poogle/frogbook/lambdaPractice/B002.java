package com.poogle.frogbook.lambdaPractice;

public class B002 {
    public static void main(String[] args) {
        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello lambda 2");
            }
        };
        r.run();
    }
}
