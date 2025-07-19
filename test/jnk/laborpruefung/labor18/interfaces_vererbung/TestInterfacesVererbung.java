package jnk.laborpruefung.labor18.interfaces_vererbung;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Testklasse für die Übungslaborprüfung "Interfaces und Vererbung"
 * 
 * @author Philipp Jenke
 *
 */
public class TestInterfacesVererbung extends TestBasisklasse {

  public static final String PACKAGE_NAME = "jnk.laborpruefung.labor18.interfaces_vererbung";
  public static final String AFFE_KLASSE_BEZEICHNER = "Affe";
  public static final String SCHIMPANSE_KLASSE_BEZEICHNER = "Schimpanse";
  public static final String INTERFACE_SAEUGETIER_BEZEICHNER = "Saeugetier";
  public static final String BEZEICHNER_VARIABLE_NAME = "name";
  public static final String BEZEICHNER_VARIABLE_ALTER = "alter";
  public static final String BEZEICHNER_METHODE_GETNAME = "getName";
  public static final String BEZEICHNER_METHODE_EQUALS = "equals";

  /**
   * Liefert das class-Objekt zu Affe.
   */
  public Class<?> getKlasseAffe() {
    Class<?> klasseAffe;
    try {
      klasseAffe = Class.forName(PACKAGE_NAME + "." + AFFE_KLASSE_BEZEICHNER);
      return klasseAffe;
    } catch (ClassNotFoundException e) {
      assertTrue("Klasse " + AFFE_KLASSE_BEZEICHNER + " nicht gefunden.",
          false);
      return null;
    }
  }

  /**
   * Liefert das class-Objekt zu Schimpanse.
   */
  public Class<?> getKlasseSchimpanse() {
    Class<?> klasseAffe;
    try {
      klasseAffe = Class
          .forName(PACKAGE_NAME + "." + SCHIMPANSE_KLASSE_BEZEICHNER);
      return klasseAffe;
    } catch (ClassNotFoundException e) {
      assertTrue("Klasse " + SCHIMPANSE_KLASSE_BEZEICHNER + " nicht gefunden.",
          false);
      return null;
    }
  }

  private Class<?> getInterfaceSaeugetier() {
    Class<?> klasseAffe;
    try {
      klasseAffe = Class
          .forName(PACKAGE_NAME + "." + INTERFACE_SAEUGETIER_BEZEICHNER);
      return klasseAffe;
    } catch (ClassNotFoundException e) {
      assertTrue(
          "Interface " + INTERFACE_SAEUGETIER_BEZEICHNER + " nicht gefunden.",
          false);
      return null;
    }
  }

  @Test
  public void testAffe() {
    Class<?> klasseAffe = getKlasseAffe();
    Class<?> interfaceSaegetier = getInterfaceSaeugetier();
    assertNotNull("Klasse " + AFFE_KLASSE_BEZEICHNER + " nicht gefunden.",
        klasseAffe);

    // Implementiert Interface
    assertTrue(
        "Klasse " + AFFE_KLASSE_BEZEICHNER
            + " implementiert nicht das Interface "
            + INTERFACE_SAEUGETIER_BEZEICHNER,
        testImplementiertInterface(klasseAffe, interfaceSaegetier));

    // Variable name
    assertTrue("Variable " + BEZEICHNER_VARIABLE_NAME + " fehlt.",
        hatObjektVariable(klasseAffe, BEZEICHNER_VARIABLE_NAME, String.class));
    assertTrue(
        "Variable " + BEZEICHNER_VARIABLE_NAME
            + " hat nicht die richtige Sichtbarkeit",
        objektvariablenHatModifizierer(klasseAffe, BEZEICHNER_VARIABLE_NAME,
            istPrivate));

    // Konstruktor
    Class<?>[] konstruktorParameterTypen = new Class<?>[] { String.class };
    assertTrue(
        "Klasse " + AFFE_KLASSE_BEZEICHNER
            + " hat nicht geforderten Konstruktor.",
        hatKonstruktor(klasseAffe, konstruktorParameterTypen));

    Object affeMike = erzeugeInstanz(klasseAffe, konstruktorParameterTypen,
        new Object[] { "Mike" });
    String name = (String) getWertObjektVariable(affeMike,
        BEZEICHNER_VARIABLE_NAME);
    assertEquals("Variable " + BEZEICHNER_VARIABLE_NAME
        + "hat nicht korrekten Wert nach Konstruktoraufruf", "Mike", name);
    assertEquals(
        "Variable " + BEZEICHNER_VARIABLE_NAME
            + "hat nicht korrekten Wert nach Konstruktoraufruf",
        "Mike", werteMethodeAus(affeMike, BEZEICHNER_METHODE_GETNAME));
  }

