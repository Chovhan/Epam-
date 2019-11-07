//Positive numbers: Из двумерного массива целых чисел сформировать новый массив, исключив
//из исходного отрицательные числа. В полученном массиве найти номер
//строки, среднее арифметическое значений в которой максимально. Если
//таких строк несколько, вывести номер первой такой строки.

package com.company;

public class Main {

    public static void main(String[] args) {
        int sumArrayOne = 0;
        int sumArrayTwo = 0;
        int [][] myArray = new int[2][10];
        for (int i = 0; i < 2; i++){
            for (int j = 0; j < 10; j++){
                myArray[i][j] = (int) (Math.random() * 60) - 30;
                System.out.println("Element" + i + ":" + j + " : " + myArray[i][j]);
                if (myArray[i][j] < 0) {
                    myArray[i][j] = 0;
                }
                sumArrayOne += myArray[0][j];
                sumArrayTwo += myArray[1][j];
            }
        }
        if (sumArrayOne > sumArrayTwo){
            System.out.println("Sum of the first string the biggest.");
        } else {
            System.out.println("Sum of the second string the biggest.");
        }
    }
}
