package jnk.laborpruefung.labor21_2.aufgabe2;

import jnk.laborpruefung.labor21_2.LaborpruefungException;
import jnk.laborpruefung.labor21_2.TestBasisklasse;
import jnk.laborpruefung.labor21_2.aufgabe1.Ding;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Testklasse für die Klasse Lager (Aufgabe 2).
 */
public class TestLager extends TestBasisklasse {

    private static final String BEZEICHNER_METHODE_GET_PLATZ_IM_LAGER = "anzahlFrei";
    private static final String BEZEICHNER_VARIABLE_LAGER_RAUM = "lagerRaum";
    private static final String BEZEICHNER_METHODE_EINLAGERN = "einlagern";
    private static final String BEZEICHNER_METHODE_ANBAUEN = "anbauen";
    private static final Class<?>[] getPlatzImLagerParamTypes = new Class<?>[]{};
    private static final Class<?>[] anbauenParamTypes = new Class<?>[]{Lager.class};
    private static final Class<?>[] einlagernParamTypes = new Class<?>[]{Ding.class};


    /**
     * Diese Klasse wird als Ding-Dummy verwendet.
     */
    private class DingAdapter extends Ding {
        public DingAdapter(int groesse) {
            super(groesse);
        }
    }

    @Test
    public void testAnzahlFreiSignatur() {
        try {
            assertTrue(hatMethode(Lager.class, BEZEICHNER_METHODE_GET_PLATZ_IM_LAGER, getPlatzImLagerParamTypes),
                    "Klasse Lager hat nicht die Methode " + BEZEICHNER_METHODE_GET_PLATZ_IM_LAGER);
            assertTrue(methodeHatModifizierer(Lager.class, BEZEICHNER_METHODE_GET_PLATZ_IM_LAGER, getPlatzImLagerParamTypes,
                    istPublic), "Methode " + BEZEICHNER_METHODE_GET_PLATZ_IM_LAGER
                    + " hat falschen Sichtbarkeitsmodifizierer");
            assertEquals(int.class, getRueckgabeTyp(Lager.class, BEZEICHNER_METHODE_GET_PLATZ_IM_LAGER,
                    getPlatzImLagerParamTypes), "Methode " + BEZEICHNER_METHODE_GET_PLATZ_IM_LAGER
                    + " hat nicht den richtigen Rückgabetyp.");
        } catch (LaborpruefungException e) {
            assertTrue(false, "Fehler in der Methode " + BEZEICHNER_METHODE_GET_PLATZ_IM_LAGER);
        }
    }

    @Test
    public void testAnzahlFreiImplementierung() {
        try {
            DingAdapter d1 = new DingAdapter(3);
            DingAdapter d2 = new DingAdapter(4);
            Lager lagerBeispiel = new Lager(10);
            setDingInLagerAnStelle(lagerBeispiel, 0, d1);
            setDingInLagerAnStelle(lagerBeispiel, 1, d1);
            setDingInLagerAnStelle(lagerBeispiel, 2, d1);
            setDingInLagerAnStelle(lagerBeispiel, 4, d2);
            setDingInLagerAnStelle(lagerBeispiel, 6, d2);
            setDingInLagerAnStelle(lagerBeispiel, 7, d2);
            setDingInLagerAnStelle(lagerBeispiel, 8, d2);
            List<Lager> lager = Arrays.asList(new Lager(10), new Lager(0), lagerBeispiel);
            List<Integer> soll = Arrays.asList(10, 0, 3);
            for (int i = 0; i < lager.size(); i++) {
                Lager l = lager.get(i);
                Object ist = methodeAufrufen(l, BEZEICHNER_METHODE_GET_PLATZ_IM_LAGER, getPlatzImLagerParamTypes,
                        new Object[]{});
                assertEquals(soll.get(i), ist, "Methode" + BEZEICHNER_METHODE_GET_PLATZ_IM_LAGER
                        + " liefert falschen Wert");
            }
        } catch (LaborpruefungException e) {
            assertTrue(false, "Fehler in der Methode " + BEZEICHNER_METHODE_GET_PLATZ_IM_LAGER);
        }
    }

