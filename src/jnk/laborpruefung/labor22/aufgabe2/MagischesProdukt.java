package jnk.laborpruefung.labor22.aufgabe2;

public class MagischesProdukt implements Produkt {
    private MagischesProdukt inneres;
    private String name;

    public MagischesProdukt(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setInneres(MagischesProdukt inneres) {
        this.inneres = inneres;
    }

    public MagischesProdukt getInneres() {
        return inneres;
    }

    @Override
    public int getVolumen() {
        int volumen = 1;
        if (inneres == null) {
            return volumen;
        } else {
            return volumen + inneres.getVolumen();
        }
    }

    public void einsetzen(MagischesProdukt magischesProdukt) {
        if (magischesProdukt.getInneres() != null) {
            throw new IllegalArgumentException();
        } else {
            magischesProdukt.inneres = inneres;
            inneres = magischesProdukt;
        }
    }
}
