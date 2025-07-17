package codeabbey;

import java.util.Scanner;

public class VowelCounter {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int amount = Integer.parseInt(scan.nextLine());
        int[] counts = new int[amount];
        char[] vowels = new char[]{'a', 'o', 'u', 'i', 'e', 'y'};
        for (int n = 0; n < amount; n++) {
            String line = scan.nextLine();
            //char[] lineAsChars = line.toCharArray();
            int count = 0;
            int i = 0;
            while (i < line.length()) {
                int j = 0;
                while (j < vowels.length) {
                    if (line.charAt(i) == vowels[j]) {
                        count++;
                        break;
                    }
                    j++;
                }
                i++;
            }
            counts[n] = count;
        }
        for (int count : counts) {
            System.out.print(count + " ");
        }
    }
}


/* public class VowelCounter {
    public static void main(String[] args) {
        String line = "abracadabra";
        String[] vowels = new String[] {"a", "o", "u", "i", "e", "y"};
        int i = 0;
        int counter = 0;
        while(i < vowels.length) {
            if(line.contains(vowels[i])) {
                counter++;
            }
            i++;
        }
        System.out.println(counter);
    }
}*/
