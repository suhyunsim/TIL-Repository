package com.poogle.frogbook.templateCallbackPattern;

public class Client {
    public static void main(String[] args) {
        Soldier poogle = new Soldier();
        poogle.runContext("총");

        System.out.println();

        poogle.runContext("칼");

        System.out.println();

        poogle.runContext("도");
    }
}
