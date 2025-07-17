package jnk.laborpruefung.labor21_2.aufgabe2;


import jnk.laborpruefung.labor21_2.aufgabe1.Ding;

/**
 * In einem Lager können Dinge gelagert werden. Freien Platz im Lager erkennt man an null in dem entsprechenden
 * Feld in lagerRaum.
 */
public class Lager {

    /**
     * In diesem Array werden die Dinge im Lager abgelegt. Je nach Größe belegen die Dinge mehrere PLätze im Array.
     */
    private Ding[] lagerRaum;

    /**
     * Erzeugt ein Lager mit der angegebenen Größe
     */
    public Lager(int platz) {
        this.lagerRaum = new Ding[platz];
    }


    /// +++++ Hier Ihre Lösung einfügen ++++++++
    public int anzahlFrei() { // 54 Min
        int free = 0;
        for (int i = 0; i < lagerRaum.length; i++) {
            if (lagerRaum[i] == null) {
                free++;
            }
        }
        return free;
    }

    public void anbauen(Lager anderesLager) {
        if (anderesLager != null) {
            Ding[] neuerRaum = new Ding[lagerRaum.length + anderesLager.lagerRaum.length];
            System.arraycopy(lagerRaum, 0, neuerRaum, 0, lagerRaum.length);
            System.arraycopy(anderesLager.lagerRaum, 0, neuerRaum, lagerRaum.length - 1, anderesLager.lagerRaum.length);
            lagerRaum = neuerRaum;
        }
    }

/*    public boolean einlagern(Ding ding) {
        boolean genugPlatz = ding.getGroesse() <= anzahlFrei();
        if (genugPlatz) {
            for (int j = 0; j < ding.getGroesse(); j++) {
                for (int i = 0; i < lagerRaum.length; i++) {
                    if (lagerRaum[i] == null) {
                        lagerRaum[j] = ding;
                    }
                }
            }
        }
        return genugPlatz;
    }*/

    public boolean einlagern(Ding ding) {
        int dingGroesse = ding.getGroesse();
        boolean ausreichendPlatz = dingGroesse <= anzahlFrei();
        if (ausreichendPlatz) {
            for (int i = 0; i < lagerRaum.length; i++) {
                if (lagerRaum[i] == null && dingGroesse != 0) {
                    lagerRaum[i] = ding;
                    dingGroesse--;
                }
            }
        }
        return ausreichendPlatz;
    }
}