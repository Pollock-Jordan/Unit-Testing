import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PrimitiveValueTest {
  /* Need to test
   *  Black Box Testing
   *  1. A PrimitiveValue is not equal to a different Class
   *  2. A PrimitiveValue with the same string is equal
   *  3. String representation of a PrimitiveValue is correct
   */

  private final static String valueString = "\"value\"";

  @Test
    //  1. A PrimitiveValue is not equal to a different Class
  void testEqualsDifferentClass() {
    PrimitiveValue pv = new PrimitiveValue(valueString);
    String s = valueString;
    assertFalse(pv.equals(s), "A PrimitiveValue is equal to a String");
  }

  @Test
    //  2. A PrimitiveValue with the same string is equal
  void testEqualsSameString() {
    PrimitiveValue pv = new PrimitiveValue(valueString);
    PrimitiveValue pv2 = new PrimitiveValue(valueString);
    assertTrue(pv.equals(pv2), "PrimitiveValues created from same string are not equal");
  }

  @Test
    // 3. String representation of a PrimitiveValue is correct
  void testToString() {
    PrimitiveValue pv = new PrimitiveValue(valueString);
    assertEquals(pv.toString(), valueString, "PrimitiveValue has wrong string representation");
  }
}