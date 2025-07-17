package codeabbey;

import java.util.Scanner;

public class SumOfTwo {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);

        System.out.println("Enter a");
        String StringA = myScanner.nextLine();
        int a = Integer.parseInt(StringA);

        System.out.println("Enter b");
        String StringB = myScanner.nextLine();
        int b = Integer.parseInt(StringB);

        System.out.println("The sum is: " + (a + b));
    }
}
