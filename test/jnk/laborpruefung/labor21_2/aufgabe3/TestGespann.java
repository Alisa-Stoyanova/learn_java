package jnk.laborpruefung.labor21_2.aufgabe3;

import jnk.laborpruefung.labor21_2.LaborpruefungException;
import jnk.laborpruefung.labor21_2.TestBasisklasse;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Testklasse für Gespanne (Kutsche + Pferde) - Aufgabe 3.
 */
public class TestGespann extends TestBasisklasse {

    private static final String BEZEICHNER_METHODE_EINSPANNEN = "einspannen";
    private static final Class<?> kutscheClass = Kutsche.class;
    private static final Class<?>[] einspannenParamTypes = new Class<?>[]{Pferd.class};
    private static final String BEZEICHNER_VARIABLE_PFERD = "pferd";
    private static final String BEZEICHNER_METHODE_GET_ANZAHL_PFERDE = "getAnzahlPferde";
    private static final Class<?>[] getAnzahlPferdeParamTypes = new Class<?>[]{};
    private static final String BEZEICHNER_METHODE_AUSSPANNEN = "ausspannen";
    private static final Class<?>[] ausspannenParamTypes = new Class<?>[]{int.class, int.class};

    @Test
    public void testGetAnzahlPferdeSignatur() {
        try {
            assertTrue(hatMethode(kutscheClass, BEZEICHNER_METHODE_GET_ANZAHL_PFERDE, getAnzahlPferdeParamTypes),
                    "Methode " + BEZEICHNER_METHODE_GET_ANZAHL_PFERDE + " nicht gefunden.");
            assertTrue(methodeHatModifizierer(kutscheClass, BEZEICHNER_METHODE_GET_ANZAHL_PFERDE, getAnzahlPferdeParamTypes, istPublic),
                    "Methode " + BEZEICHNER_METHODE_GET_ANZAHL_PFERDE + " hat nicht den richtigen Modifizierer.");
            assertEquals(int.class, getRueckgabeTyp(kutscheClass, BEZEICHNER_METHODE_GET_ANZAHL_PFERDE,
                            getAnzahlPferdeParamTypes),
                    "Methode " + BEZEICHNER_METHODE_GET_ANZAHL_PFERDE + " hat falschen Rückgabetyp");
        } catch (LaborpruefungException e) {
            assertTrue(false, "Fehler bei der Methode " + BEZEICHNER_METHODE_GET_ANZAHL_PFERDE);
        }
    }

    @Test
    public void testGetAnzahlPferde() {
        try {
            // Kein Pferd
            Kutsche kutsche = new Kutsche();
            Object ist = methodeAufrufen(kutsche, BEZEICHNER_METHODE_GET_ANZAHL_PFERDE, getAnzahlPferdeParamTypes,
                    new Object[]{});
            assertEquals(0, ist, "Falsche Rückgabe bei " + BEZEICHNER_METHODE_GET_ANZAHL_PFERDE);
            // Ein Pferd
            Pferd pferd1 = new Pferd("Pferd 1");
            setPferd(kutsche, pferd1);
            ist = methodeAufrufen(kutsche, BEZEICHNER_METHODE_GET_ANZAHL_PFERDE, getAnzahlPferdeParamTypes,
                    new Object[]{});
            assertEquals(1, ist, "Falsche Rückgabe bei " + BEZEICHNER_METHODE_GET_ANZAHL_PFERDE);
            // Zwei Pferde
            Pferd pferd2 = new Pferd("Pferd 2");
            pferd1.setDavorPferd(pferd2);
            ist = methodeAufrufen(kutsche, BEZEICHNER_METHODE_GET_ANZAHL_PFERDE, getAnzahlPferdeParamTypes,
                    new Object[]{});
            assertEquals(2, ist, "Falsche Rückgabe bei " + BEZEICHNER_METHODE_GET_ANZAHL_PFERDE);
        } catch (LaborpruefungException e) {
            assertTrue(false, "Fehler bei der Methode " + BEZEICHNER_METHODE_GET_ANZAHL_PFERDE);
        }
    }

