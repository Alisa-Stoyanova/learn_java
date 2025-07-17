package jnk.laborpruefung.labor17.aufgabe2;

import jnk.laborpruefung.labor17.basis.TestBasisklasse;
import org.junit.Test;

import java.util.Comparator;
import java.util.List;
import java.util.Map;

import static junit.framework.Assert.*;


public class TestAufgabe2 extends TestBasisklasse {

    private static final Class<?> PRODUKT_KLASSE = Produkt.class;
    private static final Class<?> WARENKORB_KLASSE = Warenkorb.class;

    private static final Class<?> COMPARABLE_PRODUKT_INTERFACE = Comparable.class;
    private static final Class<?> COMPARATOR_PRODUKT_INTERFACE = Comparator.class;
    private static final Class<?> PRODUKT_NAME_COMPARATOR_KLASSE = ProduktNameComparator.class;

    private static final String KLASSE_PRODUKT_BEZEICHNER = "Produkt";
    private static final String KLASSE_WARENKORB_BEZEICHNER = "Warenkorb";
    private static final String KLASSE_PRODUKT_NAME_COMPARATOR_BEZEICHNER = "ProduktNameComparator";

    private static final String METHODE_COMPARETO_BEZEICHNER = "compareTo";
    private static final String METHODE_COMPARE_BEZEICHNER = "compare";
    private static final String METHODE_VEREINIGEN = "vereinigen";
    private static final String METHODE_VERSANDKOSTENFREI = "versandkostenfrei";
    private static final String METHODE_GET_PRODUKT_NAMEN_LISTE = "getProduktNamenListe";
    private static final String METHODE_GET_PRODUKT_GRUPPEN = "getProduktGruppen";

    private static final String VARIABLE_PRODUKTE_BEZEICHNER = "produkte";

    /**
     * Testmethode für Unteraufgabe 1
     */
    @Test
    public void testUnteraufgabe1() {
        Class<?>[] parameter = {PRODUKT_KLASSE};

        assertTrue(
                "Klasse " + KLASSE_PRODUKT_BEZEICHNER
                        + " implementiert nicht das Interface Comparable",
                testImplementiertInterface(PRODUKT_KLASSE,
                        COMPARABLE_PRODUKT_INTERFACE));

        assertTrue(
                "Klasse " + KLASSE_PRODUKT_BEZEICHNER + " hat nicht die Methode "
                        + METHODE_COMPARETO_BEZEICHNER,
                hatMethode(PRODUKT_KLASSE, METHODE_COMPARETO_BEZEICHNER, parameter));

        assertEquals(
                "Methode " + METHODE_COMPARETO_BEZEICHNER
                        + " hat nicht den Rückgabetyp int.",
                int.class, getRueckgabeTyp(PRODUKT_KLASSE, METHODE_COMPARETO_BEZEICHNER,
                        parameter));

        Produkt milch = erzeugeProdukt("Milch", 1.39);
        Produkt butter = erzeugeProdukt("Butter", 1.29);

        // Milch > Butter
        Object[] argumente = {butter};
        int rueckgabe = (Integer) werteMethodeAus(milch,
                METHODE_COMPARETO_BEZEICHNER, parameter, argumente);
        assertTrue(
                "Methode " + METHODE_COMPARETO_BEZEICHNER + " liefert falschen Wert.",
                rueckgabe > 0);

        // Milch < Butter
        argumente = new Object[]{milch};
        rueckgabe = (Integer) werteMethodeAus(butter, METHODE_COMPARETO_BEZEICHNER,
                parameter, argumente);
        assertTrue(
                "Methode " + METHODE_COMPARETO_BEZEICHNER + " liefert falschen Wert.",
                rueckgabe < 0);

        // Milch == Butter
        argumente = new Object[]{milch};
        rueckgabe = (Integer) werteMethodeAus(milch, METHODE_COMPARETO_BEZEICHNER,
                parameter, argumente);
        assertTrue(
                "Methode " + METHODE_COMPARETO_BEZEICHNER + " liefert falschen Wert.",
                rueckgabe == 0);
    }

