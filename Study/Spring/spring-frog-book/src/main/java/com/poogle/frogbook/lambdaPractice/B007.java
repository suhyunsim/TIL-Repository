package com.poogle.frogbook.lambdaPractice;

public class B007 {
    public static void main(String[] args) {
        MyFunctionalInterface mfi = todo();

        int result = mfi.runSomething(3);
        System.out.println(result);
    }

    private static MyFunctionalInterface todo() {
        return num -> num * num;
    }
}
