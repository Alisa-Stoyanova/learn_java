package jnk.laborpruefung.labor18.referenzen;

/**
 * Eine SandwichEbene steckt zwischen zwei anderen SandwichSchichten (oben und
 * unten). Handelt es sich um die oberste SandwichSchicht, dann ist oben null,
 * handelt es sich um die unterste SandwichSchicht, dann ist unten null.
 * 
 * @author Philipp Jenke
 *
 */
public class SandwichSchicht {
  /**
   * Referenz auf die SandwichEbene, die über der this-SandwichSchicht hängt.
   */
  private SandwichSchicht oben;

  /**
   * Referenz auf die SandwichEbene, die unter der this-SandwichSchicht hängt.
   */
  private SandwichSchicht unten;

  public SandwichSchicht getOben() {
    return oben;
  }

  public void setOben(SandwichSchicht oben) {
    this.oben = oben;
    if (oben != null && oben.getUnten() != this) {
      oben.setUnten(this);
    }
  }

  public SandwichSchicht getUnten() {
    return unten;
  }

  public void setUnten(SandwichSchicht unten) {
    this.unten = unten;
    if (unten != null && unten.getOben() != this) {
      unten.setOben(this);
    }
  }

  // HIER BEGINNT DER CODE FÜR DIE AUFGABEN

  public SandwichSchicht getObersteSchicht(){
    if(oben == null) {
      return this;
    } else {
      return oben.getObersteSchicht();
    }
  }

  public void einfuegenUeber(SandwichSchicht neueSandwichSchicht) {
    if(oben !=null){
      oben.setUnten(neueSandwichSchicht);
    } else {
      neueSandwichSchicht.setOben(null);
    }
    neueSandwichSchicht.setOben(oben);
    neueSandwichSchicht.setUnten(this);

    this.setOben(neueSandwichSchicht);
  }

  public void entfernen() {
    if(oben !=null){
      oben.setUnten(unten);
    }
    if(unten != null) {
      unten.setOben(oben);
    }

    oben = null;
    unten = null;
  }

  // HIER ENDET DER CODE FÜR DIE AUFGABEN
}
