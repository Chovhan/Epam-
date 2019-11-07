//Palindrome : Среди всех чисел типа int найти такие, двоичное представление которых
//является палиндромом (без учета ведущих нулей).

package com.company;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        long startTime = System.nanoTime();
        System.out.println(Integer.toString(238, 2));

        for (int i = -32768; i < 32768; i++){
            String binaryNumber = Integer.toString(i, 2);
            Pattern patern = Pattern.compile("[1]+[0-1]+[1]+(?=[0]+$)");
            Matcher matcher = patern.matcher(binaryNumber);
            if (matcher.find()){
                System.out.println(palindromeCheck(matcher.group(0)));
            }
        }
        System.out.println(System.nanoTime() - startTime);
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
