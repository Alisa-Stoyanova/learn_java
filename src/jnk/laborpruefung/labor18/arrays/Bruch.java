package jnk.laborpruefung.labor18.arrays;

/**
 * Ein Bruch besteht aus einem Zähler und einem Nenner.
 */
class Bruch {

  /**
   * Zähler.
   */
  private int zaehler;

  /**
   * Nenner.
   */
  private int nenner;

  /**
   * Default-Konstruktor.
   */
  public Bruch() {
    this(0, 1);
  }

  /**
   * Konstruktor mit Initialisierung der Objektvariablen.
   */
  public Bruch(int zaehler, int nenner) {
    this.zaehler = zaehler;
    this.nenner = nenner;
  }

  /**
   * Kopier-Konstruktor.
   */
  public Bruch(Bruch andererBruch) {
    this(andererBruch.zaehler, andererBruch.nenner);
  }

  /**
   * Konstruktor zur Initialisierung einer Ganzzahl.
   */
  public Bruch(int zahl) {
    this(zahl, 1);
  }

  /**
   * Initialisierung des Zustandes des Bruches (der Objektvariablen).
   */
  public void initialisiere(int zaehler, int nenner) {
    this.zaehler = zaehler;
    this.nenner = nenner;
  }

  /**
   * Initialisierung des Zustandes des Bruches (der Objektvariablen) auf einen
   * konkrete (ganzzahligen) Wert.
   */
  public void initialisiere(int wert) {
    this.zaehler = wert;
    this.nenner = 1;
  }

  /**
   * Beschreibung des Objektzustands auf der Konsole ausgeben.
   */
  public void print() {
    System.out.format("%d/%d\n", zaehler, nenner);
  }

  /**
   * Vereinfache den Bruch soweit möglich (durch Division durch den GGT).
   */
  public void vereinfache() {
    int gcd = berechneGgt(zaehler, nenner);
    zaehler /= gcd;
    nenner /= gcd;
  }

  /**
   * Erweiterung des Bruches um einen Faktor (Multiplikation von Zaehler und
   * Nenner).
   */
  public void erweitere(int faktor) {
    zaehler *= faktor;
    nenner *= faktor;
  }

  /**
   * Berechnet den GGT (größten gemeinsamen Teiler) zweier Zahlen mit dem
   * Algorithmus von Euklid. Liefert das Ergebnis zurück.
   */
  private int berechneGgt(int zahl1, int zahl2) {
    // Sicherstellung, dass beide Zahlen positiv sind
    zahl1 = Math.abs(zahl1);
    zahl2 = Math.abs(zahl2);

    // Algorithmus von Euklid
    int ergebnis = 0;
    if (zahl1 == 0) {
      ergebnis = zahl2;
    } else {
      while (zahl2 != 0) {
        if (zahl1 > zahl2) {
          zahl1 = zahl1 - zahl2;
        } else {
          zahl2 = zahl2 - zahl1;
        }
      }
      ergebnis = zahl1;
    }
    return ergebnis;
  }

  /**
   * Addiere zweiten Bruch zum this-Objekt, speichere Ergebnis im this-Objekt.
   */
  public void addiereDazu(Bruch andererBruch) {
    zaehler = zaehler * andererBruch.nenner + andererBruch.zaehler * nenner;
    nenner = nenner * andererBruch.nenner;
    vereinfache();
  }

  /**
   * Liefert den (Fließkomma-)Wert des Bruches.
   */
  public double getWert() {
    return (double) zaehler / (double) nenner;
  }

  /**
   * Verdoppelt den Wert des Bruchs (Verdeopplung des Zählers).
   */
  public void verdopple() {
    zaehler *= 2;
  }

  /**
   * Subtrahiere zweiten Bruch vom this-Objekt, speichere Ergebnis im
   * this-Objekt.
   */
  public void subtrahiereDavon(Bruch andererBruch) {
    zaehler = zaehler * andererBruch.nenner - andererBruch.zaehler * nenner;
    nenner = nenner * andererBruch.nenner;
    vereinfache();
  }

  /**
   * Prädikat, das wahr liefert, wenn der Bruch einen kleinern Wert hat, als der
   * Bruch, der sich aus den Parametern ergibt.
   */
  public boolean istKleiner(int zaehler, int nenner) {
    return getWert() < (double) zaehler / (double) nenner;
  }

  /**
   * Prädikat, das wahr liefert, wenn der Bruch einen kleineren Wert hat, als
   * die Parameter-Zahl.
   */
  public boolean istKleiner(int zahl) {
    return istKleiner(zahl, 1);
  }

  /**
   * Getter-Methode.
   */
  public int getZaehler() {
    return zaehler;
  }

  /**
   * Getter-Methode.
   */
  public int getNenner() {
    return nenner;
  }

  /**
   * Setter-Methode.
   */
  public void setZaehler(int neuerWert) {
    zaehler = neuerWert;
  }

  /**
   * Setter-Methode.
   */
  public void setNenner(int neuerWert) {
    nenner = neuerWert;
  }

  /**
   * Neue Version von addiereDazu, bei der verhindert wird, dass der
   * Parameter-Bruch verändert wird.
   */
  public Bruch addiereDazuFinal(final Bruch andererBruch) {
    return new Bruch(
        zaehler * andererBruch.nenner + nenner * andererBruch.zaehler,
        nenner * andererBruch.nenner);
  }

  /**
   * Alternative Version für erweitere in einer unveränderlichen Klasse.
   */
  public Bruch erweitereFinal(int faktor) {
    return new Bruch(zaehler * faktor, nenner * faktor);
  }

  /**
   * Alternative Version für erweitere in einer unveränderlichen Klasse.
   */
  public Bruch vereinfacheFinal() {
    int gcd = berechneGgt(zaehler, nenner);
    return new Bruch(zaehler / gcd, nenner / gcd);
  }

  @Override
  public boolean equals(Object anderesObjekt) {
    if (!(anderesObjekt instanceof Bruch)) {
      return false;
    }
    Bruch andererBruch = (Bruch) anderesObjekt;
    return zaehler == andererBruch.zaehler && nenner == andererBruch.nenner;
  }

}
