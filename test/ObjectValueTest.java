import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class ObjectValueTest {
  /* Need to test
   *  Black Box Testing
   *  1. An ObjectValue is not equal to a different Class
   *  2. An ObjectValue with no members is equal
   *  3. An ObjectValue with the same single member is equal
   *  4. An ObjectValue with the same two members is equal
   *  5. An ObjectValue with the same two members in a different order is equal
   *  6. String representation of an ObjectValue with no members is correct
   *  7. String representation of an ObjectValue with one member is correct
   *  8. String representation of an ObjectValue with two members is correct
   *  9. String representation of an ObjectValue with two members in a different order is correct
   */

  private final static String objectStringZero = "{" + "\n" +
      "  \"name\" : {" + "\n" +
      "}" + "\n" +
      "}";
  private final static String objectStringOne = "{" + "\n" +
      "  \"name\" : {" + "\n" +
      "  \"key1\" : \"value1\"" + "\n" +
      "}" + "\n" +
      "}";
  private final static String objectStringTwoOrdered = "{" + "\n" +
      "  \"name\" : {" + "\n" +
      "  \"key1\" : \"value1\"" + "," + "\n" +
      "  \"key2\" : \"value2\"" + "\n" +
      "}" + "\n" +
      "}";
  private final static String objectStringTwoUnordered = "{" + "\n" +
      "  \"name\" : {" + "\n" +
      "  \"key2\" : \"value2\"" + "," + "\n" +
      "  \"key1\" : \"value1\"" + "\n" +
      "}" + "\n" +
      "}";
  private final static String valueString = "\"value\"";

  /*
  {
    "name"{
    "key1":"value1"
  }
  }
   */


  @Test
    // 1. An ObjectValue is not equal to a different Class
  void testEqualsDifferentClass() {
    JSONScanner js = new JSONScanner(objectStringTwoOrdered);
    String openBracket = js.next();
    ObjectValue ov = new ObjectValue(js);
    String s = valueString;
    assertFalse(ov.equals(s), "An ObjectValue is equal to a String");
  }

  @Test
    //  2. An ObjectValue with no members is equal
  void testEqualsZeroMembers() {
    JSONScanner js = new JSONScanner(objectStringZero);
    String openBracket = js.next();
    ObjectValue ov = new ObjectValue(js);
    JSONScanner js2 = new JSONScanner(objectStringZero);
    String openBracket2 = js2.next();
    ObjectValue ov2 = new ObjectValue(js2);
    assertTrue(ov.equals(ov2), "equals did not return correct value");
  }

  @Test
    //  3. An ObjectValue with the same single member is equal
  void testEqualsOneMember() {
    JSONScanner js = new JSONScanner(objectStringOne);
    String openBracket = js.next();
    ObjectValue ov = new ObjectValue(js);
    JSONScanner js2 = new JSONScanner(objectStringOne);
    String openBracket2 = js2.next();
    ObjectValue ov2 = new ObjectValue(js2);
    assertTrue(ov.equals(ov2), "equals did not return correct value");
  }

  @Test
    //  4. An ObjectValue with the same two members is equal
  void testEqualsTwoMembers() {
    JSONScanner js = new JSONScanner(objectStringTwoOrdered);
    String openBracket = js.next();
    ObjectValue ov = new ObjectValue(js);
    JSONScanner js2 = new JSONScanner(objectStringTwoOrdered);
    String openBracket2 = js2.next();
    ObjectValue ov2 = new ObjectValue(js2);
    assertTrue(ov.equals(ov2), "equals did not return correct value");
  }

  @Test
    //  5. An ObjectValue with the same two members in a different order is equal
  void testEqualsTwoMembersDifferentOrder() {
    JSONScanner js = new JSONScanner(objectStringTwoOrdered);
    String openBracket = js.next();
    ObjectValue ov = new ObjectValue(js);
    JSONScanner js2 = new JSONScanner(objectStringTwoUnordered);
    String openBracket2 = js2.next();
    ObjectValue ov2 = new ObjectValue(js2);
    assertTrue(ov.equals(ov2), "equals did not return correct value");
  }

  @Test
    //  6. String representation of an ObjectValue with no members is correct
  void testToStringZeroMembers() {
    JSONScanner js = new JSONScanner(objectStringZero);
    String openBracket = js.next();
    ObjectValue ov = new ObjectValue(js);
    assertEquals(objectStringZero, ov.toString(), "toString did not return correct value");
  }

  @Test
    //  7. String representation of an ObjectValue with one member is correct
  void testToStringOneMember() {
    JSONScanner js = new JSONScanner(objectStringOne);
    String openBracket = js.next();
    ObjectValue ov = new ObjectValue(js);
    assertEquals(objectStringOne, ov.toString(), "toString did not return correct value");
  }

  @Test
    //  8. String representation of an ObjectValue with two members is correct
  void testToStringTwoMembers() {
    JSONScanner js = new JSONScanner(objectStringTwoOrdered);
    String openBracket = js.next();
    ObjectValue ov = new ObjectValue(js);
    assertEquals(objectStringTwoOrdered, ov.toString(), "toString did not return correct value");
  }

  @Test
    //  9. String representation of an ObjectValue with two members in a different order is correct
  void testToStringTwoMembersDifferentOrder() {
    JSONScanner js = new JSONScanner(objectStringTwoUnordered);
    String openBracket = js.next();
    ObjectValue ov = new ObjectValue(js);
    assertEquals(objectStringTwoOrdered, ov.toString(), "toString did not return correct value");
  }

}