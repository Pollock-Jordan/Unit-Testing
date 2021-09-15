/* class for storing JSON Arrays
 */

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class ArrayValue extends Value {
  // List of values in the array
  private final ArrayList<Value> members = new ArrayList<Value>();

  /* Constructor
   * param: Scanner object for reading the tokens
   */
  public ArrayValue(JSONScanner js) {
        Value v = Value.getValue(js);        // Get next value, null if no more

        if (v != null) {
          while (true) {                    // loop, getting values
            members.add(v);
            if (js.next().equals("]")) {    // either a "," or "]"
              break;
            }

            v = Value.getValue(js);         // next value
          }
        }
  }

  /* Checks if object is equal to this JSON Array
   * param: object v
   * return: true if this and array v are the same
   */
  public boolean equals(Object v) {
    return (v instanceof ArrayValue) && 
           members.equals(((ArrayValue)v).members);
  }

  /* returns a String representation of the array
   * return: String
   */
  public String toString() {
    return listToString(members, '[', ']');
  }
}
