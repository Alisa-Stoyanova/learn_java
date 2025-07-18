package jnk.laborpruefung.labor21_1.inuit.aufgabe1;

import jnk.laborpruefung.labor21_1.TestHelpers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

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

        // TODO: the rest of the test (check the arguments and their types)
    }
}
