package schaefers;

public class LastThree {
    String stringValue;
    String lastThreeString;
    double number;
    int lastThreeInt;

    /**
     * Converts to String to detect the last three digits
     */
    public void runString(int value) {
        this.processNewValueString(value);
        this.detectLastThreeString();
    }

    private void processNewValueString(int value) {
        this.stringValue = Integer.toString(value); // alternative: String.valueOf()
    }

    private void detectLastThreeString() {
        int length = stringValue.length();
        if (length >= 3) {
            lastThreeString = stringValue.substring(length - 3);
            System.out.println(lastThreeString);
        } else {
            System.out.println("The given number is shorter than 3 digits.");
        }
    }

    /**
     * Uses casting to double to detect the last three digits
     */
    public void runInt(int value) {
        this.processNewValueDouble(value);
        this.detectLastThreeDouble();
    }

    private void processNewValueDouble(int value) {
        this.number = value; // cast int to double 27.0
    }

    private void detectLastThreeDouble() {
        double lastThreeDouble = number - (int) (number / 1000) * 1000; // 27 - 0 * 1000 = 27
        lastThreeInt = (int) lastThreeDouble;
        if (lastThreeInt < 100) {
            System.out.println("The given number is shorter than 3 digits.");
        } else {
            System.out.println(lastThreeInt);
        }
    }

}