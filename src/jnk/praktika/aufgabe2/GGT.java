package jnk.praktika.aufgabe2;

public class GGT {
    public static void main(String[] args) {
        System.out.println(berechneGGT(0, 0)); // 0
        System.out.println(berechneGGT(5, 0)); // 5
        System.out.println(berechneGGT(0, 5)); // 5
        System.out.println(berechneGGT(12, 18)); // 6
        System.out.println(berechneGGT(13, 48)); // 1
    }

    public static int berechneGGT(int a, int b) {
        int ggt;
        if (a == 0) {
            ggt = b;
            return ggt;
        }
        while (b != 0) {
            if (a > b) {
                a = a - b;
            } else {
                b = b - a;
            }
        }
        ggt = a;
        return ggt;
    }
}
