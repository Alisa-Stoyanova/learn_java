package jnk.laborpruefung.probe.aufgabe3;

public class Motorrad extends Fahrzeug {
    private boolean hatBeiwagen;

    public Motorrad(String marke, String modell, int baujahr, boolean hatBeiwagen) {
        super(marke, modell, baujahr);
        this.hatBeiwagen = hatBeiwagen;
    }

    @Override
    public String getInfo() {
        return marke + modell + baujahr + hatBeiwagen;
    }

    public boolean getHatBeiwagen() {
        return hatBeiwagen;
    }
}

