package com.example.demo.util;

import java.util.Random;

public class NumberUtil {
//    static Random random = new Random();
//
//    public static int getRandomNumber(int min, int max) {
//        return (int) ((Math.random() * (max - min)));
//    }
//    public static void main(String[] args) {
//        for (int i = 0; i < 100; i++) {
//            System.out.println(getRandomNumber(10, 100));
//        }
//    }
    public static int numberRandom (int min, int max){
        Random random = new Random();
        return random.nextInt(max + min) + min ;
    }
}
