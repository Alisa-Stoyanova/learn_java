package codecademy;

import java.util.Arrays;

public class NestedLoops {
    public static void main(String[] args) {
        int[][] intMatrix = {{1, 1, 1},
                {2, 2, 2, 2, 2},
                {3}};

        for (int i = 0; i < intMatrix.length; i++) {
            for (int j = 0; j < intMatrix[i].length; j++) {
                System.out.println(intMatrix[i][j]);
            }
        }

        System.out.println(Arrays.deepToString(intMatrix));


        int row = 0;
        while (row < intMatrix.length) {
            int column = 0;
            while (column < intMatrix[row].length) {
                System.out.println(intMatrix[row][column]);
                column++;
            }
            row++;
        }

/* multiplication table is similar to the iteration pattern we use for 2D array traversal.
https://www.codecademy.com/courses/learn-java/lessons/2-d-arrays-java/exercises/review-of-nested-loops */
        for (int i = 1; i <= 10; i++) {
            for (int j = 1; j <= 10; j++) {
                System.out.print(i * j + " ");
            }
            System.out.println();
        }

    }
}