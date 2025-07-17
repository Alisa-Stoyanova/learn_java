package jnk.laborpruefung.labor21_2.aufgabe1;

public class Box extends Ding { // 11 Min
    private String inhalt;

    public Box(int groesse, String inhalt) {
        super(groesse);
        this.inhalt = inhalt;
    }

    @Override
    public String toString() {
        return "Box mit " + inhalt;
    }

    public Box zusammenlegen(Box andere) {
        if (andere == null) {
            throw new IllegalArgumentException();
        }
        return new Box(getGroesse() + andere.getGroesse(), inhalt + "+" + andere.inhalt);
    }
}
