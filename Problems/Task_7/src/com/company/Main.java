package com.company;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String [][] vineArray = {{"Inglenook Cabernet Sauvignon Napa Valley", "Napa", "1941"},
                {"DRC Romanee Conti", "France", "1943"}, {"Montrachet Domaine de la Romanee Conti", "France", "1978"},
                {"Cheval Blanc", "France", "1947"}, {"Penfolds Grange Hermitage", "Australia", "1951"}};
        Calendar todayDate = new GregorianCalendar();
        int todayYear = todayDate.get(Calendar.YEAR);
        for (int i=0; i<vineArray.length; i++){
            System.out.print((i + 1) + ") ");
            for (int j=0; j<vineArray[i].length; j++){
                System.out.print(vineArray[i][j] + "\t");
            }
            System.out.println("\n");
        }
        Scanner user = new Scanner(System.in);
        while (true){
            try {
                System.out.println("\nChoose the vine (Enter a vine number please): ");
                int vineChoose = user.nextInt();
                if (vineChoose > vineArray.length || vineChoose < 0) {
                    System.out.println("Sorry we don`t have such vine!");
                }
                int vineYear = Integer.parseInt(vineArray[vineChoose-1][2]);
                System.out.println("\nYour vine is: " + "\n" + vineArray[vineChoose-1][0] + ",\t" + vineArray[vineChoose-1][1] + "\nExtract time: " + vineExtract(todayYear, vineYear));
                break;
            }catch (TypeNotPresentException e){
                System.out.println("Enter an integer type");
            }
        }
    }
    private static int vineExtract(int today, int year){
        return today - year;
    }
}
