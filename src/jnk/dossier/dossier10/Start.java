package jnk.dossier.dossier10;

/*
 * Simulator für einen Kampf zwischen zwei Kriegern. Die beiden wechseln zwischen Angriff und Verteidigung.
 * Der Kampf endet, wenn einer der beiden bewusstlos ist.
 * Bei jedem erfolgreichen Angriff (Angriff erfolgreich, Verteidigung nicht) wird ein Lebenspunkt abgezogen.
 */
public class Start {
    public static void main(String[] args) {
        Krieger spieler1 = new Krieger("Alien", 20, 20, 10);
        Krieger spieler2 = new Krieger("Predator", 20, 20, 5);
        Wuerfel wuerfel = new Wuerfel(20);
        spielen(spieler1, spieler2, wuerfel);
    }

    private static void spielen(Krieger spieler1, Krieger spieler2, Wuerfel wuerfel) {
        while (!(spieler1.istBewusstlos() || spieler2.istBewusstlos())) {
            spieler1.zugAusfuehren(spieler2, wuerfel);
            if (!spieler2.istBewusstlos()) {
                spieler2.zugAusfuehren(spieler1, wuerfel);
            }
        }
        if (spieler1.istBewusstlos()) {
            printGameOver(spieler1);
        } else {
            printGameOver(spieler2);
        }
    }

    private static void printGameOver(Krieger spieler) {
        System.out.print("Game over: " + spieler.getName() + " ist bewusstlos");
    }
}