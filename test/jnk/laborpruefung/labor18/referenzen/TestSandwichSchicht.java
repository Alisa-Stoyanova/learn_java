package jnk.laborpruefung.labor18.referenzen;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class TestSandwichSchicht extends TestBasisklasse {

  public static final String PACKAGE_NAME = "jnk.laborpruefung.labor18.referenzen";
  public static final String SANDWICHSCHICHT_KLASSE_BEZEICHNER = "SandwichSchicht";
  public static final String METHODE_GET_OBERSTESCHICHT_BEZEICHNER = "getObersteSchicht";
  public static final String METHODE_EINFUEGEN_UEBER_BEZEICHNER = "einfuegenUeber";
  public static final String METHODE_ENTFERNEN_BEZEICHNER = "entfernen";

  /**
   * Liefert das class-Objekt zu Kontrollstrukturen.
   */
  public Class<?> getKlasseSandwichSchicht() {
    Class<?> klasseAufgabe1;
    try {
      klasseAufgabe1 = Class
          .forName(PACKAGE_NAME + "." + SANDWICHSCHICHT_KLASSE_BEZEICHNER);
      return klasseAufgabe1;
    } catch (ClassNotFoundException e) {
      assertTrue(
          "Klasse " + SANDWICHSCHICHT_KLASSE_BEZEICHNER + " nicht gefunden.",
          false);
      return null;
    }
  }

  @Test
  public void testGetObersteSchicht() {
    Class<?> sandwichSchichtKlasse = getKlasseSandwichSchicht();
    Class<?>[] parameterliste = new Class<?>[] {};
    assertTrue(
        "Klasse " + SANDWICHSCHICHT_KLASSE_BEZEICHNER
            + " hat nicht die Methode " + METHODE_GET_OBERSTESCHICHT_BEZEICHNER,
        hatMethode(sandwichSchichtKlasse, METHODE_GET_OBERSTESCHICHT_BEZEICHNER,
            parameterliste));

    SandwichSchicht gurke = new SandwichSchicht();
    SandwichSchicht kaese = new SandwichSchicht();
    gurke.setOben(kaese);
    kaese.setUnten(gurke);

    SandwichSchicht oberste = (SandwichSchicht) werteMethodeAus(gurke,
        METHODE_GET_OBERSTESCHICHT_BEZEICHNER, parameterliste, new Object[] {});
    assertEquals("Methode " + METHODE_GET_OBERSTESCHICHT_BEZEICHNER
        + " liefert nicht den geforderten Wert.", kaese, oberste);
    oberste = (SandwichSchicht) werteMethodeAus(kaese,
        METHODE_GET_OBERSTESCHICHT_BEZEICHNER, parameterliste, new Object[] {});
    assertEquals("Methode " + METHODE_GET_OBERSTESCHICHT_BEZEICHNER
        + " liefert nicht den geforderten Wert.", kaese, oberste);

  }

  @Test
  public void testEinfuegen() {
    Class<?> sandwichSchichtKlasse = getKlasseSandwichSchicht();
    Class<?>[] parameterliste = new Class<?>[] { sandwichSchichtKlasse };
    assertTrue(
        "Klasse " + SANDWICHSCHICHT_KLASSE_BEZEICHNER
            + " hat nicht die Methode " + METHODE_EINFUEGEN_UEBER_BEZEICHNER,
        hatMethode(sandwichSchichtKlasse, METHODE_EINFUEGEN_UEBER_BEZEICHNER,
            parameterliste));

    SandwichSchicht gurke = new SandwichSchicht();
    SandwichSchicht kaese = new SandwichSchicht();
    SandwichSchicht wurst = new SandwichSchicht();
    gurke.setOben(kaese);
    kaese.setUnten(gurke);

    werteMethodeAus(gurke, METHODE_EINFUEGEN_UEBER_BEZEICHNER, parameterliste,
        new Object[] { wurst });

    assertEquals("Falscher Aufbau des Sandwiches nach Aufruf von "
        + METHODE_EINFUEGEN_UEBER_BEZEICHNER, null, gurke.getUnten());
    assertEquals("Falscher Aufbau des Sandwiches nach Aufruf von "
        + METHODE_EINFUEGEN_UEBER_BEZEICHNER, wurst, gurke.getOben());
    assertEquals("Falscher Aufbau des Sandwiches nach Aufruf von "
        + METHODE_EINFUEGEN_UEBER_BEZEICHNER, gurke, wurst.getUnten());
    assertEquals("Falscher Aufbau des Sandwiches nach Aufruf von "
        + METHODE_EINFUEGEN_UEBER_BEZEICHNER, kaese, wurst.getOben());
    assertEquals("Falscher Aufbau des Sandwiches nach Aufruf von "
        + METHODE_EINFUEGEN_UEBER_BEZEICHNER, wurst, kaese.getUnten());
    assertEquals("Falscher Aufbau des Sandwiches nach Aufruf von "
        + METHODE_EINFUEGEN_UEBER_BEZEICHNER, null, kaese.getOben());

  }

  @Test
  public void testEntfernen() {
    Class<?> sandwichSchichtKlasse = getKlasseSandwichSchicht();
    Class<?>[] parameterliste = new Class<?>[] {};
    assertTrue(
        "Klasse " + SANDWICHSCHICHT_KLASSE_BEZEICHNER
            + " hat nicht die Methode " + METHODE_ENTFERNEN_BEZEICHNER,
        hatMethode(sandwichSchichtKlasse, METHODE_ENTFERNEN_BEZEICHNER,
            parameterliste));

    SandwichSchicht gurke = new SandwichSchicht();
    SandwichSchicht kaese = new SandwichSchicht();
    gurke.setOben(kaese);
    kaese.setUnten(gurke);

    werteMethodeAus(gurke, METHODE_ENTFERNEN_BEZEICHNER, parameterliste,
        new Object[] {});

    assertEquals("Falscher Aufbau des Sandwiches nach Aufruf von "
        + METHODE_ENTFERNEN_BEZEICHNER, null, gurke.getUnten());
    assertEquals("Falscher Aufbau des Sandwiches nach Aufruf von "
        + METHODE_ENTFERNEN_BEZEICHNER, null, gurke.getOben());
    assertEquals("Falscher Aufbau des Sandwiches nach Aufruf von "
        + METHODE_ENTFERNEN_BEZEICHNER, null, kaese.getUnten());
    assertEquals("Falscher Aufbau des Sandwiches nach Aufruf von "
        + METHODE_ENTFERNEN_BEZEICHNER, null, kaese.getOben());

    gurke = new SandwichSchicht();
    kaese = new SandwichSchicht();
    SandwichSchicht wurst = new SandwichSchicht();
    gurke.setOben(kaese);
    kaese.setUnten(gurke);
    kaese.setOben(wurst);
    wurst.setUnten(kaese);
    kaese.setUnten(gurke);

    werteMethodeAus(gurke, METHODE_ENTFERNEN_BEZEICHNER, parameterliste,
        new Object[] {});

    assertEquals("Falscher Aufbau des Sandwiches nach Aufruf von "
        + METHODE_ENTFERNEN_BEZEICHNER, null, gurke.getUnten());
    assertEquals("Falscher Aufbau des Sandwiches nach Aufruf von "
        + METHODE_ENTFERNEN_BEZEICHNER, null, gurke.getOben());
    assertEquals("Falscher Aufbau des Sandwiches nach Aufruf von "
        + METHODE_ENTFERNEN_BEZEICHNER, null, kaese.getUnten());
    assertEquals("Falscher Aufbau des Sandwiches nach Aufruf von "
        + METHODE_ENTFERNEN_BEZEICHNER, wurst, kaese.getOben());
    assertEquals("Falscher Aufbau des Sandwiches nach Aufruf von "
        + METHODE_ENTFERNEN_BEZEICHNER, kaese, wurst.getUnten());
    assertEquals("Falscher Aufbau des Sandwiches nach Aufruf von "
        + METHODE_ENTFERNEN_BEZEICHNER, null, wurst.getOben());

  }
}
