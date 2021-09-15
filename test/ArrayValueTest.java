import org.junit.jupiter.api.Test;

import static java.time.Duration.ofSeconds;
import static org.junit.jupiter.api.Assertions.*;

class ArrayValueTest {
  /* Need to test
   *  Black Box Testing
   *  1. An ArrayValue is not equal to a different Class
   *  2. An ArrayValue with no members is equal
   *  3. An ArrayValue with the same single member is equal
   *  4. An ArrayValue with the same two members is equal
   *  5. String representation of an ArrayValue with no members is correct
   *  6. String representation of an ArrayValue with one member is correct
   *  7. String representation of an ArrayValue with two members is correct
   */

  private final static String arrayStringZero = "[" + "\n" +
      "]";
  private final static String arrayStringOne = "[" + "\n" +
      "  \"value1\"" + "\n" +
      "]";
  private final static String arrayStringTwo = "[" + "\n" +
      "  \"value1\"" + "," + "\n" +
      "  \"value2\"" + "\n" +
      "]";
  private final static String valueString = "value";


  @Test
    // 1. An ArrayValue is not equal to a different Class
  void testEqualsDifferentClass() {
    JSONScanner js = new JSONScanner(arrayStringTwo);
    String openBracket = js.next();
    ArrayValue av = new ArrayValue(js);
    String s = valueString;
    assertFalse(av.equals(s), "An ArrayValue is equal to a String");
  }

  @Test
    //  2. An ArrayValue with no members is equal
  void testEqualsZeroMembers() {
    JSONScanner js = new JSONScanner(arrayStringZero);
    String openBracket = js.next();
    ArrayValue av = new ArrayValue(js);
    JSONScanner js2 = new JSONScanner(arrayStringZero);
    String openBracket2 = js2.next();
    ArrayValue av2 = new ArrayValue(js2);
    assertTrue(av.equals(av2), "equals did not return correct value");
  }

  @Test
    //  3. An ArrayValue with the same single member is equal
  void testEqualsOneMember() {
    JSONScanner js = new JSONScanner(arrayStringOne);
    String openBracket = js.next();
    ArrayValue av = new ArrayValue(js);
    JSONScanner js2 = new JSONScanner(arrayStringOne);
    String openBracket2 = js2.next();
    ArrayValue av2 = new ArrayValue(js2);
    assertTrue(av.equals(av2), "equals did not return correct value");
  }

  @Test
    //  4. An ArrayValue with the same two members is equal
  void testEqualsTwoMembers() {
    JSONScanner js = new JSONScanner(arrayStringTwo);
    String openBracket = js.next();
    ArrayValue av = new ArrayValue(js);
    JSONScanner js2 = new JSONScanner(arrayStringTwo);
    String openBracket2 = js2.next();
    ArrayValue av2 = new ArrayValue(js2);
    assertTrue(av.equals(av2), "equals did not return correct value");
  }

  @Test
    //  5. String representation of an ArrayValue with no members is correct
  void testToStringZeroMembers() {
    JSONScanner js = new JSONScanner(arrayStringZero);

    String openBracket = js.next();
    ArrayValue av = new ArrayValue(js);
    assertEquals(arrayStringZero, av.toString(), "toString did not return correct value");

  }

  @Test
    //  6. String representation of an ArrayValue with one member is correct
  void testToStringOneMember() {
    JSONScanner js = new JSONScanner(arrayStringOne);
    String openBracket = js.next();
    ArrayValue av = new ArrayValue(js);
    assertEquals(arrayStringOne, av.toString(), "toString did not return correct value");
  }

  @Test
    //  7. String representation of an ArrayValue with two members is correct
  void testToStringTwoMembers() {
    JSONScanner js = new JSONScanner(arrayStringTwo);
    String openBracket = js.next();
    ArrayValue av = new ArrayValue(js);
    assertEquals(arrayStringTwo, av.toString(), "toString did not return correct value");
  }
}