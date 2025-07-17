package jnk.laborpruefung.labor19.aufgabe3;

import jnk.laborpruefung.labor19.base.TestBasisklasse;
import org.junit.Test;

import static junit.framework.Assert.*;

public class TestAdditionMitSpeicher extends TestBasisklasse {
    public static final String PACKAGE_NAME = "jnk.laborpruefung.labor19.aufgabe3";
    public static final String KLASSE_BEZEICHNER_ADDITION = "Addition";
    public static final String KLASSE_BEZEICHNER_ADDITION_MIT_SPEICHER = "AdditionMitSpeicher";
    public static final String INTERFACE_BEZEICHNER_GRUNDRECHENART = "Grundrechenart";
    public static final String METHODE_BEZEICHNER_AUSWERTEN = "auswerten";
    public static final String VARIABLE_BEZEICHNER_SPEICHER = "speicher";

    /**
     * Liefert das class-Objekt zu Addition.
     */
    public Class<?> getKlasseAddition() {
        Class<?> klasseAddition;
        try {
            klasseAddition = Class
                    .forName(PACKAGE_NAME + "." + KLASSE_BEZEICHNER_ADDITION);
            return klasseAddition;
        } catch (ClassNotFoundException e) {
            return null;
        }
    }

    /**
     * Liefert das class-Objekt zu AdditionMitSpeicher.
     */
    public Class<?> getKlasseAdditionMitSpeicher() {
        Class<?> klasseAdditionMitSpeicher;
        try {
            klasseAdditionMitSpeicher = Class.forName(
                    PACKAGE_NAME + "." + KLASSE_BEZEICHNER_ADDITION_MIT_SPEICHER);
            return klasseAdditionMitSpeicher;
        } catch (ClassNotFoundException e) {
            return null;
        }
    }

    @Test
    public void testAdditionMitSpeicher() {
        // Debugging
        System.out.println(
                "Teste Klasse " + KLASSE_BEZEICHNER_ADDITION_MIT_SPEICHER + " ...");

        Class<?> klasseAdditionMitSpeicher = getKlasseAdditionMitSpeicher();
        Object additionMitSpeicherInstanz = erzeugeInstanz(
                klasseAdditionMitSpeicher);
        Class<?> klasseAddition = getKlasseAddition();
        assertNotNull("Klasse " + KLASSE_BEZEICHNER_ADDITION + " nicht gefunden.",
                klasseAddition);
        assertNotNull("Klasse " + KLASSE_BEZEICHNER_ADDITION_MIT_SPEICHER
                + " nicht gefunden.", klasseAdditionMitSpeicher);

        // Vererbung
        Class<?> superclass = klasseAdditionMitSpeicher.getSuperclass();
        assertEquals("Klasse " + KLASSE_BEZEICHNER_ADDITION_MIT_SPEICHER
                        + " erbt nicht von " + KLASSE_BEZEICHNER_ADDITION, klasseAddition,
                superclass);

        // Objektvariable
        assertTrue(
                "Klasse " + KLASSE_BEZEICHNER_ADDITION_MIT_SPEICHER
                        + " hat nicht die Objektvariable " + VARIABLE_BEZEICHNER_SPEICHER,
                hatObjektVariable(klasseAdditionMitSpeicher,
                        VARIABLE_BEZEICHNER_SPEICHER, int.class));
        assertEquals(
                "Variable " + VARIABLE_BEZEICHNER_SPEICHER
                        + " ist nicht mit 0 initialisiert.",
                0, getWertObjektVariable(additionMitSpeicherInstanz,
                        VARIABLE_BEZEICHNER_SPEICHER));

    }

    @Test
    public void testAdditionMitSpeicherAuswerten() {
        // Debugging
        System.out.println("Teste Methode " + METHODE_BEZEICHNER_AUSWERTEN
                + " in Klasse " + KLASSE_BEZEICHNER_ADDITION_MIT_SPEICHER + " ...");

        Class<?> klasseAdditionMitSpeicher = getKlasseAdditionMitSpeicher();
        Object additionMitSpeicherInstanz = erzeugeInstanz(
                klasseAdditionMitSpeicher);

        Class<?>[] parameterTypListe = new Class<?>[]{int.class, int.class};

        Object[][] parameterListe = new Object[][]{new Object[]{23, 42},
                new Object[]{1, 2}, new Object[]{0, 0}};
        int[] erwartungswerte = new int[]{66, 5, 3};
        for (int i = 0; i < parameterListe.length; i++) {
            Object[] parameter = parameterListe[i];
            int erwartet = erwartungswerte[i];
            int wert = (int) werteMethodeAus(additionMitSpeicherInstanz,
                    METHODE_BEZEICHNER_AUSWERTEN, parameterTypListe, parameter);
            assertEquals(
                    "Methode " + METHODE_BEZEICHNER_AUSWERTEN + " liefert falschen Wert",
                    erwartet, wert);
            int speicher = (int) getWertObjektVariable(additionMitSpeicherInstanz,
                    VARIABLE_BEZEICHNER_SPEICHER);
            assertEquals("Objektvariable " + VARIABLE_BEZEICHNER_SPEICHER
                    + " hat falschen Wert", i + 1, speicher);

            // Debugging
            System.out.print(
                    "  " + parameter[0] + "," + parameter[1] + " -> " + wert + ", ");
            System.out.println("speicher: " + speicher);
        }

    }
}
