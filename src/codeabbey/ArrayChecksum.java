package codeabbey;

import java.util.Scanner;

public class ArrayChecksum {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int amount = scan.nextInt();
        int[] input = new int[amount];
        for (int i = 0; i < amount; i++) {
            input[i] = scan.nextInt();
        }
        long checksum = 0;
        for (int i = 0; i < input.length; i++) {
            checksum = (checksum + input[i]) * 113 % 10_000_007;
        }
        System.out.print(checksum);
    }
}