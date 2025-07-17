package codecademy;

public class StringReverser {
    public static void main(String[] args) {
        String string = "Ahoi";
        System.out.println("Original: " + string);
        System.out.println("Reversed iterative: " + reverseIter(string) + "\n");
        System.out.println("Original: " + string);
        System.out.println("Reversed recursive: " + reverseRec(string));
    }

    public static String reverseIter(String string) {
        String reversed = "";
        for (int i = 0; i < string.length(); i++) {
            reversed = string.charAt(i) + reversed;
            System.out.println(reversed);
        }
        return reversed;
    }

    public static String reverseRec(String string) {
        if (string.length() == 0) {
            return string;
        } else {
            String reversed = reverseRec(string.substring(1)) + string.charAt(0);
            System.out.println(reversed);
            return reversed;
        }
    }
}