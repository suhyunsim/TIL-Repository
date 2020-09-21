package com.poogle.frogbook.lambdaPractice;

import java.util.Arrays;

public class B011 {
    public static void main(String[] args) {
        Integer[] ages = {20, 25, 18, 27, 30, 21, 17, 19, 34};

        Arrays.stream(ages)
                .filter(age -> age < 20) // 20세 미만인 경우를 선별(Filter)
                .forEach(age -> System.out.format("Age $d! Can't enter\n", age)); // 선별된 각 요소에 대해 입장 불가
    }
}
