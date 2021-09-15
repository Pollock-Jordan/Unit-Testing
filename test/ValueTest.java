import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValueTest {
  /* Need to test
   *  Black Box makeIndent
   *  1. makeIndent(-1) does not throw an exception
   *  2. makeIndent(0) returns zero space
   *  3. makeIndent(1) returns one space
   *  4. makeIndent(2) returns two spaces
   *  White Box getValue
   *  5. getValue returns a PrimitiveValue
   *  6. getValue returns an ArrayValue
   *  7. getValue returns an ObjectValue
   *  8. getValue returns null
   *
   * Not Testing
   * 1. listToString is tested with toString() methods of ArrayValue and ObjectValues
   */

  private final static String valueString = "\"value\"";
  private final static String arrayStringTwo = "[" + "\n" +
      "  \"value1\"" + "," + "\n" +
      "  \"value2\"" + "\n" +
      "]";
  private final static String objectStringTwoOrdered = "{" + "\n" +
      "  \"name\" : {" + "\n" +
      "  \"key1\" : \"value1\"" + "," + "\n" +
      "  \"key2\" : \"value2\"" + "\n" +
      "}" + "\n" +
      "}";

  @Test
    //  1. makeIndent(-1) does not throw an exception
  void makeIndent_negative() {
    JSONScanner js = new JSONScanner(valueString);
    Value v = Value.getValue(js);
    String s = v.makeIndent(-1);
  }

  @Test
    //  2. makeIndent(0) returns zero spaces
  void makeIndent_zero() {
    JSONScanner js = new JSONScanner(valueString);
    Value v = Value.getValue(js);
    String s = v.makeIndent(0);
    assertEquals("", s);
  }

  @Test
    //  3. makeIndent(1) returns one spaces
  void makeIndent_one() {
    JSONScanner js = new JSONScanner(valueString);
    Value v = Value.getValue(js);
    String s = v.makeIndent(1);
    assertEquals(" ", s);
  }

  @Test
    //  4. makeIndent(2) returns two spaces
  void makeIndent_two() {
    JSONScanner js = new JSONScanner(valueString);
    Value v = Value.getValue(js);
    String s = v.makeIndent(2);
    assertEquals("  ", s);
  }

  @Test
    //  5. getValue returns a PrimitiveValue
  void getValue_primitiveValue() {
    JSONScanner js = new JSONScanner(valueString);
    Value v = Value.getValue(js);
    assertTrue(v instanceof PrimitiveValue);
  }

  @Test
    //  6. getValue returns an ArrayValue
  void getValue_arrayValue() {
    JSONScanner js = new JSONScanner(arrayStringTwo);
    Value v = Value.getValue(js);
    assertTrue(v instanceof ArrayValue);
  }

  @Test
    //  7. getValue returns an ObjectValue
  void getValue_objectValue() {
    JSONScanner js = new JSONScanner(objectStringTwoOrdered);
    Value v = Value.getValue(js);
    assertTrue(v instanceof ObjectValue);
  }

  @Test
    //  8. getValue returns null
  void getValue_nullCurly() {
    JSONScanner js = new JSONScanner("}");
    Value v = Value.getValue(js);
    assertNull(v);
  }
}