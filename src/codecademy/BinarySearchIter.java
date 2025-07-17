package codecademy;

public class BinarySearchIter {
    public static void main(String[] args) {
        int[] arr = {2, 5, 6, 8, 9, 10};
        int target = 8;

        int index = binarySearch(arr, target);
        if (index != -1) {
            System.out.println("Element found at index " + index);
        } else {
            System.out.println("Element not found in the array");
        }
    }

    public static int binarySearch(int[] ary, int target) {
        int left = 0;
        int right = ary.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (target == ary[mid]) {
                return mid;
            }

            if (target < ary[mid]) {
                right = mid - 1;
            }

            if (target > ary[mid]) {
                left = mid + 1;
            }
        }
        return -1;
    }
}