    @Test
    public void testEinspannenSignatur() {
        try {
            assertTrue(hatMethode(kutscheClass, BEZEICHNER_METHODE_EINSPANNEN, einspannenParamTypes),
                    "Methode " + BEZEICHNER_METHODE_EINSPANNEN + " nicht gefunden.");
            assertTrue(methodeHatModifizierer(kutscheClass, BEZEICHNER_METHODE_EINSPANNEN, einspannenParamTypes, istPublic),
                    "Methode " + BEZEICHNER_METHODE_EINSPANNEN + " hat nicht den richtigen Modifizierer.");
            assertEquals(void.class, getRueckgabeTyp(kutscheClass, BEZEICHNER_METHODE_EINSPANNEN, einspannenParamTypes),
                    "Methode " + BEZEICHNER_METHODE_EINSPANNEN + " hat falschen Rückgabetyp");
        } catch (LaborpruefungException e) {
            assertTrue(false, "Fehler bei der Methode " + BEZEICHNER_METHODE_EINSPANNEN);
        }
    }

    @Test
    public void testEinspannenEingabeException() {
        Kutsche kutsche = new Kutsche();
        Pferd pferd1 = new Pferd("Pferd1");
        Pferd pferd2 = new Pferd("Pferd2");

        // Teste null
        try {
            methodeAufrufenExceptionErwartet(kutsche, BEZEICHNER_METHODE_EINSPANNEN, einspannenParamTypes, new Object[]{null});
            assertTrue(false, "IllegalArgumentException erwartet.");
        } catch (Throwable throwable) {
            assertTrue(throwable instanceof IllegalArgumentException, "IllegalArgumentException erwartet.");
        }

        // Tests pferd, das schon Vorgänger hat
        pferd1.setDavorPferd(pferd2);
        setPferd(kutsche, pferd1);
        try {
            methodeAufrufenExceptionErwartet(kutsche, BEZEICHNER_METHODE_EINSPANNEN, einspannenParamTypes,
                    new Object[]{pferd1});
            assertTrue(false, "IllegalArgumentException erwartet.");
        } catch (Throwable throwable) {
            assertTrue(throwable instanceof IllegalArgumentException, "IllegalArgumentException erwartet.");
        }
    }

    @Test
    public void testEinspannenErstesPferd() {
        Kutsche kutsche = new Kutsche();
        Pferd pferd1 = new Pferd("Pferd1");
        // Teste Einfügen erstes Pferd
        try {
            methodeAufrufen(kutsche, BEZEICHNER_METHODE_EINSPANNEN, einspannenParamTypes, new Object[]{pferd1});
            assertEquals(pferd1, getWertObjektVariable(kutsche, BEZEICHNER_VARIABLE_PFERD));
            assertEquals(null, pferd1.getDavorPferd());
        } catch (LaborpruefungException e) {
            assertTrue(fail(), "Fehler bei Aufrufen der Methode " + BEZEICHNER_METHODE_EINSPANNEN);
        }
    }

    @Test
    public void testEinspannenWeiterePferde() {
        Kutsche kutsche = new Kutsche();
        Pferd pferd1 = new Pferd("Pferd1");
        Pferd pferd2 = new Pferd("Pferd2");
        Pferd pferd3 = new Pferd("Pferd3");

        // Teste Einfügen erstes Pferd
        try {
            methodeAufrufen(kutsche, BEZEICHNER_METHODE_EINSPANNEN, einspannenParamTypes, new Object[]{pferd1});
            methodeAufrufen(kutsche, BEZEICHNER_METHODE_EINSPANNEN, einspannenParamTypes, new Object[]{pferd2});
            assertEquals(pferd1, getWertObjektVariable(kutsche, BEZEICHNER_VARIABLE_PFERD));
            assertEquals(pferd2, pferd1.getDavorPferd());
            assertEquals(null, pferd2.getDavorPferd());
            methodeAufrufen(kutsche, BEZEICHNER_METHODE_EINSPANNEN, einspannenParamTypes, new Object[]{pferd3});
            assertEquals(pferd1, getWertObjektVariable(kutsche, BEZEICHNER_VARIABLE_PFERD));
            assertEquals(pferd2, pferd1.getDavorPferd());
            assertEquals(pferd3, pferd2.getDavorPferd());
            assertEquals(null, pferd3.getDavorPferd());
        } catch (LaborpruefungException e) {
            assertTrue(fail(), "Fehler bei Aufrufen der Methode " + BEZEICHNER_METHODE_EINSPANNEN);
        }
    }

    @Test
    public void testAusspannenSignatur() {
        try {
            assertTrue(hatMethode(kutscheClass, BEZEICHNER_METHODE_AUSSPANNEN, ausspannenParamTypes),
                    "Methode " + BEZEICHNER_METHODE_AUSSPANNEN + " nicht gefunden.");
            assertTrue(methodeHatModifizierer(kutscheClass, BEZEICHNER_METHODE_AUSSPANNEN, ausspannenParamTypes, istPublic),
                    "Methode " + BEZEICHNER_METHODE_AUSSPANNEN + " hat nicht den richtigen Modifizierer.");
            assertEquals(Pferd[].class, getRueckgabeTyp(kutscheClass, BEZEICHNER_METHODE_AUSSPANNEN, ausspannenParamTypes),
                    "Methode " + BEZEICHNER_METHODE_AUSSPANNEN + " hat falschen Rückgabetyp");
        } catch (LaborpruefungException e) {
            assertTrue(false, "Fehler bei der Methode " + BEZEICHNER_METHODE_AUSSPANNEN);
        }
    }