    @Test
    public void testEinlagernSignatur() {
        try {
            assertTrue(hatMethode(Lager.class, BEZEICHNER_METHODE_EINLAGERN, einlagernParamTypes),
                    "Klasse Lager hat nicht die Methode " + BEZEICHNER_METHODE_EINLAGERN);
            assertTrue(methodeHatModifizierer(Lager.class, BEZEICHNER_METHODE_EINLAGERN, einlagernParamTypes,
                    istPublic), "Methode " + BEZEICHNER_METHODE_EINLAGERN
                    + " hat falschen Sichtbarkeitsmodifizierer");
            assertEquals(boolean.class, getRueckgabeTyp(Lager.class, BEZEICHNER_METHODE_EINLAGERN,
                    einlagernParamTypes), "Methode " + BEZEICHNER_METHODE_EINLAGERN
                    + " hat nicht den richtigen Rückgabetyp.");
        } catch (LaborpruefungException e) {
            assertTrue(false, "Fehler in der Methode " + BEZEICHNER_METHODE_EINLAGERN);
        }
    }

    @Test
    public void testEinlagernAmStueck() {
        // Testfälle
        List<Lager> lager = new ArrayList<>();
        List<Ding> dinge = new ArrayList<>();
        List<Boolean> soll = new ArrayList<>();

        {
            lager.add(new Lager(5));
            dinge.add(new DingAdapter(2));
            soll.add(true);
        }

        {
            lager.add(new Lager(2));
            dinge.add(new DingAdapter(5));
            soll.add(false);
        }

        {
            Lager l = new Lager(6);
            DingAdapter d = new DingAdapter(2);
            setDingInLagerAnStelle(l, 0, d);
            setDingInLagerAnStelle(l, 1, d);
            lager.add(l);
            dinge.add(new DingAdapter(3));
            soll.add(true);
        }

        runEinlagernTests(einlagernParamTypes, lager, dinge, soll);
    }

    @Test
    public void testEinlagernZerstueckelt() {
        // Testfälle
        List<Lager> lager = new ArrayList<>();
        List<Ding> dinge = new ArrayList<>();

        {
            Lager lager1 = new Lager(6);
            DingAdapter ding1 = new DingAdapter(2);
            setDingInLagerAnStelle(lager1, 0, ding1);
            setDingInLagerAnStelle(lager1, 2, ding1);
            lager.add(lager1);
            dinge.add(new DingAdapter(2));
        }

        {
            Lager lager2 = new Lager(7);
            DingAdapter ding2 = new DingAdapter(3);
            setDingInLagerAnStelle(lager2, 1, ding2);
            setDingInLagerAnStelle(lager2, 3, ding2);
            setDingInLagerAnStelle(lager2, 5, ding2);
            lager.add(lager2);
            dinge.add(new DingAdapter(3));
        }

        List<Boolean> soll = Arrays.asList(true, true);
        runEinlagernTests(einlagernParamTypes, lager, dinge, soll);
    }

    @Test
    public void testAnbauenSignaturUndNullArgument() {
        try {
            assertTrue(hatMethode(Lager.class, BEZEICHNER_METHODE_ANBAUEN, anbauenParamTypes),
                    "Klasse Lager hat nicht die Methode " + BEZEICHNER_METHODE_ANBAUEN);
            assertTrue(methodeHatModifizierer(Lager.class, BEZEICHNER_METHODE_ANBAUEN, anbauenParamTypes,
                    istPublic), "Methode " + BEZEICHNER_METHODE_ANBAUEN
                    + " hat falschen Sichtbarkeitsmodifizierer");
            assertEquals(void.class, getRueckgabeTyp(Lager.class, BEZEICHNER_METHODE_ANBAUEN,
                    anbauenParamTypes), "Methode " + BEZEICHNER_METHODE_ANBAUEN
                    + " hat nicht den richtigen Rückgabetyp.");

            Lager lager = new Lager(3);
            int belegungVorher = getBelegteFelderInLager(lager);
            methodeAufrufen(lager, BEZEICHNER_METHODE_ANBAUEN, anbauenParamTypes, new Object[]{null});
            assertEquals(belegungVorher, getBelegteFelderInLager(lager), "Erwarte keine veränderung des Lagers bei Argument" +
                    " null in Methode " + BEZEICHNER_METHODE_ANBAUEN);
        } catch (LaborpruefungException e) {
            assertTrue(false, "Fehler in der Methode " + BEZEICHNER_METHODE_ANBAUEN);
        }
    }

