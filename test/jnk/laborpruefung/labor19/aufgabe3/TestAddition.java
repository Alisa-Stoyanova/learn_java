package jnk.laborpruefung.labor19.aufgabe3;

import jnk.laborpruefung.labor19.base.TestBasisklasse;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;

public class TestAddition extends TestBasisklasse {

    public static final String PACKAGE_NAME = "jnk.laborpruefung.labor19.aufgabe3";
    public static final String KLASSE_BEZEICHNER_ADDITION = "Addition";
    public static final String INTERFACE_BEZEICHNER_GRUNDRECHENART = "Grundrechenart";
    public static final String METHODE_BEZEICHNER_AUSWERTEN = "auswerten";
    public static final String METHODE_BEZEICHNER_GET_SYMBOL = "getSymbol";

    /**
     * Liefert das class-Objekt zu Grundrechenart.
     */
    public Class<?> getInterfaceGrundrechenart() {
        Class<?> interfaceGrundrechenart;
        try {
            interfaceGrundrechenart = Class
                    .forName(PACKAGE_NAME + "." + INTERFACE_BEZEICHNER_GRUNDRECHENART);
            return interfaceGrundrechenart;
        } catch (ClassNotFoundException e) {
            return null;
        }
    }

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

    @Test
    public void testAddition() {
        // Debugging
        System.out
                .println("Teste Interface " + KLASSE_BEZEICHNER_ADDITION + " ...");

        Class<?> klasseAddition = getKlasseAddition();
        assertNotNull("Klasse " + KLASSE_BEZEICHNER_ADDITION + " nicht gefunden.",
                klasseAddition);
        Object additionInstanz = erzeugeInstanz(klasseAddition);

        // Prüfe interface
        Class<?>[] interfaces = klasseAddition.getInterfaces();
        assertEquals("Klasse " + KLASSE_BEZEICHNER_ADDITION
                + " implementiert nicht (nur) das Interface "
                + INTERFACE_BEZEICHNER_GRUNDRECHENART, 1, interfaces.length);
        Class<?> interfaceGrundrechenart = getInterfaceGrundrechenart();
        assertNotNull(
                "Interface " + INTERFACE_BEZEICHNER_GRUNDRECHENART + " ungültig.",
                interfaceGrundrechenart);
        assertEquals(
                "Klasse " + KLASSE_BEZEICHNER_ADDITION
                        + " implementiert nicht das Interface "
                        + INTERFACE_BEZEICHNER_GRUNDRECHENART,
                interfaceGrundrechenart, interfaces[0]);

        // Debugging
        System.out.println("  Interface: " + interfaces[0]);

        // Auswerten
        Class<?>[] parameterTypenAuswerten = new Class<?>[]{int.class,
                int.class};
        Object[] testParameter = {new Integer[]{23, 42},
                new Integer[]{-1, 2}, new Integer[]{0, 0}};
        int[] testErwartungswerte = {65, 1, 0};
        for (int i = 0; i < testParameter.length; i++) {
            Object[] param = (Object[]) testParameter[i];
            int expected = testErwartungswerte[i];
            int wert = (int) werteMethodeAus(additionInstanz,
                    METHODE_BEZEICHNER_AUSWERTEN, parameterTypenAuswerten, param);
            assertEquals(METHODE_BEZEICHNER_AUSWERTEN + "(): Erwartungswert: "
                    + expected + " , erhalten: " + wert, wert, expected, 1e-5);

            // Debugging
            System.out.println(
                    "  " + param[0] + "," + param[1] + " -> " + expected + "/" + wert);
        }

        // Symbol
        Class<?>[] parameterTypenGetSymbol = new Class<?>[]{};
        String wert = (String) werteMethodeAus(additionInstanz,
                METHODE_BEZEICHNER_GET_SYMBOL, parameterTypenGetSymbol,
                new Object[]{});
        assertEquals(
                "Methode " + METHODE_BEZEICHNER_GET_SYMBOL + " liefert falsches Symbol",
                "+", wert);

        // Debugging
        System.out.println("Symbol: " + wert);
    }
}
