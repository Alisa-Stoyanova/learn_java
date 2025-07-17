package jnk.laborpruefung.labor19.aufgabe1;

import java.util.Arrays;

public class Kontrollstrukturen {

    public static void main(String[] args) {
        Kontrollstrukturen k = new Kontrollstrukturen();
        System.out.println(k.harmonischeReihe(2));
    }

    public double harmonischeReihe(int n) {
        double result = 0;
        for (int i = 1; i <= n; i++) {
            result += 1.0 / i;
        }
        return result;
    }

    public enum Farbe {ROT, GRUEN, BLAU}

    public String farbe2String(Farbe farbe) {
        switch (farbe) {
            case ROT:
                return "rot";
            case GRUEN:
                return "gruen";
            case BLAU:
                return "blau";
        }
        return "";
    }

    public String[] kapazitaetVerdoppeln(String[] texte) {
/*        System.arraycopy(texte, 0, texte, 0, texte.length * 2);
        return texte;*/
        if (texte.length == 0) {
            return Arrays.copyOf(texte, 1);
        }
        return Arrays.copyOf(texte, texte.length * 2);
    }
}

