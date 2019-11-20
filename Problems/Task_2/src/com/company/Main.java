//Palindrome : Среди всех чисел типа int найти такие, двоичное представление которых
//является палиндромом (без учета ведущих нулей).

package com.company;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        double startTime = System.nanoTime();
        int count = 0;
        for (int i = -1000000; i < 1000000; i++){
            String binaryNumber = Integer.toString(i, 2);
            Pattern patern = Pattern.compile("[1]+[0-1]+[1]+(?=[0]*$)");
            Matcher matcher = patern.matcher(binaryNumber);
            if (matcher.find()){
                count++;
                boolean w = palindromeCheck(matcher.group(0));
                if (w==true) {
                    System.out.println(binaryNumber);
                }
            }
        }
        System.out.println(count);
        System.out.println("Time: " + ((System.nanoTime() - startTime) / 1000000000) + " seconds");
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
