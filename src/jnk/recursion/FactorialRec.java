package jnk.recursion;

public class FactorialRec {
    public static void main(String[] args) {
        //System.out.println(calcFactorialRec(Integer.parseInt(args[0])));
        System.out.println(calcFactorialRec(5));
        System.out.println(calcFactorialTailRec1(5)); // result: 120
        System.out.println(calcFactorialTailRec2(5)); // result: 120
    }

    public static int calcFactorialRec(int number) {
        if (number == 0) {
            return 1;
        } else {
            /* operand number will be evaluated by the operator as original number,
            argument number in calcFactorialRec() will be evaluated to number - 1 */
            return number-- * calcFactorialRec(number);
            //return number * calcFactorialRec(number - 1);
        }
    }

    /*
     * good variant with acc for intermediate results, initialized with neutral element for multiplying
     */
    public static int calcFactorialTailRec1(int number) {
        return calc1(number, 1);
    }

    public static int calc1(int number, int acc) {
        if (number == 0) {
            return acc;
        } else {
            return calc1(number - 1, acc * number);
        }
    }

    /*
     * worse
     */
    public static int calcFactorialTailRec2(int number) {
        return calc2(number, number - 1);
    }

    public static int calc2(int number, int counter) {
        if (number == 0) {
            return 1;
        } else if (counter == 0) { // base case
            return number;
        } else {
            return calc2(number * counter, counter - 1);
        }
    }
}