    @Test
    public void testAnbauenImplementierung() {
        List<Lager> thisLager = new ArrayList<>();
        List<Lager> argumentLager = new ArrayList<>();

        {
            // keine Dinge im Lager
            Lager t = new Lager(5);
            Lager a = new Lager(3);
            thisLager.add(t);
            argumentLager.add(a);
        }

        {
            // Dinge in beiden Lagern
            Lager lager1 = new Lager(5);
            Lager lager2 = new Lager(3);
            DingAdapter d1 = new DingAdapter(2);
            DingAdapter d2 = new DingAdapter(3);
            setDingInLagerAnStelle(lager1, 0, d1);
            setDingInLagerAnStelle(lager1, 2, d1);
            setDingInLagerAnStelle(lager2, 0, d2);
            setDingInLagerAnStelle(lager2, 1, d2);
            setDingInLagerAnStelle(lager2, 2, d2);
            thisLager.add(lager1);
            argumentLager.add(lager2);
        }

        {
            // Nur Dinge im ersten Lager
            Lager lager1 = new Lager(5);
            Lager lager2 = new Lager(3);
            DingAdapter d1 = new DingAdapter(2);
            setDingInLagerAnStelle(lager1, 0, d1);
            setDingInLagerAnStelle(lager1, 2, d1);
            thisLager.add(lager1);
            argumentLager.add(lager2);
        }

        {
            // Nur Dinge im zweiten Lager
            Lager lager1 = new Lager(5);
            Lager lager2 = new Lager(3);
            DingAdapter d2 = new DingAdapter(3);
            setDingInLagerAnStelle(lager2, 0, d2);
            setDingInLagerAnStelle(lager2, 1, d2);
            setDingInLagerAnStelle(lager2, 2, d2);
            thisLager.add(lager1);
            argumentLager.add(lager2);
        }

        try {
            for (int i = 0; i < thisLager.size(); i++) {
                int freierPlatzInLagerVorher = getLagerKapazitaet(thisLager.get(i)) - getBelegteFelderInLager(thisLager.get(i));
                int freierPlatzInArgumentLager = getLagerKapazitaet(argumentLager.get(i))
                        - getBelegteFelderInLager(argumentLager.get(i));

                methodeAufrufen(thisLager.get(i), BEZEICHNER_METHODE_ANBAUEN, anbauenParamTypes,
                        new Object[]{argumentLager.get(i)});
                int freierPlatzInLagerNachher =
                        getLagerKapazitaet(thisLager.get(i)) - getBelegteFelderInLager(thisLager.get(i));
                assertEquals(freierPlatzInLagerVorher + freierPlatzInArgumentLager, freierPlatzInLagerNachher, "Lager hat nach " +
                        "Anwendung von " + BEZEICHNER_METHODE_ANBAUEN + " falschen Inhalt");

                for (Ding ding : getDingeInLager(thisLager.get(i))) {
                    assertEquals(ding.getGroesse(), vorkommenVonDingInLager(thisLager.get(i), ding), "Falsch Anzahl von " +
                            "Ding-Stellplätzen in Lager nach Aufruf von " + BEZEICHNER_METHODE_ANBAUEN);
                }

            }
        } catch (LaborpruefungException e) {
            assertTrue(false, "Fehler beim Aufruf der Methode " + BEZEICHNER_METHODE_ANBAUEN + ": "
                    + e.getMessage());
        }
    }

