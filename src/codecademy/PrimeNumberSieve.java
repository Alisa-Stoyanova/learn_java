package codecademy;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Generates a list of integers from 2 to 120,
 * finds all the prime numbers in the list by Eratosthenes' method https://en.wikipedia.org/wiki/Sieve_of_Eratosthenes
 */

public class PrimeNumberSieve {
    static int p = 2; // the smallest prime number

    public static ArrayList<Integer> stepThree(int[] ary, ArrayList<Integer> primeList) {
        while (true) {
            int i = 0;
            while (i < ary.length) { // enumerate the multiples of p by counting in increments of p from 2p to n, and mark them in the list (these will be 2p, 3p, 4p, ...).
                if (ary[i] == p || ary[i] % p != 0) {
                    primeList.add(ary[i]);
                }
                i++;
            }

            int min = primeList.get(0);
            i = 0;
            while (i < primeList.size()) {
                if (min > p) {
                    int currentNumber = primeList.get(i);
                    min = Math.min(min, currentNumber);
                } else {
                    min = p;
                }
                i++;
            }

            if (min != p) {
                p = min;
            } else {
                return primeList;
            }
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> primeList = new ArrayList<Integer>();
        int[] ary = new int[119]; // [2, 120]

        int j = 0;
        while (j < 119) { // create a list of consecutive integers from 2 through 120
            ary[j] = j + 2; // ary[0] is 2
            j++;
        }

        String prettyAry = Arrays.toString(ary);
        System.out.println("A list of consecutive integers from 2 through 120:\n" + prettyAry + "\n");
        System.out.println("Length of the list:\n" + ary.length + "\n");

        stepThree(ary, primeList);

        System.out.println(primeList);
    }

}