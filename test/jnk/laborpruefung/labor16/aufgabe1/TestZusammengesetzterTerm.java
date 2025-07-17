package jnk.laborpruefung.labor16.aufgabe1;

import jnk.laborpruefung.labor16.base.TestBasisklasse;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Testklasse für @ZusammengesetzterTerm
 *
 * @author Philipp Jenke
 */
public class TestZusammengesetzterTerm extends TestBasisklasse {

    private static String BEZEICHNER_ENUM = "Grundrechenart";
    private static String BEZEICHNER_OPERAND1 = "operand1";
    private static String BEZEICHNER_OPERAND2 = "operand2";
    private static String BEZEICHNER_OPERATOR = "operator";
    private static String KONSTANTE_PLUS = "PLUS";
    private static String KONSTANTE_MINUS = "MINUS";
    private static String KONSTANTE_MAL = "MAL";
    private static String KONSTANTE_GETEILT = "GETEILT";
    private static String METHODEN_BEZEICHNER_GET_WERT = "getWert";
    private static String METHODEN_BEZEICHNER_TO_STRING = "toString";

    /**
     * Erzeuge ZahlTerm-Objekt.
     */
    private Object erzeugeZahlTerm(double zahl) {
        Class<?>[] typen = {double.class};
        Object[] werte = {zahl};
        Object term = erzeugeInstanz(ZahlTerm.class, typen, werte);
        return term;
    }

    /**
     * Erzeuge ZusammengesetzterTerm-Objekt.
     */
    private Object erzeugeZusammengesetzerTerm(Object rechenart, Object operand1,
                                               Object operand2) {
        Class<?> enumKlasse = getEnum(ZusammengesetzterTerm.class, BEZEICHNER_ENUM);
        Class<?>[] typen = {enumKlasse, Term.class, Term.class,};
        Object[] werte = {rechenart, operand1, operand2};
        Object term = erzeugeInstanz(ZusammengesetzterTerm.class, typen, werte);
        return term;
    }

    @Test
    public void testeKlassenSignatur() {
        assertTrue(
                "Klasse ZusammengesetzterTerm implementiert nicht das geforderte Interface.",
                testImplementiertInterface(ZusammengesetzterTerm.class, Term.class));
    }

    @Test
    public void testEnum() {
        Class<?> enumKlasse = getEnum(ZusammengesetzterTerm.class, BEZEICHNER_ENUM);
        assertNotNull("Enum " + BEZEICHNER_ENUM + " nicht gefunden.", enumKlasse);
    }

    @Test
    public void testEnumKonstanten() {
        Class<?> enumKlasse = getEnum(ZusammengesetzterTerm.class, BEZEICHNER_ENUM);
        assertNotNull("Enum-Konstanten nicht gefunden.", enumKlasse);
        Object[] enumKonstanten = getEnumKonstanten(enumKlasse);
        List<String> vorhandeneKonstanten = new ArrayList<String>();
        for (Object enumKonstante : enumKonstanten) {
            vorhandeneKonstanten.add(enumKonstante.toString());
        }
        assertTrue("Enum-Konstante " + KONSTANTE_PLUS + " nicht gefunden.",
                vorhandeneKonstanten.contains(KONSTANTE_PLUS));
        assertTrue("Enum-Konstante " + KONSTANTE_MINUS + " nicht gefunden.",
                vorhandeneKonstanten.contains(KONSTANTE_MINUS));
        assertTrue("Enum-Konstante " + KONSTANTE_MAL + " nicht gefunden.",
                vorhandeneKonstanten.contains(KONSTANTE_MAL));
        assertTrue("Enum-Konstante " + KONSTANTE_GETEILT + " nicht gefunden.",
                vorhandeneKonstanten.contains(KONSTANTE_GETEILT));
    }

    @Test
    public void testeObjektvariablen() {
        assertTrue(
                "Klasse ZusammengesetzerTerm hat nicht geforderte Objektvariable "
                        + BEZEICHNER_OPERAND1,
                testHatObjektVariable(ZusammengesetzterTerm.class, BEZEICHNER_OPERAND1,
                        Term.class));
        assertTrue(
                "Klasse ZusammengesetzerTerm hat nicht geforderte Objektvariable "
                        + BEZEICHNER_OPERAND2,
                testHatObjektVariable(ZusammengesetzterTerm.class, BEZEICHNER_OPERAND2,
                        Term.class));
        Class<?> enumKlasse = getEnum(ZusammengesetzterTerm.class, BEZEICHNER_ENUM);
        assertTrue(
                "Klasse ZusammengesetzerTerm hat nicht geforderte Objektvariable "
                        + BEZEICHNER_OPERATOR,
                testHatObjektVariable(ZusammengesetzterTerm.class, BEZEICHNER_OPERATOR,
                        enumKlasse));
    }

