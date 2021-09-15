/* class for storing JSON Objects
 */

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class ObjectValue extends Value {
  // List of Key-Value pairs
  private final ArrayList<Pair> members = new ArrayList<Pair>();

  /* Constructor
   * param: Scanner object for reading the tokens
   */
  public ObjectValue(JSONScanner js) {
    String name = js.next();              // grab token

    if (!name.equals("}")) {             // loop until object ends
      while (true) {                     // token is the key of next pair
        js.next();
        members.add(new Pair(name, Value.getValue(js)));  // Add new pair
        if (js.next().equals("}")) {     // either ",", or "}",
          break;
        }
        name = js.next();
      }

      Collections.sort(members);        // sort Pairs in the object
    }
  }


  /* Checks if object is equal to this JSON Object
   * param: object v
   * return: true if this and object v are the same
   */
  public boolean equals(Object v) {
    return (v instanceof ObjectValue) && 
           members.equals(((ObjectValue)v).members);
  }

  /* returns a String representation of the object
   * return: String
   */
  public String toString() {
    return listToString(members, '{', '}');
  }
}
