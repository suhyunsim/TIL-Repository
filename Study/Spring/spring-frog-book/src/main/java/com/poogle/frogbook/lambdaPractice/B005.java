package com.poogle.frogbook.lambdaPractice;

public class B005 {
    public static void main(String[] args) {
        MyFunctionalInterface mfi = a -> a * a;
        //인자가 하나고 자료형 표기 안 하는 경우 () 생략 가능
        //코드 한 줄이기 때문에 {} 생략 가능
        //int return인거 알아서 생략 가능
        

        int b = mfi.runSomething(5);
        System.out.println(b);
    }
}

@FunctionalInterface //옵션 -> 컴파일러가 함수형 인터페이스의 조건에 맞는지 검사(단 하나의 추상 메서드만을 갖고 있는지 확인)
interface MyFunctionalInterface {
    public abstract int runSomething(int count); //a가 int일 수밖에 없음
}
