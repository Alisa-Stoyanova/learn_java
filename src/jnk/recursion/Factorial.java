package jnk.recursion;

public class Factorial {

    public static void main(String[] args) {
        Factorial factorial = new Factorial();
        System.out.println(factorial.calcFactorial1(Integer.parseInt(args[0])));
        System.out.println(factorial.calcFactorial2(Integer.parseInt(args[0])));
    }

    public int calcFactorial1(int n) {
        int factorial, i;
        factorial = i = 1; // factorial = 1, because 1 is neutral element for multiplying
        while (i <= n) {
            factorial = i * factorial;
            i++;
        }
        return factorial;
    }

    public int calcFactorial2(int n) {
        int factorial = 1; // factorial = 1, because 1 is neutral element for multiplying
        while (n > 0) {
            factorial = n * factorial;
            n--;
        }
        return factorial;
    }
}