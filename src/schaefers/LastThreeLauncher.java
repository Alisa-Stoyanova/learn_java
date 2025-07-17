package schaefers;

public class LastThreeLauncher {

    public static void main(String[] args) {
        LastThree myLastThree = new LastThree();
        myLastThree.runString(654321);
        myLastThree.runString(0);
        myLastThree.runString(21);

        myLastThree.runInt(654321);
        myLastThree.runInt(0);
        myLastThree.runInt(21);
    }

}