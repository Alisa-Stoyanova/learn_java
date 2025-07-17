package codecademy;

public class HelloWorld {

    public static void main(String[] args) {
        String myStr = "Hello, World!";

        System.out.println(myStr.length()); // escape sequences such as \n count as only one character

        System.out.println(myStr.concat(" Hallo, Welt!"));

        System.out.println(myStr.indexOf("l")); // returns index of the first occurrence of a character in a string

        System.out.println(myStr.indexOf("World")); // returns index of the first character of the first occurrence of a substring
        // returns -1 if there is no such substring

        System.out.println(myStr.charAt(7)); // IndexOutOfBoundsException if index  is out of the string's range

        System.out.println(myStr.substring(4)); // substring begins with the character at the specified index and extends to the end of the string

        System.out.println(myStr.substring(4, 5)); // substring from the middle of the string -> call with two arguments, the first argument is inclusive and the second is exclusive

        System.out.println(myStr.toUpperCase());

        System.out.println(myStr.toLowerCase());

        System.out.println(myStr.equals("hello, world!"));

        System.out.println(myStr.equalsIgnoreCase("hello, world!"));

        System.out.println(myStr.compareTo("hello, world!")); // compares ASCII values -> dictionary order

        System.out.println(myStr.compareToIgnoreCase("hello, world!"));

    }

}