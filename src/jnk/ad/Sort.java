package jnk.ad;

import java.util.Arrays;

public class Sort {
    public static void main(String[] args) {
        //int[] list = {6, 4, 3, 9, 2, 4};
        int[] list = {4, 6, 3, 9, 2, 4};
        System.out.println("Unsorted: " + Arrays.toString(list));
        /*selectionSort(list);
        System.out.println("Selection sort: " + Arrays.toString(list));*/
/*        insertionSort(list);
        System.out.println("Insertion sort: " + Arrays.toString(list));*/
        bubbleSort(list);
        System.out.println("Bubble sort: " + Arrays.toString(list));
    }

    public static void selectionSort(int[] ary) {
        for (int i = 0; i < ary.length - 1; i++) { // no need to check the last elem: nothing to compare (and swap) with
            swap(ary, i, findIdxOfMin(ary, i));
            //System.out.println(Arrays.toString(ary));
        }
    }

    public static int findIdxOfMin(int[] ary, int startIdx) {
        int idxOfMin = startIdx;
        for (int j = startIdx + 1; j < ary.length; j++) { // no need to compare with itself
            if (ary[j] < ary[idxOfMin]) {
                idxOfMin = j;
            }
        }
        return idxOfMin;
    }

    public static void swap(int[] ary, int i, int j) {
        int tmp = ary[i];
        ary[i] = ary[j];
        ary[j] = tmp;
    }

    public static void insertionSort(int[] ary) {
        for (int i = 1; i < ary.length; i++) {
            System.out.print("if i = " + i + " and value = " + ary[i]);
            for (int j = i; j > 0; j--) {
                if (ary[j] < ary[j - 1]) {
                    swap(ary, j, j - 1);
                }
            }
            System.out.println(" than after swap " + Arrays.toString(ary));
        }
    }

    public static void bubbleSort(int[] ary) {
        boolean swapped = false;
        int i = 0;
        while (!swapped) {
            for (int j = 0; j < ary.length - 1 - i; j++) {
                if (ary[j] > ary[j + 1]) {
                    swap(ary, j, j + 1);
                    swapped = true;
                }
                System.out.println(Arrays.toString(ary));
            }
            i++;
        }
        //System.out.println(Arrays.toString(ary));
    }
}