    @Test
    public void testAusspannenFehler() {
        try {
            Kutsche kutsche = new Kutsche();
            // Negativer Index (leeres Gespann)
            Object ist = methodeAufrufen(kutsche, BEZEICHNER_METHODE_AUSSPANNEN, ausspannenParamTypes, new Object[]{-1, 2});
            assertEquals(null, ist, "Methode " + BEZEICHNER_METHODE_AUSSPANNEN
                    + " liefert falschen Rückgabewert");
            // Negative Anzahl Negativer Index (leeres Gespann)
            ist = methodeAufrufen(kutsche, BEZEICHNER_METHODE_AUSSPANNEN, ausspannenParamTypes, new Object[]{0, -1});
            assertEquals(null, ist, "Methode " + BEZEICHNER_METHODE_AUSSPANNEN
                    + " liefert falschen Rückgabewert");
            // Index > Länge Negativer Index (leeres Gespann)
            ist = methodeAufrufen(kutsche, BEZEICHNER_METHODE_AUSSPANNEN, ausspannenParamTypes, new Object[]{2, 1});
            assertEquals(null, ist, "Methode " + BEZEICHNER_METHODE_AUSSPANNEN
                    + " liefert falschen Rückgabewert");
            Pferd pferd1 = new Pferd("Pferd 1");
            Pferd pferd2 = new Pferd("Pferd 2");
            setPferd(kutsche, pferd1);
            pferd1.setDavorPferd(pferd2);
            // Negativer Index (nicht-leeres Gespann)
            ist = methodeAufrufen(kutsche, BEZEICHNER_METHODE_AUSSPANNEN, ausspannenParamTypes, new Object[]{-1, 2});
            assertEquals(null, ist, "Methode " + BEZEICHNER_METHODE_AUSSPANNEN
                    + " liefert falschen Rückgabewert");
            // Negative Anzahl Negativer Index (nicht-leeres Gespann)
            ist = methodeAufrufen(kutsche, BEZEICHNER_METHODE_AUSSPANNEN, ausspannenParamTypes, new Object[]{0, -1});
            assertEquals(null, ist, "Methode " + BEZEICHNER_METHODE_AUSSPANNEN
                    + " liefert falschen Rückgabewert");
            // Index > Länge (nicht-leeres Gespann)
            ist = methodeAufrufen(kutsche, BEZEICHNER_METHODE_AUSSPANNEN, ausspannenParamTypes, new Object[]{2, 1});
            assertEquals(null, ist, "Methode " + BEZEICHNER_METHODE_AUSSPANNEN
                    + " liefert falschen Rückgabewert");
            // Zu groß
            ist = methodeAufrufen(kutsche, BEZEICHNER_METHODE_AUSSPANNEN, ausspannenParamTypes, new Object[]{1, 2});
            assertEquals(null, ist, "Methode " + BEZEICHNER_METHODE_AUSSPANNEN
                    + " liefert falschen Rückgabewert");

        } catch (LaborpruefungException e) {
            assertTrue(false, "Fehler bei der Methode " + BEZEICHNER_METHODE_AUSSPANNEN);
        }
    }

    @Test
    public void testAusspannenNichtAbKutsche() {
        try {
            Kutsche kutsche = new Kutsche();
            Pferd pferd1 = new Pferd("Pferd 1");
            Pferd pferd2 = new Pferd("Pferd 2");
            Pferd pferd3 = new Pferd("Pferd 3");
            Pferd pferd4 = new Pferd("Pferd 4");
            setPferd(kutsche, pferd1);
            pferd1.setDavorPferd(pferd2);
            pferd2.setDavorPferd(pferd3);
            pferd3.setDavorPferd(pferd4);

            Pferd[] ist = (Pferd[]) methodeAufrufen(kutsche, BEZEICHNER_METHODE_AUSSPANNEN, ausspannenParamTypes,
                    new Object[]{1, 2});
            assertEquals(2, ist.length, "Rückgabe-Array hat falsche Länge");
            assertTrue(istEnthalten(ist, pferd2), "Pferd fehlt in Rückgabe-Array");
            assertTrue(istEnthalten(ist, pferd3), "Pferd fehlt in Rückgabe-Array");
            assertEquals(pferd1, getWertObjektVariable(kutsche, BEZEICHNER_VARIABLE_PFERD), "Kutsche hat falsches Pferd");
            assertEquals(pferd4, pferd1.getDavorPferd(), "Falscher Reihenfolge/Anzahl der Pferde in Gespann");
            assertEquals(null, pferd4.getDavorPferd(), "Falscher Reihenfolge/Anzahl der Pferde in Gespann");

        } catch (LaborpruefungException e) {
            assertTrue(false, "Fehler bei der Methode " + BEZEICHNER_METHODE_AUSSPANNEN);
        }
    }

