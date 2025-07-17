package wendholt.v5Kontrollstrukturen;

public class Ue_5_14 {
    public static void main(String[] args) {
        int x = Integer.parseInt(args[0]);
        int y = Integer.parseInt(args[1]);
        int z = Integer.parseInt(args[2]);
        boolean expression = x <= 4 && (y < -10 || z % 2 == 0);
        System.out.printf("%s", expression);
    }
}