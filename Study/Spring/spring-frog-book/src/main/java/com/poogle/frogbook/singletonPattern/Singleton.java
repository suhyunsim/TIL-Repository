package com.poogle.frogbook.singletonPattern;

public class Singleton {
    //정적 참조 변수
    static Singleton singletonObject;

    //private 생성자
    private Singleton() {
    }

    //객체 반환 정적 메서드
    public static Singleton getInstance() {
        if (singletonObject == null) {
            singletonObject = new Singleton();
        }
        return singletonObject;
    }

}
