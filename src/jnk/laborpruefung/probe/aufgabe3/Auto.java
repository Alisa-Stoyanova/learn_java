package jnk.laborpruefung.probe.aufgabe3;

public class Auto extends Fahrzeug {
    private int anzahlTueren;

    public Auto(String marke, String modell, int baujahr, int anzahlTueren) {
        super(marke, modell, baujahr);
        this.anzahlTueren = anzahlTueren;
    }

    @Override
    public String getInfo() {
        return marke + modell + baujahr + anzahlTueren;
    }

    public int getAnzahlTueren() {
        return anzahlTueren;
    }
}
