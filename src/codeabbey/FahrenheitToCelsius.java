package codeabbey;

import codeabbey.utils.InputReader;
import codeabbey.utils.Rounder;

public class FahrenheitToCelsius {
    static final double CONVERSION_CONST = 100.00 / (212 - 32);

    public static void main(String[] args) {
        InputReader reader = new InputReader();
        int[] inputAry = reader.readIntAry();
        //System.out.print(Arrays.toString(inputAry));
        int length = inputAry.length;
        double[] resultAry = new double[length - 1]; // first number of input is the amount and should not be converted

        for (int i = 1; i < length; i++) {
            // Celsius [0, 100], Fahrenheit [32, 212]
            resultAry[i - 1] = (inputAry[i] - 32) * CONVERSION_CONST; // -32 to normalize so that it starts from 0
        }

        //double test = 5/3;
        //System.out.println("Test" + test);

        for (double result : resultAry) { // change to int after rounding
            System.out.print(Rounder.round(result) + " ");
        }
    }
}
