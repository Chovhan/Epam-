// Letter: Написать программу игры в угадывание букв.
//Пользователь должен угадать загаданную программой латинскую букву
//вводя свой вариант буквы с клавиатуры.
//Если пользователь угадал букву, программа выводит сообщение о выигрыше
//и количестве попыток пользователя.
//Если буква не угадана, программа предлагает ввести другую букву. При этом
//программа выводит подсказки. Если пользователь ввел букву меньше
//загаданной – вывести сообщение об этом (например, «Too low!»).
//Аналогично при вводе буквы больше загаданной (например, «Too high!»).
//Если введена не латинская буква – предложить пользователю внимательно
//ознакомиться с правилами игры.
//Программа должна быть не чувствительна к регистру введенной
//пользователем буквы. Например, при загаданной букве ‘G’ ответы
//пользователя ‘G’ или ‘g’ в равной степени считаются правильными.
//Игра продолжается до выигрыша пользователя.

package com.company;

import java.util.Scanner;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Random rnd = new Random();
        Scanner user = new Scanner(System.in);

        String dictionary = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        char hiddenLetter = dictionary.charAt(rnd.nextInt(dictionary.length()));

        while (true) {
            try {
                System.out.println("Enter a letter: ");
                String userStr = user.nextLine().toUpperCase();
                if (userStr.charAt(0) == hiddenLetter){
                    System.out.println("Congratulations!");
                    break;
                } else if (dictionary.indexOf(userStr) < dictionary.indexOf(hiddenLetter)){
                    System.out.println("To low!");
                } else if (dictionary.indexOf(userStr) > dictionary.indexOf(hiddenLetter)){
                    System.out.println("To hight!");
                }
            } catch (TypeNotPresentException e) {
                System.out.println("Wrong type! Try one more time");
            }
        }
    }
}
