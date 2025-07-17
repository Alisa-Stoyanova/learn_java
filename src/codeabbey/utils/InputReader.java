package codeabbey.utils;

import java.util.Scanner;

public class InputReader {
    int length;
    String[] inputStrAry;
    Scanner scan;

    public InputReader() {
        this.scan = new Scanner(System.in);
    }

    public int readInt() {
        int amount = Integer.parseInt(scan.nextLine());
        return amount;
    }

    public String[] readStringAry() {
        String inputStr = scan.nextLine();
        inputStrAry = inputStr.split(" ");
        length = inputStrAry.length;
        return inputStrAry;
    }

    public int[] readIntAry() {
        readStringAry();
        int[] inputIntAry = new int[length];
        for (int i = 0; i < length; i++) {
            inputIntAry[i] = Integer.parseInt(inputStrAry[i]);
        }
        return inputIntAry;
    }

    public double[] readDoubleAry() {
        readStringAry();
        double[] inputDoubleAry = new double[length];
        for (int i = 0; i < length; i++) {
            inputDoubleAry[i] = Double.parseDouble(inputStrAry[i]);
        }
        return inputDoubleAry;
    }
}
