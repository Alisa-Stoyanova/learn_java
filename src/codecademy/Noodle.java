package codecademy;

import java.util.ArrayList;

public class Noodle {
    static final String dishType = "pasta";
    int length;
    int cookingTime; // in minutes
    String ingredient = "wheat";
    String noodleType = "Common noodles";

    public Noodle(int length, int cookingTime) {
        this.length = length;
        if (cookingTime >= 1) {
            this.cookingTime = cookingTime;
        }
    }

    public Noodle() {
    }

    @Override
    public final String toString() {
        return noodleType;
    }

    // public static String getDishType() { return dishType; } // not needed

    protected void cook(String sauce) {
        System.out.println(noodleType + " is a type of " + dishType + ".\nCook it for " + cookingTime
                + " minutes and add some " + sauce + " sauce. Enjoy your meal!");
    }

    public static void main(String[] args) {
        Noodle commonNoodle = new Noodle(2, 7);
        Noodle vermicelli = new Vermicelli();
        Noodle spaetzle = new Spaetzle(2, 8);

        ArrayList<Noodle> noodles = new ArrayList<>(2);
        noodles.add(vermicelli);
        noodles.add(spaetzle);
        noodles.add(commonNoodle);

        System.out.println(noodles);
        for (Noodle noodle : noodles) {
            noodle.length++;
        }

        commonNoodle.cook("curry");
        vermicelli.cook("bolognese");
    }

}
