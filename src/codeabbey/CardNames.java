package codeabbey;

import java.util.ArrayList;
import java.util.Scanner;

public class CardNames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int amount = scanner.nextInt();
        ArrayList<String> cardNames = new ArrayList<>();
        String[] suits = {"Clubs", "Spades", "Diamonds", "Hearts"};
        String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
        for (int i = 0; i < amount; i++) {
            int cardValue = scanner.nextInt();
            int suitValue = cardValue / 13;
            int rankValue = cardValue % 13;
            cardNames.add(ranks[rankValue] + "-of-" + suits[suitValue]);
        }
        for (String cardName : cardNames) {
            System.out.print(cardName + " ");
        }
    }
}