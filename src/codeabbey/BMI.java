package codeabbey;

import codeabbey.utils.InputReader;
import codeabbey.utils.Printer;

public class BMI {
    public static void main(String[] args) {
        InputReader reader = new InputReader();
        int amount = reader.readInt();

        String[] results = new String[amount];
        for (int i = 0; i < amount; i++) {
            double[] input = reader.readDoubleAry();
            double BMI = calcBMI(input);
            if (BMI < 18.5) {
                results[i] = "under";
            } else if (BMI >= 18.5 && BMI < 25.0) {
                results[i] = "normal";
            } else if (BMI >= 25.0 && BMI < 30.0) {
                results[i] = "over";
            } else {
                results[i] = "obese";
            }
            //System.out.println(BMI);
        }
        Printer.prettyPrint(results);
    }

    public static double calcBMI(double[] input) {
        return input[0] / (input[1] * input[1]);
    }
}