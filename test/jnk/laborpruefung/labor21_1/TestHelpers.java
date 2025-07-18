package jnk.laborpruefung.labor21_1;

import org.junit.jupiter.api.Assertions;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class TestHelpers {
    public static void checkField(Class<?> klass, String fieldName, Class<?> expectedType, int expectedModifiers) {
        Assertions.assertDoesNotThrow(() -> klass.getDeclaredField(fieldName), String.format("Field %s doesn't exist", fieldName));
        Field field;
        try {
            field = klass.getDeclaredField(fieldName);
        } catch (NoSuchFieldException ignored) {
            throw new RuntimeException("This should never happen!");
        }

        Assertions.assertEquals(expectedType, field.getType(), String.format("Field %s is not of the expected type", fieldName));
        Assertions.assertEquals(Modifier.toString(expectedModifiers), Modifier.toString(field.getModifiers()), String.format("Field %s doesn't have the right modifiers", fieldName));
    }

    public static void checkConstructor(Class<?> klass, Class<?>[] constructorParams) {
        Assertions.assertDoesNotThrow(() -> klass.getConstructor(constructorParams), String.format("Class %s doesn't have constructor with expected parameters", klass));
    }

    public static void checkMethod(Class<?> klass, String methodName, Class<?>[] expectedArguments, Class<?> expectedReturnType, int expectedModifiers) {
        Assertions.assertDoesNotThrow(() -> klass.getDeclaredMethod(methodName, expectedArguments), String.format("Method %s doesn't exist", methodName));
        Method method;
        try {
            method = klass.getDeclaredMethod(methodName, expectedArguments);
        } catch (NoSuchMethodException ignored) {
            throw new RuntimeException("This should never happen!");
        }

        Assertions.assertEquals(expectedReturnType, method.getReturnType(), String.format("Method %s doesn't have correct return type", methodName));
        Assertions.assertEquals(Modifier.toString(expectedModifiers), Modifier.toString(method.getModifiers()), String.format("Method %s doesn't have the right modifiers", methodName));
    }

    public static <T> T getFieldValue(Class<?> klass, String fieldName, Object object) {
        Field field = null;
        while (klass != null) {
            try {
                field = klass.getDeclaredField(fieldName);
                break;
            } catch (NoSuchFieldException e) {
                klass = klass.getSuperclass();
            }
        }
        if (field == null) return null;

        field.trySetAccessible();
        try {
            //noinspection unchecked
            return (T) field.get(object);
        } catch (IllegalAccessException | ClassCastException ignored) {
            return null;
        }
    }
}
