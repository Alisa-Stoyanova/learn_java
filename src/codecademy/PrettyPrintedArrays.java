package codecademy;

import java.util.Arrays;

public class PrettyPrintedArrays {
    public static void main(String[] args) {
        char[][] my2DAry = new char[3][2];
        my2DAry[0][0] = 'a';
        my2DAry[0][1] = 'b';
        my2DAry[1][0] = 'c';
        my2DAry[1][1] = '\0';
        System.out.println(my2DAry + "\n"); // array's address in the memory
        System.out.println(Arrays.toString(my2DAry) + "\n"); // values (here: subarrays' addresses)
        System.out.println(Arrays.toString(my2DAry[0]) + "\n"); // values of the first subarray
        System.out.println(Arrays.deepToString(my2DAry) + "\n"); // values of all subarrays
    }
}
