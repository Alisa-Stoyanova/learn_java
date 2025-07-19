package jnk.laborpruefung.labor18.schleifen;

public class Aufgabe1 {

  public Aufgabe1() {

  }

  // HIER BEGINNT DER CODE FÜR DIE AUFGABEN

  public int summeQuadrate(int n) {
    int ergebnis = 0;

    for(int i = 1; i <= n; i++) {
      ergebnis += i*i;
    }
    return ergebnis;
  }

  public char vorneImAlphabet(String text) {
    text = text.toLowerCase();
    char vordersterBuchstabe = text.charAt(0);


    for(int i = 0; i < text.length(); i++) {
      if(text.charAt(i) < vordersterBuchstabe){
        vordersterBuchstabe = text.charAt(i);
      }
    }
    return vordersterBuchstabe;
  }

  public int mitte(int a, int b, int c){
    if(a == b || a == c || b == c) {
      return -1;
    }
    int max;
    int min;

    if(a < b && a < c){
      min = a;
    } else if(b<c){
      min = b;
    } else {
      min = c;
    }
    if(a > b && a > c){
      max = a;
    } else if(b>c){
      max = b;
    } else {
      max = c;
    }
    int mittelwert = a+b+c-max-min;

    return mittelwert;

  }

  // HIER ENDET DER CODE FÜR DIE AUFGABEN
}
