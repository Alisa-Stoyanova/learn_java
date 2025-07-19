package jnk.laborpruefung.labor18.arrays;

public class Aufgabe1 {

  public Aufgabe1() {

  }

  // HIER BEGINNT DER CODE FÜR DIE AUFGABEN

  public String stringAusCharArray(char[] zeichen){
    String s ="";

    for(char c:zeichen){
      s = s+c;
    }
    return s;
  }

  public Bruch[] kopie(Bruch[] brueche) {
    Bruch[] neueBrueche = new Bruch[brueche.length];

    for(int i = 0; i< brueche.length; i++){
      neueBrueche[i] = new Bruch(brueche[i].getZaehler(),brueche[i].getNenner());
    }
    return neueBrueche;

  }

  /*public double[] einfuegen(double[] daten, int index, double wert){
    double[] neueDaten = new double[daten.length+1];

    for(int i = 0; i < index; i++){
      neueDaten[i] = daten[i];
    }
    neueDaten[index] = wert;
    for(int i = index+1; i < daten.length+1; i++){
      neueDaten[i] = daten[i-1];
    }
    return neueDaten;
  }*/
  public double[] einfuegen(double[] daten, int index, double wert){
    double[] neueDaten = new double[daten.length+1];

    System.arraycopy(daten,0,neueDaten,0,index);
    neueDaten[index] = wert;
    System.arraycopy(daten,index,neueDaten,index+1,daten.length-index);
    return neueDaten;
  }

  // HIER ENDET DER CODE FÜR DIE AUFGABEN
}