    /**
     * Führt die übergebenen Testfälle für das Einlagern aus.
     */
    private void runEinlagernTests(Class<?>[] einlagernParamTypes, List<Lager> lager, List<Ding> dinge,
                                   List<Boolean> soll) {
        try {
            for (int i = 0; i < lager.size(); i++) {
                int anzahlDingeVorher = getBelegteFelderInLager(lager.get(i));
                Object ist = methodeAufrufen(lager.get(i), BEZEICHNER_METHODE_EINLAGERN, einlagernParamTypes, new Object[]{dinge.get(i)});
                // Rückgabe testen
                assertEquals(soll.get(i), ist, "Falscher Rückgabewert in Methode " + BEZEICHNER_METHODE_EINLAGERN);
                // Test, ob Dinge korrekt enthalten sind
                if (soll.get(i)) {
                    assertEquals(dinge.get(i).getGroesse(), vorkommenVonDingInLager(lager.get(i), dinge.get(i)),
                            "Belegung des Lagers durch Ding ist nicht korrekt");
                    assertEquals(anzahlDingeVorher + dinge.get(i).getGroesse(), getBelegteFelderInLager(lager.get(i)),
                            "Belegung des Lagers durch Ding ist nicht korrekt");
                } else {
                    assertEquals(anzahlDingeVorher, getBelegteFelderInLager(lager.get(i)));
                }
            }
        } catch (LaborpruefungException e) {
            assertTrue(false, "Fehler bei Ausführen der Testfälle für " + BEZEICHNER_METHODE_EINLAGERN);
        }
    }

    /**
     * Liefert die Anzahl der belegten Felder im Lager.
     */
    private int getBelegteFelderInLager(Lager lager) {
        try {
            Ding[] lagerinhalt = (Ding[]) getWertObjektVariable(lager, BEZEICHNER_VARIABLE_LAGER_RAUM);
            int anzahl = 0;
            for (Ding d : lagerinhalt) {
                if (d != null) {
                    anzahl++;
                }
            }
            return anzahl;
        } catch (LaborpruefungException e) {
            return -1;
        }
    }

    /**
     * Liefert die Kapazität (Stellplätze) im Lager.
     */
    private int getLagerKapazitaet(Lager lager) {
        try {
            Ding[] lagerinhalt = (Ding[]) getWertObjektVariable(lager, BEZEICHNER_VARIABLE_LAGER_RAUM);
            return lagerinhalt.length;
        } catch (LaborpruefungException e) {
            return -1;
        }
    }

    /**
     * Liefert die Anzahl der Felder im Lager l, die durch Ding d belegt sind.
     */
    private int vorkommenVonDingInLager(Lager lager, Ding ding) {
        try {
            Ding[] lagerinhalt = (Ding[]) getWertObjektVariable(lager, BEZEICHNER_VARIABLE_LAGER_RAUM);
            int anzahl = 0;
            for (Ding d : lagerinhalt) {
                if (d == ding) {
                    anzahl++;
                }
            }
            return anzahl;
        } catch (LaborpruefungException e) {
            return -1;
        }
    }

    /**
     * Set das Ding ding im Lager lager an der Stelle index.
     */
    private void setDingInLagerAnStelle(Lager lager, int index, DingAdapter ding) {
        try {
            Ding[] lagerinhalt = (Ding[]) getWertObjektVariable(lager, BEZEICHNER_VARIABLE_LAGER_RAUM);
            lagerinhalt[index] = ding;
        } catch (LaborpruefungException e) {
            System.err.println("Fehler beim Befüllen eines Test-Lagers.");
        }
    }

    /**
     * Liefer die Menge aller Dinge im Lager.
     */
    private Set<Ding> getDingeInLager(Lager lager) {
        Set<Ding> dinge = new HashSet<>();
        try {
            Ding[] lagerinhalt = (Ding[]) getWertObjektVariable(lager, BEZEICHNER_VARIABLE_LAGER_RAUM);
            for (Ding ding : lagerinhalt) {
                if (ding != null) {
                    dinge.add(ding);
                }
            }
        } catch (LaborpruefungException e) {
            return null;
        }
        return dinge;
    }
}