  @Test
  public void testSchimpanse() {
    Class<?> klasseAffe = getKlasseAffe();
    Class<?> klasseSchimpanse = getKlasseSchimpanse();
    assertNotNull("Klasse " + SCHIMPANSE_KLASSE_BEZEICHNER + " nicht gefunden.",
        klasseSchimpanse);

    // Erbt von Affe
    assertTrue(
        "Klasse " + SCHIMPANSE_KLASSE_BEZEICHNER + " erbt nicht von Klasse "
            + AFFE_KLASSE_BEZEICHNER,
        testErbtVon(klasseSchimpanse, klasseAffe));

    // Variable name
    assertTrue("Variable " + BEZEICHNER_VARIABLE_ALTER + " fehlt.",
        hatObjektVariable(klasseSchimpanse, BEZEICHNER_VARIABLE_ALTER,
            int.class));
    assertTrue(
        "Variable " + BEZEICHNER_VARIABLE_ALTER
            + " hat nicht die richtige Sichtbarkeit",
        objektvariablenHatModifizierer(klasseSchimpanse,
            BEZEICHNER_VARIABLE_ALTER, istPrivate));

    // Konstruktor
    Class<?>[] konstruktorParameterTypen = new Class<?>[] { String.class,
        int.class };
    assertTrue(
        "Klasse " + SCHIMPANSE_KLASSE_BEZEICHNER
            + " hat nicht geforderten Konstruktor.",
        hatKonstruktor(klasseSchimpanse, konstruktorParameterTypen));

    Object schimpanseHelga = erzeugeInstanz(klasseSchimpanse,
        konstruktorParameterTypen, new Object[] { "Helga", 23 });
    String name = (String) werteMethodeAus(schimpanseHelga,
        BEZEICHNER_METHODE_GETNAME);
    int alter = (Integer) getWertObjektVariable(schimpanseHelga,
        BEZEICHNER_VARIABLE_ALTER);
    assertEquals(
        "Variable " + BEZEICHNER_VARIABLE_NAME
            + " hat nicht korrekten Wert nach Konstruktoraufruf",
        "Helga", name);
    assertEquals("Variable " + BEZEICHNER_VARIABLE_ALTER
        + " hat nicht korrekten Wert nach Konstruktoraufruf", 23, alter);
  }

  @Test
  public void testEquals() {
    Class<?> klasseAffe = getKlasseAffe();
    Class<?> klasseSchimpanse = getKlasseSchimpanse();
    assertNotNull("Klasse " + SCHIMPANSE_KLASSE_BEZEICHNER + " nicht gefunden.",
        klasseSchimpanse);

    Class<?>[] konstruktorAffeParameterTypen = new Class<?>[] { String.class };
    Class<?>[] konstruktorSchimpanseParameterTypen = new Class<?>[] {
        String.class, int.class };
    Object schimpanseHelga = erzeugeInstanz(klasseSchimpanse,
        konstruktorSchimpanseParameterTypen, new Object[] { "Helga", 23 });
    Object schimpanseHelga2 = erzeugeInstanz(klasseSchimpanse,
        konstruktorSchimpanseParameterTypen, new Object[] { "Helga", 23 });
    Object schimpanseMike = erzeugeInstanz(klasseSchimpanse,
        konstruktorSchimpanseParameterTypen, new Object[] { "Mike", 23 });
    Object affeMike = erzeugeInstanz(klasseAffe, konstruktorAffeParameterTypen,
        new Object[] { "Mike" });

    Class<?>[] equalsParameterTypen = new Class<?>[] { Object.class };
    assertTrue("Methode " + BEZEICHNER_METHODE_EQUALS + " fehlt.", hatMethode(
        klasseSchimpanse, BEZEICHNER_METHODE_EQUALS, equalsParameterTypen));
    assertEquals(
        "Methode " + BEZEICHNER_METHODE_EQUALS + " hat falschen Rückgabetyp",
        boolean.class, getRueckgabeTyp(klasseSchimpanse,
            BEZEICHNER_METHODE_EQUALS, equalsParameterTypen));

    assertTrue(
        "Methode " + BEZEICHNER_METHODE_EQUALS + " liefert falsches Ergebnis.",
        (Boolean) werteMethodeAus(schimpanseHelga, BEZEICHNER_METHODE_EQUALS,
            equalsParameterTypen, new Object[] { schimpanseHelga }));
    assertTrue(
        "Methode " + BEZEICHNER_METHODE_EQUALS + " liefert falsches Ergebnis.",
        (Boolean) werteMethodeAus(schimpanseHelga, BEZEICHNER_METHODE_EQUALS,
            equalsParameterTypen, new Object[] { schimpanseHelga2 }));
    assertFalse(
        "Methode " + BEZEICHNER_METHODE_EQUALS + " liefert falsches Ergebnis.",
        (Boolean) werteMethodeAus(schimpanseHelga, BEZEICHNER_METHODE_EQUALS,
            equalsParameterTypen, new Object[] { schimpanseMike }));
    assertFalse(
        "Methode " + BEZEICHNER_METHODE_EQUALS + " liefert falsches Ergebnis.",
        (Boolean) werteMethodeAus(schimpanseHelga, BEZEICHNER_METHODE_EQUALS,
            equalsParameterTypen, new Object[] { affeMike }));
  }

}
