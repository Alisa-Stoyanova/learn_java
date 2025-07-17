package codeabbey;

import java.util.ArrayList;
import java.util.Scanner;

public class SumOfDigits {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int amount = Integer.parseInt(scan.nextLine());
        int[] sums = new int[amount];
        for (int i = 0; i < amount; i++) {
            String inputStr = scan.nextLine();
            String[] inputStrAry = inputStr.split(" ");
            int length = inputStrAry.length;
            int[] inputAry = new int[length];
            for (int j = 0; j < length; j++) {
                inputAry[j] = Integer.parseInt(inputStrAry[j]);
            }
            ArrayList<Integer> numberDecomp = new ArrayList<Integer>();
            int dividend = inputAry[0] * inputAry[1] + inputAry[2];
            //System.out.println(dividend);
            while (dividend != 0) {
                numberDecomp.add(0, dividend % 10); // sodass die Reihenfolge bleibt
                dividend = (int) (dividend / 10);
            }
            //System.out.println(numberDecomp);

            for (int number : numberDecomp) {
                sums[i] += number;
            }
        }

        for (int sum : sums) {
            System.out.print(sum + " ");
        }
    }
}