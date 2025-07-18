package jnk.laborpruefung.labor21_1;

import org.junit.jupiter.api.Assertions;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class TestHelpers {
    public static void checkField(Class<?> klass, String fieldName, Class<?> expectedType, int expectedModifiers) {
        Assertions.assertDoesNotThrow(() -> klass.getDeclaredField(fieldName), String.format("Field %s doesn't exist", fieldName));
        Field field = null;
        try {
            field = klass.getDeclaredField(fieldName);
        } catch (NoSuchFieldException ignored) {}

        Assertions.assertEquals(expectedType, field.getType(), String.format("Field %s is not of the expected type", fieldName));
        Assertions.assertEquals(Modifier.toString(expectedModifiers), Modifier.toString(field.getModifiers()), String.format("Field %s doesn't have the right modifiers", fieldName));
    }
}
