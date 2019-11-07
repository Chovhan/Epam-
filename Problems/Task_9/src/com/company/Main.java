// 21: Написать программу карточной игры в 21.

package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Random rnd = new Random();
        ArrayList<String> deck = new ArrayList<>();
        deck.addAll(Arrays.asList("A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "K", "D", "V"));
        ArrayList<String> sessionDeck = createDeck(deck);
        int bankFond = 1000;
        int userCash = 1000;
        deckScribble(sessionDeck);

        ArrayList<String> userCardDeck = new ArrayList<>();
        userCardDeck.add(sessionDeck.get(0));
        deleteCard(sessionDeck, 0);
        ArrayList<String> computerCardDeck = new ArrayList<>();
        computerCardDeck.add(sessionDeck.get(0));
        deleteCard(sessionDeck, 0);

        int userCardWeight;
        int computerCardWeight;

        int rate = giveRate();
        while (true){
            try {
                System.out.println("Computer cards: ");
                deckScribble(computerCardDeck);
                System.out.println("Your cards: " + "\n" + userCardDeck);
                if (sessionDeck.size() == 2 || sessionDeck.size() == 0){
                    System.out.println("Game is over!");
                    break;
                }
                System.out.println("Enter Y, if you want to add one more card, if not - N: ");
                Scanner user = new Scanner(System.in);
                String newCard = user.nextLine().toUpperCase();
                if (newCard.equals("Y")){
                    userCardDeck.add(giveCard(sessionDeck));
                    deleteCard(sessionDeck, (sessionDeck.size()-1));
                    computerCardDeck.add(giveCard(sessionDeck));
                    deleteCard(sessionDeck, (sessionDeck.size()-1));
                    deckScribble(sessionDeck);

                }else if (newCard.equals("N")) {
                    userCardWeight = counting(userCardDeck, deck);
                    computerCardWeight = counting(computerCardDeck, deck);
                    if (userCardWeight > 21){
                        userCash -= (50+rate);
                        bankFond += (50+rate);
                        System.out.println("You loose! Weight of your cards is bigger then 21! Now your cash " +
                                "is: " + userCash + "\n" + "Computer cards is: " + computerCardDeck);
                    }else if (computerCardWeight > 21){
                        userCash += (50+rate);
                        bankFond -= (50+rate);
                        System.out.println("You win! Weight of computer`s cards is bigger then 21! Now your " +
                                "cash is: " + userCash + "\n" + "Computer cards is: " + computerCardDeck);
                    }else if (userCardWeight > computerCardWeight){
                        userCash += (50+rate);
                        bankFond -= (50+rate);
                        System.out.println("You win! Weight of your`s cards is bigger then computer`s! Now your " +
                                "cash is: " + userCash + "\n" + "Computer cards is: " + computerCardDeck);
                    }else if (userCardWeight < computerCardWeight){
                        userCash -= (50+rate);
                        bankFond += (50+rate);
                        System.out.println("You loose! Weight of computer`s cards is bigger then yours! Now your " +
                                "cash is: " + userCash + "\n" + "Computer cards is: " + computerCardDeck);
                    }
                    String nGame = newGame().toUpperCase();
                    if (nGame.equals("Y\n")){
                        main(null);
                    }else if (nGame.equals("N")){
                        System.exit(0);
                    }
                }
            }catch (TypeNotPresentException e){
                System.out.println("Type error!");
            }
        }
    }

    private static ArrayList createDeck(ArrayList deck){
        Random rnd = new Random();
        ArrayList<String> cardDeck = new ArrayList<>();
        for (int i = 0; i < 36; i++) {
            String num = deck.get(rnd.nextInt(deck.size())).toString();
            cardDeck.add(num);
        }
        return cardDeck;
    }

    private static void deckScribble(ArrayList sDeck){
        ArrayList<String> timeArray = new ArrayList<>();
        for (int i = 0; i < sDeck.size(); i++){
            String cardOut = sDeck.get(i).toString();
            cardOut = "*";
            timeArray.add(cardOut);
        }
        timeArray.set(0, sDeck.get(0).toString());
        System.out.println(timeArray);
    }


    private static String giveCard(ArrayList sDeck){ ;
        String card = sDeck.get(sDeck.size()-1).toString();
        return card;
    }

    private static ArrayList deleteCard(ArrayList sDeck, int cardIndex){
        sDeck.remove(cardIndex);
        return sDeck;
    }

    private static int counting(ArrayList uDeck,  ArrayList deck){
        int count = 0;
        int weight;
        for (int i = 0; i < uDeck.size(); i++){
            String card = uDeck.get(i).toString();
            if (card.equals("V") || card.equals("D") || card.equals("K")){
                weight = deck.size() - (deck.indexOf(card)-1);
            } else{
                weight = deck.indexOf(card) + 1;
            }
            count += weight;
        }
        return count;
    }

    private static int giveRate(){
        Scanner user = new Scanner(System.in);
        int rate;
        while (true){
            try {
                System.out.println("Default rate is 50, if you want you can raise the bit: ");
                rate = user.nextInt();
                if (rate > 950){
                    System.out.println("Max rate is 950!");
                }else if (rate <= 950){
                    break;
                }
            }catch (TypeNotPresentException e){
                System.out.println("Please enter number!");
            }
        }
        return rate;
    }

    private static String newGame(){
        Scanner user = new Scanner(System.in);
        String choose;
        while (true){
            try {
                System.out.println("If you want to start new game, enter - Y, if no - N: ");
                choose = user.nextLine();
                break;
            }catch (TypeNotPresentException e){
                System.out.println("Please stick the rules!");
            }
        }
        return choose;
    }
}
