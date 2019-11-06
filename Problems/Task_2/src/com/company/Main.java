package com.company;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        long start = Runtime.getRuntime().freeMemory();
        int myInt = (int) (Math.random() * (250-50) + 50);
        System.out.println("Integer is: " + myInt);
        String binaryNumber = Integer.toString(myInt, 2);
        System.out.println("Binary number " + binaryNumber);
        System.out.println(palindromeCheck(binaryNumber));
        long end = Runtime.getRuntime().freeMemory();
        System.out.println("Memory: " + (start - end));
    }
    private static boolean palindromeCheck(String binaryNumber){
        int binaryLength = binaryNumber.length();
        for (int i = 0; i < (binaryLength); ++i){
            if (binaryNumber.charAt(i) != binaryNumber.charAt(binaryLength-i-1)) {
                return false;
            }
        }
        return true;
    }
}
