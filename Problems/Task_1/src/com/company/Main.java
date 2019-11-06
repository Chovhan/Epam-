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
