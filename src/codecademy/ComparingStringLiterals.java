package codecademy;

// https://www.codecademy.com/paths/ap-computer-science-a/tracks/apcs-conditionals-and-control-flow/modules/apcs-conditionals-and-control-flow/articles/comparing-objects-in-java
/* In Java, string literals are objects of the String class, and they are automatically stored in the string pool for memory optimisation.
 * https://www.geeksforgeeks.org/string-initialization-java-string-literal-vs-string-object/*/
public class ComparingStringLiterals {

    public static void main(String[] args) {
        String duckNoise1 = new String("quack"); // object
        String duckNoise2 = new String("quack");
        System.out.println("duckNoise1 == duckNoise2: " + (duckNoise1 == duckNoise2)); // false
        String duckNoise3 = "quack"; // literal
        System.out.println("duckNoise1 == duckNoise3: " + (duckNoise1 == duckNoise3)); // false
        String duckNoise4 = "quack";
        System.out.println("duckNoise3 == duckNoise4: " + (duckNoise3 == duckNoise4)); // true
        duckNoise3 = "bark"; // move pointer
        System.out.println("duckNoise4: " + duckNoise4); // does not change, because now duckNoise3 and duckNoise4 point to different string literals
        String duckNoise5 = "ba" + "rk";
        System.out.println("duckNoise3 == duckNoise4: " + (duckNoise3 == duckNoise5)); // true
    }
}
