package jnk.laborpruefung.labor22.aufgabe2;

import java.util.Arrays;

public class Einkaufskorb extends Behaelter {
    private Produkt[] produkte = new Produkt[0];

    public Einkaufskorb(String name) {
        super(name);
    }

    @Override
    public int getBelegt() {
        int sum = 0;
        for (Produkt produkt : produkte) {
            sum += produkt.getVolumen();
        }
        return sum;
    }

    public void einlegen(Produkt produkt) {
        if (produkt != null) {
            produkte = Arrays.copyOf(produkte, produkte.length + 1);
            produkte[produkte.length - 1] = produkt;
        }
    }

    public void einlegen1(Produkt produkt) {
        if (produkt != null) {
            int len = produkte.length;
            Produkt[] tmp = new Produkt[len + 1];
            System.arraycopy(produkte, 0, tmp, 0, len);
            tmp[tmp.length - 1] = produkt;
            produkte = tmp;
        }
    }

    public void einlegen2(Produkt produkt) {
        if (produkt != null) {
            Produkt[] tmp = new Produkt[produkte.length + 1];
            for (int i = 0; i < produkte.length; i++) {
                tmp[i] = produkte[i];
            }
            tmp[tmp.length - 1] = produkt;
            produkte = tmp;
        }
    }
}
