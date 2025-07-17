package jnk.praktika.aufgabe5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestUnd {

    @Test
    public void testUnd() {
        //Und und = new Und(new Eingang(false), null);
        // positive: succeeds when there were no Exception
        try {
            Und und = new Und(new Eingang(false), new Eingang(false));
            assertNotNull(und.getOperand1()); // assertTrue(und.getOperand1() != null);
        } catch (IllegalArgumentException e) {
            fail();
        }
        // negative: succeeds when there were an Exception
        try {
            Und und = new Und(new Eingang(false), null);
            fail(); // no Exception was thrown if this line executes --> test fails
        } catch (IllegalArgumentException e) {
        }
    }

    @Test
    public void testGetOperand1und2() {
        Und und = new Und(new Eingang(true), new Eingang(true));
        assertEquals(und.getOperand1().getOutput(), true);
        assertTrue(und.getOperand1().getOutput() == true);
    }
}