    /**
     * Testmethode für Unteraufgabe 2
     */
    @Test
    public void testUnteraufgabe2() {
        Class<?>[] parameter = {PRODUKT_KLASSE, PRODUKT_KLASSE};

        assertTrue(
                "Klasse " + KLASSE_PRODUKT_NAME_COMPARATOR_BEZEICHNER
                        + " implementiert nicht das Interface Comparator",
                testImplementiertInterface(PRODUKT_NAME_COMPARATOR_KLASSE,
                        COMPARATOR_PRODUKT_INTERFACE));

        assertTrue(
                "Klasse " + KLASSE_PRODUKT_NAME_COMPARATOR_BEZEICHNER
                        + " hat nicht die Methode " + METHODE_COMPARE_BEZEICHNER,
                hatMethode(PRODUKT_NAME_COMPARATOR_KLASSE, METHODE_COMPARE_BEZEICHNER,
                        parameter));

        assertEquals(
                "Methode " + METHODE_COMPARE_BEZEICHNER
                        + " hat nicht den Rückgabetyp int.",
                int.class, getRueckgabeTyp(PRODUKT_NAME_COMPARATOR_KLASSE,
                        METHODE_COMPARE_BEZEICHNER, parameter));

        Produkt milch = erzeugeProdukt("Milch", 1.39);
        Produkt butter = erzeugeProdukt("Butter", 1.49);
        ProduktNameComparator comparator = (ProduktNameComparator) erzeugeInstanz(
                PRODUKT_NAME_COMPARATOR_KLASSE);

        // Milch > Butter
        Object[] argumente = {milch, butter};
        int rueckgabe = (Integer) werteMethodeAus(comparator,
                METHODE_COMPARE_BEZEICHNER, parameter, argumente);
        assertTrue(
                "Methode " + METHODE_COMPARE_BEZEICHNER + " liefert falschen Wert.",
                rueckgabe > 0);

        // Milch < Butter
        argumente = new Object[]{butter, milch};
        rueckgabe = (Integer) werteMethodeAus(comparator,
                METHODE_COMPARE_BEZEICHNER, parameter, argumente);
        assertTrue(
                "Methode " + METHODE_COMPARE_BEZEICHNER + " liefert falschen Wert.",
                rueckgabe < 0);

        // Milch == Butter
        argumente = new Object[]{milch, milch};
        rueckgabe = (Integer) werteMethodeAus(comparator,
                METHODE_COMPARE_BEZEICHNER, parameter, argumente);
        assertTrue(
                "Methode " + METHODE_COMPARE_BEZEICHNER + " liefert falschen Wert.",
                rueckgabe == 0);
    }

    /**
     * Testmethode für Unteraufgabe 3
     */
    @Test
    public void testUnteraufgabe3() {
        Class<?>[] parameter = {WARENKORB_KLASSE};

        assertTrue(
                "Klasse " + KLASSE_WARENKORB_BEZEICHNER + " hat nicht die Methode "
                        + METHODE_VEREINIGEN,
                hatMethode(WARENKORB_KLASSE, METHODE_VEREINIGEN, parameter));

        assertEquals(
                "Methode " + METHODE_VEREINIGEN + " hat nicht den Rückgabetyp void",
                void.class,
                getRueckgabeTyp(WARENKORB_KLASSE, METHODE_VEREINIGEN, parameter));

        Warenkorb warenkorb = new Warenkorb();
        Warenkorb warenkorb2 = new Warenkorb();
        Produkt milch = erzeugeProdukt("Milch", 1.39);
        Produkt butter = erzeugeProdukt("butter", 1.29);
        Produkt kaese = erzeugeProdukt("kaese", 2.22);
        warenkorb.einfuegen(milch);

        @SuppressWarnings("unchecked")
        List<Produkt> produkte = (List<Produkt>) getWertObjektVariable(warenkorb,
                VARIABLE_PRODUKTE_BEZEICHNER);

        assertEquals("Warenkorb Produkte-Liste hat nicht die richtge Länge.", 1,
                produkte.size());
        assertTrue("In Warenkorb Produkte-Liste fehlt ein Element.",
                produkte.contains(milch));

        warenkorb2.einfuegen(butter);
        warenkorb2.einfuegen(kaese);
        werteMethodeAus(warenkorb, METHODE_VEREINIGEN,
                new Class<?>[]{WARENKORB_KLASSE}, new Object[]{warenkorb2});

        assertEquals("Warenkorb Produkte-Liste hat nicht die richtge Länge.", 3,
                produkte.size());
        assertTrue("In Warenkorb Produkte-Liste fehlt ein Element.",
                produkte.contains(milch));
        assertTrue("In Warenkorb Produkte-Liste fehlt ein Element.",
                produkte.contains(butter));
        assertTrue("In Warenkorb Produkte-Liste fehlt ein Element.",
                produkte.contains(kaese));
    }

    /**
     * Testmethode für Unteraufgabe 4
     */
    @Test
    public void testUnteraufgabe4() {
        assertTrue(
                "Klasse " + KLASSE_WARENKORB_BEZEICHNER + " hat nicht die Methode "
                        + METHODE_VERSANDKOSTENFREI,
                hatMethode(WARENKORB_KLASSE, METHODE_VERSANDKOSTENFREI,
                        new Class<?>[]{}));

        assertEquals(
                "Methode " + METHODE_VERSANDKOSTENFREI
                        + " hat nicht den Rückgabetyp boolean",
                boolean.class, getRueckgabeTyp(WARENKORB_KLASSE,
                        METHODE_VERSANDKOSTENFREI, new Class<?>[]{}));

        Warenkorb warenkorb = new Warenkorb();
        Produkt milch = erzeugeProdukt("Milch", 20);
        warenkorb.einfuegen(milch);
        assertFalse(
                "Methode " + METHODE_VERSANDKOSTENFREI + " liefert falschen Wert.",
                (Boolean) werteMethodeAus(warenkorb, METHODE_VERSANDKOSTENFREI));
        Produkt butter = erzeugeProdukt("butter", 29);
        warenkorb.einfuegen(butter);
        assertFalse(
                "Methode " + METHODE_VERSANDKOSTENFREI + " liefert falschen Wert.",
                (Boolean) werteMethodeAus(warenkorb, METHODE_VERSANDKOSTENFREI));
        Produkt kaese = erzeugeProdukt("kaese", 2);
        warenkorb.einfuegen(kaese);
        assertTrue(
                "Methode " + METHODE_VERSANDKOSTENFREI + " liefert falschen Wert.",
                (Boolean) werteMethodeAus(warenkorb, METHODE_VERSANDKOSTENFREI));
    }

