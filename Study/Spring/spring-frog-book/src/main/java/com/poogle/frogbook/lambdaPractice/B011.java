package com.poogle.frogbook.lambdaPractice;

import java.util.Arrays;

public class B011 {
    public static void main(String[] args) {
        Integer[] ages = {20, 25, 18, 27, 30, 21, 17, 19, 34};

        Arrays.stream(ages).sorted().forEach(System.out::println);

    }
}
