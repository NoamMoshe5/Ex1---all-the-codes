
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * This JUnit class represents a very partial test class for Ex1.
 * Make sure you complete all the needed JUnits
 */
public class Ex1Test {
    @Test
     public void computeNumberTest() {
        String s2 = "1011b2";
        int v = Ex1.number2Int(s2);
        assertEquals(11, v);

        String s10 = "1011bA";
        v = Ex1.number2Int(s10);
        s2 = Ex1.int2Number(v, 2);
        int v2 = Ex1.number2Int(s2);
        assertEquals(v, v2);

        assertTrue(Ex1.equals(s10, s2));
    }

    @Test
       public void isNumberTest() {
        String[] good = { "1b2", "01b2", "123bA", "ABbG", "0bA"};
        for (String s : good) {
            assertTrue("Expected valid number: " + s,Ex1.isNumber(s));
        }

        String[] notGood = {"b2", "2b2", "1G3bG", " BbG", "0bbA", "abB", "!@b2", "A", "1bb2"};
        for (String s : notGood) {
            assertFalse("Expected invalid number: " + s,Ex1.isNumber(s));
        }
    }

    @Test
    public void int2NumberTest() {
        assertEquals("1011b2", Ex1.int2Number(11, 2));
        assertEquals("1011bA", Ex1.int2Number(1011, 10));
        assertEquals("0b2", Ex1.int2Number(0, 2));
        assertEquals("", Ex1.int2Number(-1, 2)); // Invalid input
        assertEquals("", Ex1.int2Number(10, 17)); // Invalid base
    }

    @Test
    public void maxIndexTest() {
        String[] arr = {"1011b2", "123bA", "FFbG", "100bA"};
        int index = Ex1.maxIndex(arr);
        assertEquals(2, index); // "FFbG" is the largest number

        String[] arr2 = {"0b2", "10b2", "100b2", "1000b2"};
        assertEquals(3, Ex1.maxIndex(arr2));

        String[] arr3 = {"0b2", null, "10b2", "invalid", "100bA"};
        assertEquals(4, Ex1.maxIndex(arr3)); // Handles invalid numbers gracefully
    }

    @Test
    public void equalsTest() {
        assertTrue(Ex1.equals("1011b2", "11bA"));
        assertFalse(Ex1.equals("1011b2", "10bA"));
        assertFalse(Ex1.equals("invalid", "10bA"));
    }

    @Test
    public void edgeCasesTest() {
        // Edge cases
        assertEquals(-1, Ex1.number2Int("")); // Empty string
        assertEquals(-1, Ex1.number2Int(null)); // Null input
        assertEquals("", Ex1.int2Number(0, 17)); // Invalid base
        assertEquals(-1, Ex1.number2Int("0b1")); // Invalid base
        assertFalse(Ex1.isNumber("0b1")); // Invalid base
    }

        // Add additional test functions - test as much as you can.



    @Test
    public void number2IntTest() {
        // Valid cases
        assertEquals(11, Ex1.number2Int("1011b2")); // Binary
        assertEquals(12345, Ex1.number2Int("12345bA")); // Decimal
        assertEquals(15, Ex1.number2Int("FbG")); // Hexadecimal
        assertEquals(0, Ex1.number2Int("0b2")); // Zero in binary

        // Invalid cases
        assertEquals(-1, Ex1.number2Int("")); // Empty string
        assertEquals(-1, Ex1.number2Int(null)); // Null input
        assertEquals(-1, Ex1.number2Int("1b1")); // Invalid base
        assertEquals(-1, Ex1.number2Int("1bb2")); // Incorrect format
        assertEquals(-1, Ex1.number2Int("1234b11")); // Base out of range
    }



}
