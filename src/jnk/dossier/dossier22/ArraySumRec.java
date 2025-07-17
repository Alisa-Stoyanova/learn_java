package jnk.dossier.dossier22;

public class ArraySumRec {
    public static void main(String[] args) {
        int[] myAry = {1, 2, 3, 4}; // sum = 10
        System.out.println(sumRec(myAry));
    }

    public static int sumRec(int[] ary) {
        if (ary.length == 0) {
            return 0;
        }
        int sum = ary[0];
        int[] subAry = new int[ary.length - 1];
        System.arraycopy(ary, 1, subAry, 0, ary.length - 1);
        return sum + sumRec(subAry);
    }
}
