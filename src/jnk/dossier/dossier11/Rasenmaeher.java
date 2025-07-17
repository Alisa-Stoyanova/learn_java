package jnk.dossier.dossier11;

public class Rasenmaeher {
    private final float tankvolumen;
    private float tankinhalt;

    public Rasenmaeher(float tankvolumen, float tankinhalt) {
        if (tankvolumen <= 0) {
            throw new IllegalArgumentException("Ungültiger Wert für das Tankvolumen.");
        }
        this.tankvolumen = tankvolumen;
        if (tankinhalt < 0) {
            throw new IllegalArgumentException("Ungültiger Wert für den Tankinhalt.");
        }
        this.tankinhalt = tankinhalt;
    }

    public Rasenmaeher(float tankvolumen) {
        this(tankvolumen, 0);
    }

    // Parameterloser Konstruktor TODO 11 Folie 24-25

    // Default-Konstruktor
    public Rasenmaeher() {
        this(5);
    }

    // Kopier-Konstruktor
    public Rasenmaeher(Rasenmaeher rasenmaeher) {
        tankvolumen = rasenmaeher.tankvolumen;
        tankinhalt = rasenmaeher.tankinhalt;
    }

    public float berechneVerbrauch(float flaeche) {
        double durchschnitt = 0.005;
        float verbrauch = (float) durchschnitt * flaeche;
        return verbrauch;
    }

    public void maehen(float flaeche) {
        tankinhalt -= berechneVerbrauch(flaeche);
    }
}
