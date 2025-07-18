package jnk.laborpruefung.labor21_1.inuit.aufgabe1;

public class Kiste extends Ding {
    private final String inhalt;

    public Kiste(int groesse, String inhalt) {
        super(groesse);
        this.inhalt = inhalt;
    }

    @Override
    public String toString() {
        return String.format("Kiste mit %s", inhalt);
    }

    public Kiste zusammenlegen(Kiste andere) {
        if (andere == null) {
            throw new IllegalArgumentException();
        }

        return new Kiste(this.getGroesse() + andere.getGroesse(), String.format("%s+%s", this, andere));
    }
}
