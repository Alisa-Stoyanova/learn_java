package schaefers;

public class Palindrome {

    public static void main(String[] args) {
        System.out.println(isPalindrome("otto"));
        System.out.println(isPalindrome("abcba"));
        System.out.println(isPalindrome("abBA"));
        System.out.println(isPalindrome("abca"));
        System.out.println(isPalindrome("abcla"));
        // System.out.println(isPalindrome(12321)); // digits ?
    }

    static boolean isPalindrome(String s) {
        String wordToTest = s.toLowerCase();
        int length = wordToTest.length();
        for (int i = 0; i < length / 2; i++) {
            if (wordToTest.charAt(i) != wordToTest.charAt(length - 1 - i)) {
                return false;
            }
        }
        return true;
    }
}