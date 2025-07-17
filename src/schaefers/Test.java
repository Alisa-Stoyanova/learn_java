package schaefers;

public class Test {
    static int e;

    static void m(int f) {
        System.out.println(f);
        int e = f + 1;
        System.out.println(e);
        f = e + 1;
        System.out.println(f);
    }

    public static void main(String[] args) {
/* 1001_05
        e=1;
        m(e);
        System.out.println(e);
        int e=3;
        m(e);
        System.out.println(e);
        */
        //1001_03
        int dummy = 0;
        for (int i = 5; i > 0; i--) {
            System.out.println("a " + i);
            dummy--;
        }
        System.out.println();

        for (int i = 3; i == 3; i++) {
            System.out.println("b " + i);
            dummy--;
        }
        System.out.println();

        for (int i = 1; i <= 13; i = i + 3) {
            System.out.println("c " + i);
            dummy--;
        }
        System.out.println();

        for (int i = 7; i == 0; i--) {
            System.out.println("d " + i);
            dummy--;
        }
        System.out.println();

        for (int i = 13; i > 0; i -= 3) {
            System.out.println("e " + i);
            dummy--;
        }
        System.out.println();

        for (int i = 2; i < 36; i = i * i) {
            System.out.println("f " + i);
            dummy--;
        }
        System.out.println();

        for (int i = 1; i < 36; i <<= 1) {
            System.out.println("g " + i);
            dummy--;
        }
        System.out.println();

        for (byte i = 64; i != 0; i -= 96) {
            System.out.println("h " + i);
            dummy--;
        }
    }
}