package codecademy;

import java.util.ArrayList;

// Build a method that filters an array for odd or even numbers (bonus points if it can do either depending on arguments passed in!).
// Build a method that returns an ArrayList of the first n Fibonacci numbers.

/**
 * Creates an ArrayList of all prime numbers in an array.
 */
class PrimeDirective {

    public static void main(String[] args) {

        PrimeDirective pd = new PrimeDirective();
        // test isPrime()
        System.out.println(pd.isPrime(7));
        System.out.println(pd.isPrime(28));
        System.out.println(pd.isPrime(2));
        System.out.println(pd.isPrime(0));

        int[] numbers = {6, 29, 28, 33, 11, 100, 101, 43, 89};
        System.out.println(pd.onlyPrimes(numbers));
        System.out.println(pd.returnFirstN(numbers, 10));
    }

    public boolean isPrime(int number) {
        if (number == 2) { // edge case: 2 is the smallest prime number
            return true;
        } else if (number < 2) { // edge case: if number < 2, it is not prime
            return false;
        }

        for (int i = 2; i < number; i++) { // any integer between 2 and n-1
            if (number % i == 0) { // if number is prime, it should not be divisible by any integers between 2 and number-1
                return false; // if there is no rest, return false
            }
        }
        return true;

    }

    /**
     * Returns an ArrayList of all primes in an array
     */
    public ArrayList<Integer> onlyPrimes(int[] numbers) {
        ArrayList<Integer> primes = new ArrayList<Integer>();
        for (int number : numbers) {
            if (isPrime(number)) {
                primes.add(number);
            }
        }
        return primes;
    }

    /**
     * Returns an ArrayList of the first n primes in an array
     */
    public ArrayList<Integer> returnFirstN(int[] numbers, int num) {
        ArrayList<Integer> nPrimes = onlyPrimes(numbers);
        int size = nPrimes.size();
        if (size > num) {
            for (int i = num; i < size; i++) {
                nPrimes.remove(num); // index stays the same when a value from the middle is removed
            }
        }
        return nPrimes;

        /*
        if (size <= num) {
            return nPrimes;
        } else {
            for (int i = num; i < size; i++) {
                nPrimes.remove(i);
            }
            return nPrimes;
        } */
    }

}