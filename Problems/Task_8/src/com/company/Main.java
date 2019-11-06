package com.company;

import java.util.Scanner;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        String[] flowerName = {"Rose", "Tulips", "Daisies", "Lilies"};
        int[] flowerPrice = {5, 3, 4, 2};
        int[] flowerCol = {20, 20, 20, 20};
        ArrayList<String> flowerNameOrder = new ArrayList<>();
        int orderCurrentPrice = 0;
        int orderPrice;
        System.out.println("We have such flower:");
        for (int i = 0; i < flowerName.length; i++){
            System.out.println(flowerName[i]);
        }

        while (true){
            try {
                Scanner user = new Scanner(System.in);
                System.out.println("Enter the price of your future order: ");
                orderPrice = user.nextInt();
                break;
            }catch (TypeNotPresentException e){
                System.out.println("Wrong type! Please enter integer number!");
            }
        }
        int count = 0;

        while (true) {
            Scanner user3 = new Scanner(System.in);
            System.out.println("\nIf you want to end adding flowers to your order, enter 0, if you want to continue work enter anything else: ");
            String ending = user3.nextLine();
            if (ending.equals("0") && flowerNameOrder.size() % 2 != 0){
                System.out.println("Your order is: ");
                for (int i=0; i<flowerNameOrder.size(); i++){
                    System.out.println((i+1) + ") " + flowerNameOrder.get(i));
                }
                while (orderCurrentPrice > orderPrice){
                    System.out.println("Sorry but current price is bigger then you want to pay: (1)If you want we can " +
                            "delete flower from your order, (2)or you can increase the order price:");
                    Scanner user4 = new Scanner(System.in);
                    String choose = user4.nextLine();
                    if (choose.equals("1")){
                        String last = flowerNameOrder.get(flowerNameOrder.size()-1);
                        for (int i = 0; i < flowerName.length; i++){
                            if (flowerName[i].equals(last)){
                                orderCurrentPrice -= flowerPrice[i];
                                flowerNameOrder.remove(flowerNameOrder.indexOf(last));
                            }
                        }
                    }else if (choose.equals("2")){
                        Scanner user5 = new Scanner(System.in);
                        System.out.println("Enter the new price of your order: ");
                        orderPrice = user5.nextInt();
                        while (orderCurrentPrice > orderPrice){
                            Scanner user6 = new Scanner(System.in);
                            System.out.println("Enter the new price of your order: ");
                            orderPrice = user6.nextInt();
                        }
                    }
                }
                break;
            } else if (flowerNameOrder.size() % 2 == 0 && count > 0){
                System.out.println("You can not quit because the col of your flowers in bouquet is even!");
            }
            Scanner user2 = new Scanner(System.in);
            System.out.println("Enter the name of flowers that tou want to add for order: ");
            String orderFlower = user2.nextLine();
            for (int i = 0; i < flowerName.length; i++){
                if (flowerName[i].equals(orderFlower)){
                    if (flowerCol[i] != 0){
                        flowerNameOrder.add(orderFlower);
                        orderCurrentPrice += flowerPrice[i];
                        flowerCol[i] -= 1;
                        break;
                    }
                }else if (!flowerName[i].equals(orderFlower)){
                    System.out.println("We don`t have such flowers!");

                }
            }
            count += 1;
        }
        System.out.println("\nCurrent order price is: " + orderCurrentPrice);
        print(flowerNameOrder);
        System.out.println("Bye");
    }

    private static void print(ArrayList len){
        System.out.println("Your current order: ");
        for (int i = 0; i<len.size();i++){
            System.out.println(i + ") " + len.get(i));
        }
    }
}