    @Test
    public void testGetWert() {
        Class<?>[] parameter = {};
        assertTrue(
                "Klasse ZusammengesetzterTerm hat nicht geforderte Methode "
                        + METHODEN_BEZEICHNER_GET_WERT + ".",
                hatMethode(ZusammengesetzterTerm.class, METHODEN_BEZEICHNER_GET_WERT,
                        parameter));

        assertTrue(
                "Methode " + METHODEN_BEZEICHNER_GET_WERT + " hat falschen Rückgabetyp",
                getRueckgabeTyp(ZusammengesetzterTerm.class,
                        METHODEN_BEZEICHNER_GET_WERT, parameter) == double.class);

        Object operator = getOperator(KONSTANTE_PLUS);
        Object operand1 = erzeugeZahlTerm(2);
        Object operand2 = erzeugeZahlTerm(3);
        Object zusammengesetzterTerm =
                erzeugeZusammengesetzerTerm(operator, operand1, operand2);

        // Werte getWert() aus
        Object ergebnis =
                werteMethodeAus(zusammengesetzterTerm, METHODEN_BEZEICHNER_GET_WERT);
        assertNotNull("Methode " + METHODEN_BEZEICHNER_GET_WERT
                + " liefert falsches Ergebnis.", ergebnis);

        // Assert auf Ergebnis
        Double doubleWert = (Double) ergebnis;
        double erwartetesErgebnis = 5;
        assertTrue(
                "Methode " + METHODEN_BEZEICHNER_GET_WERT
                        + " liefert nicht korrekten Wert.",
                Math.abs(doubleWert.doubleValue() - erwartetesErgebnis) < 1e-5);
    }

    @Test
    public void testGetWertVerschachtelt() {
        Class<?>[] parameter = {};
        assertTrue(
                "Klasse ZusammengesetzterTerm hat nicht geforderte Methode "
                        + METHODEN_BEZEICHNER_GET_WERT + ".",
                hatMethode(ZusammengesetzterTerm.class, METHODEN_BEZEICHNER_GET_WERT,
                        parameter));

        assertTrue(
                "Methode " + METHODEN_BEZEICHNER_GET_WERT
                        + " hat falschen Rückgabetyp.",
                getRueckgabeTyp(ZusammengesetzterTerm.class,
                        METHODEN_BEZEICHNER_GET_WERT, parameter) == double.class);

        Object operator = getOperator(KONSTANTE_PLUS);
        Object operand1 = erzeugeZahlTerm(2);
        Object operand2 = erzeugeZahlTerm(3);
        Object operator2 = getOperator(KONSTANTE_MAL);
        Object operand3 = erzeugeZahlTerm(1.5);
        Object zwischenTerm =
                erzeugeZusammengesetzerTerm(operator, operand1, operand2);
        Object zusammengesetzterTerm =
                erzeugeZusammengesetzerTerm(operator2, zwischenTerm, operand3);

        // Werte getWert() aus
        Object ergebnis =
                werteMethodeAus(zusammengesetzterTerm, METHODEN_BEZEICHNER_GET_WERT);
        assertNotNull("Methode " + METHODEN_BEZEICHNER_GET_WERT
                + " liefert falsches Ergebnis.", ergebnis);

        // Assert auf Ergebnis
        Double doubleWert = (Double) ergebnis;
        double erwartetesErgebnis = 7.5;
        assertTrue(
                "Methode " + METHODEN_BEZEICHNER_GET_WERT
                        + " liefert nicht korrekten Wert.",
                Math.abs(doubleWert.doubleValue() - erwartetesErgebnis) < 1e-5);
    }

    private Object getOperator(String konstante) {
        Class<?> enumKlasse = getEnum(ZusammengesetzterTerm.class, BEZEICHNER_ENUM);
        return getEnumKonstante(enumKlasse, konstante);
    }

    @Test
    public void testeToString() {
        Class<?>[] parameter = {};
        assertTrue(
                "Klasse ZusammengesetzterTerm hat nicht geforderte Methode "
                        + METHODEN_BEZEICHNER_TO_STRING + ".",
                hatMethode(ZusammengesetzterTerm.class, METHODEN_BEZEICHNER_TO_STRING,
                        parameter));

        assertTrue(
                "Methode " + METHODEN_BEZEICHNER_TO_STRING
                        + " hat falschen Rückgabetyp.",
                getRueckgabeTyp(ZusammengesetzterTerm.class,
                        METHODEN_BEZEICHNER_TO_STRING, parameter) == String.class);

        // Erzeuge zusammengesetzten Term ((2+3)*1.5)
        Object operator = getOperator(KONSTANTE_PLUS);
        Object operand1 = erzeugeZahlTerm(2);
        Object operand2 = erzeugeZahlTerm(3);
        Object operator2 = getOperator(KONSTANTE_MAL);
        Object operand3 = erzeugeZahlTerm(1.5);
        Object zwischenTerm =
                erzeugeZusammengesetzerTerm(operator, operand1, operand2);
        Object zusammengesetzterTerm =
                erzeugeZusammengesetzerTerm(operator2, zwischenTerm, operand3);

        // Methodenaufruf toString()
        Object[] argumente = {};
        Class<?>[] methodenParameter = {};
        Object ergebnis = werteMethodeAus(zusammengesetzterTerm,
                METHODEN_BEZEICHNER_TO_STRING, methodenParameter, argumente);
        assertTrue("Ungültige Rückgabe bei " + METHODEN_BEZEICHNER_TO_STRING,
                ergebnis != null && ergebnis instanceof String);
        String stringErgebnis = (String) ergebnis;

        // Assert auf Ergebnis
        String erwartungKomma = "((2.00 + 3.00) * 1.50)";
        String erwartungPunkt = "((2,00 + 3,00) * 1,50)";
        assertTrue(
                "Term wird durch " + METHODEN_BEZEICHNER_TO_STRING
                        + " falsch dargestellt (erwartet: " + erwartungKomma + ", ergebnis:"
                        + stringErgebnis + ").",
                stringErgebnis.equals(erwartungKomma)
                        || stringErgebnis.equals(erwartungPunkt));
    }
}
