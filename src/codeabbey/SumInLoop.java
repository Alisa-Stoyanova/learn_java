package codeabbey;

import java.util.Scanner;

public class SumInLoop {
    public static void main(String[] args) {
        Scanner myScan = new Scanner(System.in);
        System.out.println("Enter the values to sum");
        String numbersString = myScan.nextLine();

        String[] numbers = numbersString.split(" ");
        int sum = 0;
        for (int i = 0; i < numbers.length; i++) {
            sum += Integer.parseInt(numbers[i]);
        }
        System.out.println("The sum is: " + sum);
    }
}