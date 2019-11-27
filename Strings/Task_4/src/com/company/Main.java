package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        String myString = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has " +
                "been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley " +
                "of type and scrambled it to make a type specimen book. It has survived not only five centuries, but " +
                "also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the " +
                "1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with " +
                "desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.";

        printStartString(myString);
        int wordLen = inputWordLenToReplace();
        String wordToReplace = inputWordToReplace();
        myString = myString.replaceAll(wordToReplace, "qqqq");

        ArrayList myArray = convertStringToArray(myString);
        replaceWords(myArray, wordLen, wordToReplace);
        printResultSting(convertArrayToString(myArray));

    }

    public static int inputWordLenToReplace(){
        int wordLen;
        Scanner scanner = new Scanner(System.in);
        while (true){
            try {
                System.out.println("\nEnter len of word what uou want to replace: ");
                wordLen = scanner.nextInt();
                break;
            }catch (TypeNotPresentException e){
                System.out.println("Unexpected type!");
            }
        }
        return wordLen;
    }

    public static String inputWordToReplace() {
        String wordToReplace;
        Scanner scanner2 = new Scanner(System.in);
        while (true) {
            try {
                System.out.println("Enter a word you want to replace: ");
                wordToReplace = scanner2.nextLine();
                break;
            }catch (TypeNotPresentException e) {
                System.out.println("Unexpected type!");
            }
        }
        return wordToReplace;
    }

    public static ArrayList convertStringToArray(String myStr) {
        String[] array = myStr.split(" ");
        ArrayList arrayWithWords =  new ArrayList(Arrays.asList(array));
        return arrayWithWords;
    }

    public static ArrayList replaceWords(ArrayList myArray, int wordLen, String wordToReplace) {
        for (int i=0;i<myArray.size();i++) {
            if (myArray.get(i).toString().length() == wordLen) {
                myArray.set(i, wordToReplace);
            }
        }
        return myArray;
    }

    public static String convertArrayToString(ArrayList myArray) {
        String s = myArray.toString().replaceAll("[,\\s\\[\\]]", " ");
        return s;
    }

    public static void printStartString(String myStr) {
        System.out.println("\nStart string:\n" + myStr);
    }

    public static void printResultSting(String myStr) {
        System.out.println("\nResult string:\n" + myStr);
    }
}