    @Test
    public void testAusspannenAbKutsche() {
        try {
            {
                // Testfall 1
                Kutsche kutsche = new Kutsche();
                Pferd pferd1 = new Pferd("Pferd 1");
                Pferd pferd2 = new Pferd("Pferd 2");
                Pferd pferd3 = new Pferd("Pferd 3");
                Pferd pferd4 = new Pferd("Pferd 4");
                setPferd(kutsche, pferd1);
                pferd1.setDavorPferd(pferd2);
                pferd2.setDavorPferd(pferd3);
                pferd3.setDavorPferd(pferd4);

                Pferd[] ist = (Pferd[]) methodeAufrufen(kutsche, BEZEICHNER_METHODE_AUSSPANNEN, ausspannenParamTypes,
                        new Object[]{0, 3});
                assertEquals(3, ist.length, "Rückgabe-Array hat falsche Länge");
                assertTrue(istEnthalten(ist, pferd1), "Pferd fehlt in Rückgabe-Array");
                assertTrue(istEnthalten(ist, pferd2), "Pferd fehlt in Rückgabe-Array");
                assertTrue(istEnthalten(ist, pferd3), "Pferd fehlt in Rückgabe-Array");
                assertEquals(pferd4, getWertObjektVariable(kutsche, BEZEICHNER_VARIABLE_PFERD), "Kutsche hat falsches Pferd");
                assertEquals(null, pferd4.getDavorPferd(), "Falscher Reihenfolge/Anzahl der Pferde in Gespann");
            }

            {
                // Testfall 2
                Kutsche kutsche = new Kutsche();
                Pferd pferd1 = new Pferd("Pferd 1");
                Pferd pferd2 = new Pferd("Pferd 2");
                Pferd pferd3 = new Pferd("Pferd 3");
                Pferd pferd4 = new Pferd("Pferd 4");
                setPferd(kutsche, pferd1);
                pferd1.setDavorPferd(pferd2);
                pferd2.setDavorPferd(pferd3);
                pferd3.setDavorPferd(pferd4);

                Pferd[] ist = (Pferd[]) methodeAufrufen(kutsche, BEZEICHNER_METHODE_AUSSPANNEN, ausspannenParamTypes,
                        new Object[]{2, 2});
                assertEquals(2, ist.length, "Rückgabe-Array hat falsche Länge");
                assertTrue(istEnthalten(ist, pferd3), "Pferd fehlt in Rückgabe-Array");
                assertTrue(istEnthalten(ist, pferd4), "Pferd fehlt in Rückgabe-Array");
                assertEquals(pferd1, getWertObjektVariable(kutsche, BEZEICHNER_VARIABLE_PFERD), "Kutsche hat falsches Pferd");
                assertEquals(pferd2, pferd1.getDavorPferd(), "Falscher Reihenfolge/Anzahl der Pferde in Gespann");
                assertEquals(null, pferd2.getDavorPferd(), "Falscher Reihenfolge/Anzahl der Pferde in Gespann");
            }

        } catch (LaborpruefungException e) {
            assertTrue(false, "Fehler bei der Methode " + BEZEICHNER_METHODE_AUSSPANNEN);
        }
    }

    /**
     * Liefert wahr, wenn das angegebene Pferd in dem Array enhalten ist.
     */
    private boolean istEnthalten(Pferd[] ist, Pferd pferd) {
        for (Pferd p : ist) {
            if (p == pferd) {
                return true;
            }
        }
        return false;
    }

    /**
     * Setzt das Pferd als erstes vor die Kutsche.
     */
    private void setPferd(Kutsche kutsche, Pferd pferd) {
        try {
            setObjektvariable(kutsche, BEZEICHNER_VARIABLE_PFERD, pferd);
        } catch (LaborpruefungException e) {
            // Ignore
        }
    }
}
