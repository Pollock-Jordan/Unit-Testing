import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class PairTest {
  /* Need to test
   *  Black Box Testing
   *  1. A Pair is not equal to a different Class
   *  2. A Pair with the same name but different value is not equal
   *  3. A Pair with the same name and value is equal
   *  4. CompareTo returns <0 if this.key < p.key
   *  5. CompareTo returns 0 if this.key = p.key
   *  6. CompareTo returns >0 if this.key > p.key
   *  7. String representation of a Pair is correct
   */

  private final static String pairString = "\"key\" : \"value\"";
  private final static String keyString = "\"key\"";
  private final static String keyStringA = "\"keya\"";
  private final static String keyStringB = "\"keyb\"";
  private final static String valueString = "\"value\"";
  private final static String valueString2 = "\"value2\"";

  @Test
    //  1. A Pair is not equal to a different Class
  void testEqualsDifferentClass() {
    PrimitiveValue pv = new PrimitiveValue(valueString);
    Pair pair = new Pair(keyString, pv);
    String s = pairString;
    assertFalse(pair.equals(s), "A pair is equal to a String");
  }

  @Test
    //  2. A Pair with the same name but different value is not equal
  void testEqualsSameKeyDifferentValue() {
    PrimitiveValue pv = new PrimitiveValue(valueString);
    Pair pair = new Pair(keyString, pv);
    PrimitiveValue pv2 = new PrimitiveValue(valueString2);
    Pair pair2 = new Pair(keyString, pv2);
    assertFalse(pair.equals(pair2), "A pair is equal to a String");
  }

  @Test
    //  3. A Pair with the same name and value is equal
  void testEqualsSameKeySameValue() {
    PrimitiveValue pv = new PrimitiveValue(valueString);
    Pair pair = new Pair(keyString, pv);
    PrimitiveValue pv2 = new PrimitiveValue(valueString);
    Pair pair2 = new Pair(keyString, pv2);
    assertTrue(pair.equals(pair2), "A pair is equal to a String");
  }

  @Test
    //  4. CompareTo returns <0 if this.key < p.key
  void testCompareToLess() {
    PrimitiveValue pv = new PrimitiveValue(valueString);
    Pair pair = new Pair(keyStringA, pv);
    PrimitiveValue pv2 = new PrimitiveValue(valueString);
    Pair pair2 = new Pair(keyStringB, pv);
    assertTrue(pair.compareTo(pair2) < 0, "compareTo() did not return < 0");
  }

  @Test
    //  5. CompareTo returns 0 if this.key = p.key
  void testCompareToEqual() {
    PrimitiveValue pv = new PrimitiveValue(valueString);
    Pair pair = new Pair(keyStringA, pv);
    PrimitiveValue pv2 = new PrimitiveValue(valueString);
    Pair pair2 = new Pair(keyStringA, pv);
    assertTrue(pair.compareTo(pair2) == 0, "compareTo() did not return == 0");
  }

  @Test
    //  6. CompareTo returns >0 if this.key > p.key
  void testCompareToGreater() {
    PrimitiveValue pv = new PrimitiveValue(valueString);
    Pair pair = new Pair(keyStringB, pv);
    PrimitiveValue pv2 = new PrimitiveValue(valueString);
    Pair pair2 = new Pair(keyStringA, pv);
    assertTrue(pair.compareTo(pair2) > 0, "compareTo() did not return > 0");
  }

  @Test
    //  7. String representation of a Pair is correct
  void testToString() {
    PrimitiveValue pv = new PrimitiveValue(valueString);
    Pair pair = new Pair(keyString, pv);
    assertEquals(pairString, pair.toString(),
        "ToString() did not return correct value");
  }

}