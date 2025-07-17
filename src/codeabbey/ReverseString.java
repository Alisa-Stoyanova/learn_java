package codeabbey;

import java.util.Scanner;

public class ReverseString {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        reverseWithStringBuilder(input);
        reverseWithArray(input);
    }

    static void reverseWithStringBuilder(String input) {
        int length = input.length();
        StringBuilder strBuilder = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            //System.out.println(input.charAt(i));
            strBuilder.append(input.charAt(length - 1 - i));
        }
        System.out.println(strBuilder);
    }

    static void reverseWithArray(String input) {
        char[] inputAry = input.toCharArray();
        int length = input.length();
        for (int i = 0; i < length / 2; i++) {
            char temp = inputAry[i];
            inputAry[i] = inputAry[length - 1 - i];
            inputAry[length - 1 - i] = temp;
        }
        System.out.println(inputAry);
    }
}