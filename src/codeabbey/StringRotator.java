package codeabbey;

public class StringRotator {

    public static String rotate(int k, String input) {
        char[] inputAry = input.toCharArray();
        int length = inputAry.length;
        String rotated = input;
        if (k != 0) {
            if (k > 0) {
                char[] tempAry = new char[k];
                for (int i = 0; i < k; i++) {
                    tempAry[i] = inputAry[i];
                }
                // System.out.println(tempAry);
                for (int j = 0; j < length; j++) {
                    if (j >= length - k) {
                        inputAry[j] = tempAry[k - (length - j)];
                    } else {
                        inputAry[j] = inputAry[j + k];
                    }
                }
                rotated = new String(inputAry);
            } else { // k < 0
                char[] tempAry = new char[k * (-1)];
                for (int i = length - 1; i > length - k * (-1); i--) {
                    tempAry[tempAry.length - 1] = inputAry[i];
                }
                System.out.println(tempAry);
                for (int j = length - 1; j >= 0; j--) {
                    if (j >= length - k) {
                        inputAry[j] = tempAry[k - (length - j)];
                    } else {
                        inputAry[j] = inputAry[j + k];
                    }
                }
/*                for (int i = inputAry.length - 1; i > k * (-1); i--) {
                    char temp = inputAry[length - 1 - i];
                    inputAry[length - 1 - i] = inputAry[i];
                    inputAry[i] = temp;
                    rotated = new String(inputAry);
                }*/
            }
        }
        return rotated;
    }
}