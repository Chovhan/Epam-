//Most common symbols: Строка содержит символы английского алфавита (A…Z и a..z), символ
//“пробел” и знаки препинания. Найти символ, который встречается чаще
//всего (без учета регистра). Если таких символов несколько, вывести любой
//из них.

package com.company;

import java.util.Arrays;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Random rnd = new Random();
        String mySrt = ".,";
        for(char i = 'a';i<='z';i++) {
            mySrt += i;
        }
        for(char i = 'A';i<='Z';i++) {
            mySrt += i;
        }
        int c = (int) (Math.random() * (60-20) + 20);
        for (int i = 0; i < c; i++){
            mySrt += mySrt.charAt(rnd.nextInt(mySrt.length()));
        }
        char[] array = mySrt.toLowerCase().toCharArray();
        Arrays.sort(array);
        int max = 0;
        System.out.println(array);
        String maxChar = "";
        for (int i = 0; i < array.length; i++) {
            int count = 0;
            for (int j = 0; j < array.length; j++) {
                if (array[i] == array[j]){
                    count++;
                    if (count > max){
                        max = count;
                        maxChar = "";
                        maxChar += array[i];
                    }
                } else {
                    count = 0;
                }
            }
        }

        if (max > 1) {
            System.out.println("Char: " + maxChar + ", times: " + max);
        }
    }
}
