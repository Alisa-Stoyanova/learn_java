package codecademy;

/**
 * Example class: Autoboxing and unboxing are used when passing values to a method.
 */

public class AutoboxingAndUnboxing {

    public static int acceptWrapperObj(Integer intVal) {
        System.out.println("Value of Integer wrapper object: " + intVal.toString());
        int toReturn = intVal;
        return toReturn;
    }

    public static Double acceptPrimitiveDouble(double doubleVal) {
        System.out.println("Value of primitive double: " + doubleVal);
        Double toReturn = Double.valueOf(doubleVal);
        return toReturn;
    }

    public static void main(String[] args) {

        double doubleVal = 11.56;

        // Autobox the value of 'doubleVal' into a Double wrapper object called 'wrapper'
        Double wrapper = doubleVal;

        // Other (worse) options to create a wrapper object
        Double wrapper2 = Double.valueOf(doubleVal);
        // Double wrapper3 = new Double(doubleVal);

        // Create a new Integer wrapper object containing the value 20 called 'intWrapper'
        Integer intWrapper = 20;

        // Unbox the value stored in 'intWrapper' into an int variable called 'resultInt'
        int myInt = intWrapper;

        int testInt = 5;
        int resultInt = acceptWrapperObj(testInt); // autobox the primitive value

        Double testDoubleObj = Double.valueOf(3.14);
        Double resultDouble = acceptPrimitiveDouble(testDoubleObj); // unbox the wrapper object

    }
}