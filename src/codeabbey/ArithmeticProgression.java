package codeabbey;

import java.util.Scanner;

import static codeabbey.utils.Printer.prettyPrint;

public class ArithmeticProgression {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int amount = Integer.parseInt(scan.nextLine());
        Integer[] output = new Integer[amount];
        calcProgression(scan, amount, output);
        prettyPrint(output);
    }

    static void calcProgression(Scanner scan, int amount, Integer[] output) {
        for (int j = 0; j < amount; j++) {
            String inputStr = scan.nextLine();
            String[] inputStrAry = inputStr.split(" ");
            int length = inputStrAry.length;
            int[] inputAry = new int[length];
            for (int i = 0; i < inputAry.length; i++) {
                inputAry[i] = Integer.parseInt(inputStrAry[i]);
            }
            int[] sequence = new int[inputAry[length - 1]];
            sequence[0] = inputAry[0];

            int l = 0;
            while (l < inputAry[length - 1]) {
                sequence[l] = inputAry[0] + inputAry[1] * l;
                l++;
            }

            //System.out.println(Arrays.toString(sequence));

            int sum = 0;
            for (int m = 0; m < sequence.length; m++) {
                sum += sequence[m];
            }
            output[j] = sum;
        }
    }
}