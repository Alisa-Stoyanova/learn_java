package codecademy;

/**
 * Uses the Double class' POSITIVE_INFINITY static field and the intValue() method to store an infinitely large value into an integer.
 * Compares the result to the Integer class' MAX_VALUE static field.
 * Prints out "True" if the result of the conversion is the maximum value an integer can hold.
 */
public class InfinityWrapperExperiment {
    public static void main(String[] args) {

        // Store the POSITIVE_INFINITY static field from the Double class into a Double wrapper object
        Double infinity = Double.POSITIVE_INFINITY;
        System.out.println(infinity); // String representation is Infinity

        // Unbox the infinitely large Double into an int
        int intInfinity = infinity.intValue();
        System.out.println(intInfinity);

        System.out.println(Integer.MAX_VALUE);

        // Modify the if condition to test if the integer value is equal to the MAX_VALUE static field from the Integer class
        if (intInfinity == Integer.MAX_VALUE) {
            System.out.println("True");
        }

    }
}

