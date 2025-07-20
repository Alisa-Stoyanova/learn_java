package jnk.laborpruefung.labor21_1.inuit.aufgabe1;

import jnk.laborpruefung.labor21_1.TestHelpers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.lang.reflect.Modifier;

public class TestKiste {
    private final Class<Kiste> klass = Kiste.class;

    @Test
    public void testInhaltLeicht() {
        TestHelpers.checkField(klass,"inhalt", String.class, Modifier.PRIVATE | Modifier.FINAL);
    }

    @Test
    public void testKonstruktorLeicht() {
       TestHelpers.checkConstructor(klass, new Class<?>[]{int.class, String.class});

       Kiste k = new Kiste(4, "Fish");

       String realInhalt = TestHelpers.getFieldValue(klass, "inhalt", k);
       @SuppressWarnings("DataFlowIssue")
       int realGroesse = TestHelpers.getFieldValue(klass, "groesse", k);
       Assertions.assertEquals("Fish", realInhalt, "Constructor does not set provided value for inhalt!");
       Assertions.assertEquals(4, realGroesse, "Constructor does not set provided value for groesse!");
    }

    @Test
    public void testToStringLeicht() {
        TestHelpers.checkMethod(klass, "toString", new Class<?>[]{}, String.class, Modifier.PUBLIC);

        Kiste kiste = new Kiste(4, "Fish");
        Assertions.assertEquals("Kiste mit Fish", kiste.toString());
    }

    @Test
    public void testZusammenlegenLeicht() {
        TestHelpers.checkMethod(klass, "zusammenlegen", new Class<?>[]{klass}, klass, Modifier.PUBLIC);

        Kiste k1 = new Kiste(4, "Fish");
        Kiste k2 = new Kiste(2, "Flowers");
        Kiste k3 = k1.zusammenlegen(k2);

        Assertions.assertEquals(k1.getGroesse()+k2.getGroesse(), k3.getGroesse(), "Size of the new Kiste does not equals sum of it's parts!");
        Assertions.assertEquals("Kiste mit Fish+Flowers", k3.toString(), "Result of toString() doesn't equal the expected result!");
    }

    @Test
    public void testZusammenlegenMittelEins() {
        TestHelpers.checkMethod(klass, "zusammenlegen", new Class<?>[]{klass}, klass, Modifier.PUBLIC);

        Kiste k1 = new Kiste(4, "Fish");
        Assertions.assertThrowsExactly(IllegalArgumentException.class, () -> k1.zusammenlegen(null), "Method doesn't throw an exception when receiving null!");
    }

    @Test
    public void testZusammenlegenMittelZwei() {
        TestHelpers.checkMethod(klass, "zusammenlegen", new Class<?>[]{klass}, klass, Modifier.PUBLIC);

        Kiste k1 = new Kiste(4, "Fish");
        Assertions.assertThrowsExactly(IllegalArgumentException.class, () -> k1.zusammenlegen(null), "Method doesn't throw an exception when receiving null!");
    }
}
