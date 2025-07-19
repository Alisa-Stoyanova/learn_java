package jnk.laborpruefung.labor18.schleifen;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

/**
 * Testklasse für die Übungs-Laborprüfung Summen und Ausdrücke
 * 
 * @author Philipp Jenke
 *
 */
public class TestAufgabe1 extends TestBasisklasse {

  public static final String PACKAGE_NAME = "jnk.laborpruefung.labor18.schleifen";
  public static final String AUFGABE1_KLASSE_BEZEICHNER = "Aufgabe1";
  public static final String METHODE_SUMMEQUADRATE_BEZEICHNER = "summeQuadrate";
  public static final String METHODE_VORNEIMALPHABET_BEZEICHNER = "vorneImAlphabet";
  public static final String METHODE_MITTE_BEZEICHNER = "mitte";

  /**
   * Liefert das class-Objekt zu Kontrollstrukturen.
   */
  public Class<?> getKlasseAufgabe1() {
    Class<?> klasseAufgabe1;
    try {
      klasseAufgabe1 = Class
          .forName(PACKAGE_NAME + "." + AUFGABE1_KLASSE_BEZEICHNER);
      return klasseAufgabe1;
    } catch (ClassNotFoundException e) {
      assertTrue("Klasse " + AUFGABE1_KLASSE_BEZEICHNER + " nicht gefunden.",
          false);
      return null;
    }
  }

  @Test
  public void testSummeQuadrate() {
    Class<?> aufgabe1Klasse = getKlasseAufgabe1();
    Class<?>[] parameterliste = new Class<?>[] { int.class };
    assertTrue(
        "Klasse " + AUFGABE1_KLASSE_BEZEICHNER + " hat nicht die Methode "
            + METHODE_SUMMEQUADRATE_BEZEICHNER,
        hatMethode(aufgabe1Klasse, METHODE_SUMMEQUADRATE_BEZEICHNER,
            parameterliste));

    Object instanzAufgabe1 = erzeugeInstanz(aufgabe1Klasse);
    assertNotNull("Klasse " + AUFGABE1_KLASSE_BEZEICHNER
        + " konnte nicht instanziiert werden.", instanzAufgabe1);

    List<Integer> erwartungswerte = Arrays.asList(5, 30);
    List<Integer> argumente = Arrays.asList(2, 4);

    for (int i = 0; i < erwartungswerte.size(); i++) {
      assertEquals(
          "Methode " + METHODE_SUMMEQUADRATE_BEZEICHNER
              + " liefert falschen Wert",
          erwartungswerte.get(i),
          werteMethodeAus(instanzAufgabe1, METHODE_SUMMEQUADRATE_BEZEICHNER,
              parameterliste, new Object[] { argumente.get(i) }));
    }
  }

  @Test
  public void testVorneImAlphabet() {
    Class<?> aufgabe1Klasse = getKlasseAufgabe1();
    Class<?>[] parameterliste = new Class<?>[] { String.class };
    assertTrue(
        "Klasse " + AUFGABE1_KLASSE_BEZEICHNER + " hat nicht die Methode "
            + METHODE_VORNEIMALPHABET_BEZEICHNER,
        hatMethode(aufgabe1Klasse, METHODE_VORNEIMALPHABET_BEZEICHNER,
            parameterliste));

    Object instanzAufgabe1 = erzeugeInstanz(aufgabe1Klasse);
    assertNotNull("Klasse " + AUFGABE1_KLASSE_BEZEICHNER
        + " konnte nicht instanziiert werden.", instanzAufgabe1);

    List<Character> erwartungswerte = Arrays.asList('a', 'y');
    List<String> argumente = Arrays.asList("hallowelt", "zzzzzyzzz");

    for (int i = 0; i < erwartungswerte.size(); i++) {
      assertEquals(
          "Methode " + METHODE_VORNEIMALPHABET_BEZEICHNER
              + " liefert falschen Wert",
          erwartungswerte.get(i),
          werteMethodeAus(instanzAufgabe1, METHODE_VORNEIMALPHABET_BEZEICHNER,
              parameterliste, new Object[] { argumente.get(i) }));
    }
  }

  @Test
  public void testVorneImAlphabetMitGrossbuchstaben() {
    Class<?> aufgabe1Klasse = getKlasseAufgabe1();
    Class<?>[] parameterliste = new Class<?>[] { String.class };
    assertTrue(
        "Klasse " + AUFGABE1_KLASSE_BEZEICHNER + " hat nicht die Methode "
            + METHODE_VORNEIMALPHABET_BEZEICHNER,
        hatMethode(aufgabe1Klasse, METHODE_VORNEIMALPHABET_BEZEICHNER,
            parameterliste));

    Object instanzAufgabe1 = erzeugeInstanz(aufgabe1Klasse);
    assertNotNull("Klasse " + AUFGABE1_KLASSE_BEZEICHNER
        + " konnte nicht instanziiert werden.", instanzAufgabe1);

    List<Character> erwartungswerte = Arrays.asList('a', 'a');
    List<String> argumente = Arrays.asList("HalloWelt", "hALLOwELT");

    for (int i = 0; i < erwartungswerte.size(); i++) {
      assertEquals(
          "Methode " + METHODE_VORNEIMALPHABET_BEZEICHNER
              + " liefert falschen Wert",
          erwartungswerte.get(i),
          werteMethodeAus(instanzAufgabe1, METHODE_VORNEIMALPHABET_BEZEICHNER,
              parameterliste, new Object[] { argumente.get(i) }));
    }
  }

  @Test
  public void testMitte() {
    Class<?> aufgabe1Klasse = getKlasseAufgabe1();
    Class<?>[] parameterliste = new Class<?>[] { int.class, int.class,
        int.class };
    assertTrue(
        "Klasse " + AUFGABE1_KLASSE_BEZEICHNER + " hat nicht die Methode "
            + METHODE_MITTE_BEZEICHNER,
        hatMethode(aufgabe1Klasse, METHODE_MITTE_BEZEICHNER, parameterliste));

    Object instanzAufgabe1 = erzeugeInstanz(aufgabe1Klasse);
    assertNotNull("Klasse " + AUFGABE1_KLASSE_BEZEICHNER
        + " konnte nicht instanziiert werden.", instanzAufgabe1);

    List<Integer> erwartungswerte = Arrays.asList(2, 99);
    List<Object[]> argumente = Arrays.asList(new Object[] { 2, 1, 3 },
        new Object[] { -1, 100, 99 });

    for (int i = 0; i < erwartungswerte.size(); i++) {
      assertEquals(
          "Methode " + METHODE_MITTE_BEZEICHNER + " liefert falschen Wert",
          erwartungswerte.get(i),
          werteMethodeAus(instanzAufgabe1, METHODE_MITTE_BEZEICHNER,
              parameterliste, argumente.get(i)));
    }
  }
}
