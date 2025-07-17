package jnk.praktika.aufgabe5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestEingang {
    Eingang eingangTrue = new Eingang(true);
    Eingang eingangFalse = new Eingang(false);

    @Test
    public void testGetOutput() {
        assertTrue(eingangTrue.getOutput());
        assertFalse(eingangFalse.getOutput());
    }

    @Test
    public void testToString() {
        assertEquals("TRUE", eingangTrue.toString());
        assertEquals("FALSE", eingangFalse.toString());
    }
}
