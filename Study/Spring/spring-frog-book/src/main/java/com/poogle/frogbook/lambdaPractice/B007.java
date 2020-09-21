package com.poogle.frogbook.lambdaPractice;

public class B007 {
    public static void main(String[] args) {
        dolt( a -> a * a);
    }

    private static void dolt(MyFunctionalInterface mfi) {
        int b = mfi.runSomething(5);
        System.out.println(b);
    }
}
