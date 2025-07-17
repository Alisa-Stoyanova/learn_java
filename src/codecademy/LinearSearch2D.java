package codecademy;

public class LinearSearch2D {
    public static int linearSearch2D(String[][] haystack, String target) {
        for (int i = 0; i < haystack[0].length; i++) {
            for (int j = 0; j < haystack.length; j++) {
                if (haystack[j][i].equals(target)) {
                    System.out.println(target + " located at [" + i + "][" + j + "].");
                    return 1;
                }
            }
        }
        System.out.println("Couldn't find the " + target + " in the haystack.");
        return -1;
    }

    public static void main(String[] args) {
        String[][] haystack = {{"hay", "hay"}, {"hay", "hay"}, {"hay", "hay"}, {"hay", "hay"}, {"needle", "hay"}, {"hay", "hay"}};
        String target = "needle";
        linearSearch2D(haystack, target);
    }
}