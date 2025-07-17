package jnk.recursion;

/*
 * calculates Fibonacci number at the given index
 */
public class Fibonacci {
    public static void main(String[] args) {
        System.out.println(fib(10));
        System.out.println(fibRec(10));
    }

    public static int fib(int idx) {
        if (idx <= 0) {
            return -1;
        }
        if (idx == 1 || idx == 2) {
            return 1;
        }
        int l = 1; // n - 2
        int m = 1; // n - 1
        int n = 0; // n
        for (int i = 3; i <= idx; i++) { // (int i = 0)
            n = l + m;
            l = m;
            m = n;
        }
        return n;
    }

    public static int fibRec(int idx) {
        if (idx <= 0) {
            return -1;
        }
        return idx == 1 || idx == 2 ? 1 : fibRec(idx - 1) + fibRec(idx - 2);
    }
}
