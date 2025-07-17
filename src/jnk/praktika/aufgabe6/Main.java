package jnk.praktika.aufgabe6;

public class Main {
    public static void main(String[] args) {
        Brettspiel gloomhaven = new Brettspiel("Gloomhaven", new int[]{1, 4}, 12);
        gloomhaven.ausgeben();

        Brettspiel carcassonne = new Brettspiel("Carcassonne", new int[]{2, 4}, 8);
        Brettspiel hanabi = new Brettspiel("Hanabi", new int[]{2, 5}, 8);
        Brettspiel pandemic = new Brettspiel("Pandemic", new int[]{2, 3}, 12);

        Brettspielsammlung mySammlung = new Brettspielsammlung();
        System.out.println(mySammlung.getLength()); // 0
        mySammlung.hinzufuegen(gloomhaven);
        mySammlung.hinzufuegen(carcassonne);
        System.out.println(mySammlung.getLength()); // 2
        mySammlung.hinzufuegen(hanabi);
        mySammlung.hinzufuegen(pandemic);
        mySammlung.ausgeben();
        System.out.println(mySammlung.getAnzahlBrettspiele());
        System.out.println(mySammlung.getBrettspielAtIndex(2));
        try {
            System.out.println(mySammlung.getBrettspielAtIndex(42));
        } catch (IllegalArgumentException e) {
            System.out.println("Index muss nicht größer als Länge der Sammlung sein.");
        }
        System.out.println(mySammlung.getIndexFuer(gloomhaven)); // idx 0

        System.out.println(mySammlung.getIndexFuer(null)); // idx -1
        mySammlung.hinzufuegen(carcassonne);
        System.out.println(mySammlung.getIndexFuer(null)); // returns idx -1, not the idx of the first occurrence of null
        System.out.println(mySammlung.getLength());

        /*int idxOfPandemic = mySammlung.getIndexFuer(pandemic);
        mySammlung.entfernen(pandemic);
        System.out.println(mySammlung.getLength());
        System.out.println(mySammlung.getBrettspielAtIndex(idxOfPandemic) != pandemic);*/

        int idxOfPandemic = mySammlung.getIndexFuer(pandemic);
        Brettspiel pandemicNext = mySammlung.getBrettspielAtIndex(idxOfPandemic + 1);
        mySammlung.entfernen(pandemic);
        System.out.println(mySammlung.getBrettspielAtIndex(idxOfPandemic) == pandemicNext); // TODO should return true, now returns false
        //TODO entfernen (kopieren(int, int)), getAnzahlBrettspiele, leeren, belegt
    }
}