    /**
     * Testmethode für Unteraufgabe 5
     */
    @Test
    public void testUnteraufgabe5() {
        assertTrue(
                "Klasse " + KLASSE_WARENKORB_BEZEICHNER + " hat nicht die Methode "
                        + METHODE_GET_PRODUKT_NAMEN_LISTE,
                hatMethode(WARENKORB_KLASSE, METHODE_GET_PRODUKT_NAMEN_LISTE,
                        new Class<?>[]{}));

        assertEquals(
                "Methode " + METHODE_GET_PRODUKT_NAMEN_LISTE
                        + " hat nicht den Rückgabetyp List<String>",
                List.class, getRueckgabeTyp(WARENKORB_KLASSE,
                        METHODE_GET_PRODUKT_NAMEN_LISTE, new Class<?>[]{}));

        Warenkorb warenkorb = new Warenkorb();
        Produkt milch = erzeugeProdukt("Milch", 1.39);
        Produkt butter = erzeugeProdukt("Butter", 1.29);
        Produkt milch2 = erzeugeProdukt("Milch", 2.22);
        warenkorb.einfuegen(milch);
        warenkorb.einfuegen(butter);
        warenkorb.einfuegen(milch2);

        @SuppressWarnings("unchecked")
        List<String> produktNamenListe = (List<String>) werteMethodeAus(warenkorb,
                METHODE_GET_PRODUKT_NAMEN_LISTE);

        assertEquals("Ergebnisliste hat nicht die richtige Länge", 2,
                produktNamenListe.size());
        assertTrue("In der Ergebnisliste fehlt ein Element",
                produktNamenListe.contains("Milch"));
        assertTrue("In der Ergebnisliste fehlt ein Element",
                produktNamenListe.contains("Butter"));
    }

    /**
     * Testmethode für Unteraufgabe 6
     */
    @Test
    public void testUnteraufgabe6() {
        assertTrue(
                "Klasse " + KLASSE_WARENKORB_BEZEICHNER + " hat nicht die Methode "
                        + METHODE_GET_PRODUKT_GRUPPEN,
                hatMethode(WARENKORB_KLASSE, METHODE_GET_PRODUKT_GRUPPEN,
                        new Class<?>[]{}));

        assertEquals(
                "Methode " + METHODE_GET_PRODUKT_GRUPPEN
                        + " hat nicht den Rückgabetyp Map<String,List<Produkt>>",
                Map.class, getRueckgabeTyp(WARENKORB_KLASSE,
                        METHODE_GET_PRODUKT_GRUPPEN, new Class<?>[]{}));

        Warenkorb warenkorb = new Warenkorb();
        Produkt milch = erzeugeProdukt("Milch", 1.39);
        Produkt butter = erzeugeProdukt("Butter", 1.29);
        Produkt milch2 = erzeugeProdukt("Milch", 2.22);
        warenkorb.einfuegen(milch);
        warenkorb.einfuegen(butter);
        warenkorb.einfuegen(milch2);

        @SuppressWarnings("unchecked")
        Map<String, List<Produkt>> gruppenListe = (Map<String, List<Produkt>>) werteMethodeAus(
                warenkorb, METHODE_GET_PRODUKT_GRUPPEN);

        assertEquals("Ergebnismap hat nicht die richtige Länge", 2,
                gruppenListe.size());

        assertTrue("In der Ergebnismap fehlt ein Schlüssel",
                gruppenListe.containsKey("Milch"));
        List<Produkt> milchListe = gruppenListe.get("Milch");
        assertEquals("Die Werteliste für einen Schlüssel hat die falsche Länge", 2,
                milchListe.size());
        assertTrue("In der Werteliste für einen Schlüssel fehlt ein Element",
                milchListe.contains(milch));
        assertTrue("In der Werteliste für einen Schlüssel fehlt ein Element",
                milchListe.contains(milch2));

        assertTrue("In der Ergebnismap fehlt ein Schlüssel",
                gruppenListe.containsKey("Butter"));
        List<Produkt> butterListe = gruppenListe.get("Butter");
        assertEquals("Die Werteliste für einen Schlüssel hat die falsche Länge", 1,
                butterListe.size());
        assertTrue("In der Werteliste für einen Schlüssel fehlt ein Element",
                butterListe.contains(butter));
    }

    private Produkt erzeugeProdukt(String name, double preis) {
        Class<?>[] typen = {String.class, double.class};
        return (Produkt) erzeugeInstanz(PRODUKT_KLASSE, typen,
                new Object[]{name, preis});
    }
}
