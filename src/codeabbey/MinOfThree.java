package codeabbey;

import java.util.Scanner;
// import static java.lang.Integer.parseInt;

public class MinOfThree {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String amountString = scan.nextLine();
        int amount = Integer.parseInt(amountString);
        int[] mins = new int[amount];

        for (int i = 0; i < amount; i++) {
            String tripletString = scan.nextLine();
            String[] tripletStrAry = tripletString.split(" ");
            int[] triplet = new int[3];
            for (int j = 0; j < 3; j++) {
                triplet[j] = Integer.parseInt(tripletStrAry[j]);
            }
            int min = triplet[0];
            for (int j = 1; j < 3; j++) {
                if (triplet[j] < min) {
                    min = triplet[j];
                }
            }
            mins[i] = min;
        }
        //System.out.println(Arrays.toString(mins));
        for (int min : mins) {
            System.out.print(min + " ");
        }
    }

}
