package codeabbey;

import codeabbey.utils.InputReader;
import codeabbey.utils.Printer;
import codeabbey.utils.Rounder;

public class AverageOfArray {
    public static void main(String[] args) {
        InputReader reader = new InputReader();
        int amount = reader.readInt();
        Integer[] result = new Integer[amount];
        for (int i = 0; i < amount; i++) {
            int[] input = reader.readIntAry();
            int length = input.length - 1;
            double sum = 0;
            for (int j = 0; j < length; j++) {
                sum += input[j];
            }
            result[i] = Rounder.round(sum / length);
        }
        Printer.prettyPrint(result);
    }
}
