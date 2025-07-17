package jnk.laborpruefung.labor19.aufgabe2;

public class Algorithmen {

    // Hier den Lösungscode einfügen

    public int zeichenZaehlen(char zeichen, String text) {
        int counter = 0;
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == zeichen) {
                counter++;
            }
        }
        return counter;
    }

    public void sortieren(String pivotElement, String[] elemente) {
        int len = elemente.length;
        int counter = 0;
        for (int i = 0; i < len; i++) {
            if (elemente[i].equals(pivotElement)) {
                counter++;
            }
        }
        String[] tmp = new String[len];
        for (int i = 0; i < counter; i++) {
            tmp[i] = pivotElement;
        }
        for (int i = 0; i < len; i++) {
            if (!elemente[i].equals(pivotElement)) {
                tmp[counter] = elemente[i];
                counter++;
            }
        }
        System.arraycopy(tmp, 0, elemente, 0, len);
    }

    public boolean textFinden(String suchtext, char[] textgitter) {
        String input = "";
        for (int i = 0; i < textgitter.length; i++) {
            input += textgitter[i];
        }
        return input.contains(suchtext);
    }

    public static void main(String[] args) {
        Algorithmen algo = new Algorithmen();
    }
}


