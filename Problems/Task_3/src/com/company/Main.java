//Odd number: В одномерном массиве целых чисел найти наибольшее нечетное число.
package com.company;

public class Main {

    public static void main(String[] args) {
        int [] myArray = new int[10];
        for (int i = 0; i < myArray.length; i ++){
            myArray[i] = (int) (Math.random() * (60-20)) + 20;
            System.out.println("Element " + i + " is " + myArray[i]);
            if (myArray[i] % 2 == 0){
                myArray[i] = 0;
            }
        }
        int max = myArray[0];
        for (int i = 1; i < myArray.length; i++) {
            max = Math.max(max, myArray[i]);
        }
        System.out.println("Max int: " + max);
    }
}
