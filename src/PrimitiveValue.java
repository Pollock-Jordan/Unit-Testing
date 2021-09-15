/* class for storing Primitive values (Strings, numbers, null, true, false)
 */
public class PrimitiveValue extends Value {
  private String value;               // All values are represented as String

  /* Constructor
   * param: String value to be stored
   */
  public PrimitiveValue(String s) {
    value = s;
  }

  /* Checks if object is equal to this primitive value
   * param: object v
   * return: true if this and object v are the same
  */
  public boolean equals(Object v) {
    //check if v is also a prim value AND that it's value is the same this value
    return (v instanceof PrimitiveValue) &&
            value.equals(((PrimitiveValue)v).value);
  }


  /* returns a String representation of the primitive value
   * return: String
   */
  public String toString() {
    return value;
  }
}
