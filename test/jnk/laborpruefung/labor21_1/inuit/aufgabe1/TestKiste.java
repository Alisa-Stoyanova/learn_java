package jnk.laborpruefung.labor21_1.inuit.aufgabe1;

import jnk.laborpruefung.labor21_1.TestHelpers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class TestKiste {
    private Class<Kiste> klass = Kiste.class;

    @Test
    public void testInhaltLeicht() {
        TestHelpers.checkField(klass,"inhalt", String.class, Modifier.PRIVATE | Modifier.FINAL);
    }

    @Test
    public void testKonstruktorLeicht() {
        Class<?>[] constructorParams = new Class<?>[]{int.class, String.class};
        Assertions.assertDoesNotThrow(() -> klass.getConstructor(constructorParams), "Class Kiste doesn't have constructor with expected parameters");
        Constructor<Kiste> constructor = null;
        try {
            constructor = klass.getConstructor(constructorParams);
        } catch (NoSuchMethodException ignored) {}
        Assertions.assertNotNull(constructor);
    }

    @Test
    public void testToStringLeicht() {
        Assertions.assertDoesNotThrow(() -> klass.getMethod("toString"), "Method toString doesn't exist");
        Method method = null;
        try {
            method = klass.getDeclaredMethod("toString");
        } catch (NoSuchMethodException ignored) {}
        Assertions.assertNotNull(method);

        Assertions.assertTrue(Modifier.isPublic(method.getModifiers()), "Method toString is not public");

        Kiste kiste = new Kiste(4, "Fish");
        Assertions.assertEquals("Kiste mit Fish", kiste.toString());
    }

    @Test
    public void testZusammenLegenLeicht() {
        Class<?>[] methodParams = new Class<?>[]{klass};
        Assertions.assertDoesNotThrow(() -> klass.getMethod("zusammenlegen", methodParams), "Method zusammenlegen(Kiste) doesn't exist");
        Method method = null;
        try {
            method = klass.getDeclaredMethod("zusammenlegen", methodParams);
        } catch (NoSuchMethodException ignored) {}
        Assertions.assertNotNull(method);

        Assertions.assertTrue(Modifier.isPublic(method.getModifiers()), "Method toString is not public");
        // TODO: the rest of the test (check the arguments and their types)
    }
}
