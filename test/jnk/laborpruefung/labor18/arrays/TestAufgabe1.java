package jnk.laborpruefung.labor18.arrays;

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

  public static final String PACKAGE_NAME = "jnk.laborpruefung.labor18.arrays";
  public static final String AUFGABE1_KLASSE_BEZEICHNER = "Aufgabe1";
  public static final String METHODE_KOPIE_BEZEICHNER = "kopie";
  public static final String METHODE_EINFUEGEN_BEZEICHNER = "einfuegen";
  public static final String METHODE_STRINGAUSCHARARRAY_BEZEICHNER = "stringAusCharArray";

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
  public void testKopie() {
    Class<?> aufgabe1Klasse = getKlasseAufgabe1();
    Class<?>[] parameterliste = new Class<?>[] { Bruch[].class };
    assertTrue(
        "Klasse " + AUFGABE1_KLASSE_BEZEICHNER + " hat nicht die Methode "
            + METHODE_KOPIE_BEZEICHNER,
        hatMethode(aufgabe1Klasse, METHODE_KOPIE_BEZEICHNER, parameterliste));

    Object instanzAufgabe1 = erzeugeInstanz(aufgabe1Klasse);
    assertNotNull("Klasse " + AUFGABE1_KLASSE_BEZEICHNER
        + " konnte nicht instanziiert werden.", instanzAufgabe1);

    List<Bruch[]> argumente = Arrays.asList(
        new Bruch[] { new Bruch(1, 3), new Bruch(3, 5) }, new Bruch[] {});

    for (int i = 0; i < argumente.size(); i++) {
      Bruch[] kopie = (Bruch[]) werteMethodeAus(instanzAufgabe1,
          METHODE_KOPIE_BEZEICHNER, parameterliste,
          new Object[] { argumente.get(i) });
      assertEquals(
          "Methode " + METHODE_KOPIE_BEZEICHNER
              + " liefert falsche Arraylänge.",
          argumente.get(i).length, kopie.length);
      // Paarweiser Vergleich der Objekte
      for (int j = 0; j < kopie.length; j++) {
        // Unterschiedliche Instanzen
        assertTrue("Keine tiefe Kopie - gleiche Instanzen",
            argumente.get(i)[j] != kopie[j]);
        // Gleicher Inhalt
        assertEquals("Elemente in der Kopie haben nicht den gleichen Inhalt",
            argumente.get(i)[j], kopie[j]);
      }
    }
  }

  @Test
  public void testEinfuegen() {
    Class<?> aufgabe1Klasse = getKlasseAufgabe1();
    Class<?>[] parameterliste = new Class<?>[] { double[].class, int.class,
        double.class };
    assertTrue(
        "Klasse " + AUFGABE1_KLASSE_BEZEICHNER + " hat nicht die Methode "
            + METHODE_EINFUEGEN_BEZEICHNER,
        hatMethode(aufgabe1Klasse, METHODE_EINFUEGEN_BEZEICHNER,
            parameterliste));

    Object instanzAufgabe1 = erzeugeInstanz(aufgabe1Klasse);
    assertNotNull("Klasse " + AUFGABE1_KLASSE_BEZEICHNER
        + " konnte nicht instanziiert werden.", instanzAufgabe1);

    List<Object[]> argumente = Arrays.asList(
        new Object[] { new double[] { 1.0, 2.0, 3.0 }, 1, 7.0 },
        new Object[] { new double[] { 1.0, 2.0, 3.0 }, 3, 7.0 });

    List<double[]> erwartungswerte = Arrays.asList(
        new double[] { 1.0, 7.0, 2.0, 3.0 },
        new double[] { 1.0, 2.0, 3.0, 7.0 });

    for (int i = 0; i < argumente.size(); i++) {
      double[] ist = (double[]) werteMethodeAus(instanzAufgabe1,
          METHODE_EINFUEGEN_BEZEICHNER, parameterliste, argumente.get(i));
      assertEquals(
          "Methode " + METHODE_EINFUEGEN_BEZEICHNER
              + " liefert falsche Arraylänge.",
          erwartungswerte.get(i).length, ist.length);
      // Paarweiser Vergleich der Objekte
      for (int j = 0; j < ist.length; j++) {
        assertEquals("", erwartungswerte.get(i)[j], ist[j], 1e-5);
      }
    }
  }

  @Test
  public void testStringAusCharArray() {
    Class<?> aufgabe1Klasse = getKlasseAufgabe1();
    Class<?>[] parameterliste = new Class<?>[] { char[].class };
    assertTrue(
        "Klasse " + AUFGABE1_KLASSE_BEZEICHNER + " hat nicht die Methode "
            + METHODE_STRINGAUSCHARARRAY_BEZEICHNER,
        hatMethode(aufgabe1Klasse, METHODE_STRINGAUSCHARARRAY_BEZEICHNER,
            parameterliste));

    Object instanzAufgabe1 = erzeugeInstanz(aufgabe1Klasse);
    assertNotNull("Klasse " + AUFGABE1_KLASSE_BEZEICHNER
        + " konnte nicht instanziiert werden.", instanzAufgabe1);

    List<Object[]> argumente = Arrays.asList(
        new Object[] { new char[] { 'H', 'a', 'l', 'l', 'o' } },
        new Object[] { new char[] { 'a', 'b', 'c' } });

    List<String> erwartungswerte = Arrays.asList("Hallo", "abc");

    for (int i = 0; i < argumente.size(); i++) {
      String ist = (String) werteMethodeAus(instanzAufgabe1,
          METHODE_STRINGAUSCHARARRAY_BEZEICHNER, parameterliste,
          argumente.get(i));
      assertEquals("Methode " + METHODE_STRINGAUSCHARARRAY_BEZEICHNER
          + " liefert falsches Ergbenis.", erwartungswerte.get(i), ist);
    }
  }
}
