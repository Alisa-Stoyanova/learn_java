package codeabbey;

import codeabbey.utils.InputReader;
import codeabbey.utils.Printer;

public class RotateStringLauncher {
    public static void main(String[] args) {
        InputReader reader = new InputReader();
        int amount = reader.readInt();
        String[] results = new String[amount];
        int k;
        String input;
        for (int i = 0; i < amount; i++) {
            String[] inputAry = reader.readStringAry();
            k = Integer.parseInt(inputAry[0]);
            input = inputAry[1];
            results[i] = StringRotator.rotate(k, input);
        }

        Printer.prettyPrint(results);
    }
}
