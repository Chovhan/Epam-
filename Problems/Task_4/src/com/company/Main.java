package com.company;

import java.util.HashSet;

public class Main {

    public static void main(String[] args) {
        int [] myArrayOne = new int[10];
        int [] myArrayTwo = new int[10];
        HashSet<Integer> myHashSet = new HashSet<Integer>();
        for (int i = 0; i < myArrayOne.length; i++){
            myArrayOne[i] = (int) (Math.random() * (6-2) + 2);
            myArrayTwo[i] = (int) (Math.random() * (6-2) + 2);
            System.out.println("Array one, element " + i + " is " + myArrayOne[i]);
            System.out.println("Array two, element " + i + " is " + myArrayTwo[i] + "\n");
        }
        for (int i = 0; i < myArrayOne.length; i++){
            for (int j = 0; j < myArrayOne.length; j++){
                if (myArrayOne[i] == myArrayTwo[j]){
                    myHashSet.add(myArrayOne[i]);
                }
            }
        }
        System.out.println("The same elements: " + myHashSet);
    }
}
