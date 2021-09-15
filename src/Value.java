/* Base class for all JSON Values (Objects, Arrays, or Primitive/Simple
*/

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Value {
  protected int indentValue = 0;   // used to track indent for printing

  /* Build a string of spaces
   * param: ind : number of spaces
   * return: String of spaces
   */
  protected String makeIndent(int ind) {
    if (ind >= 0) {
      char [] spaces = new char[ind];
      Arrays.fill(spaces, ' ');
      return new String(spaces);
    }
    else {
      return "";
    }
  }

  /* Parse a JSON Value
   * param: js : the JSON token scanner
   * return: Value object, that is JSONObject, JSONArray, or JSONPrimitive
   */
  public static Value getValue(JSONScanner js) {
    String s = js.next();              // read in next token

    switch (s.charAt(0)) {             // create appropriate value
    case '{':
      return new ObjectValue(js);
    case '[':
      return new ArrayValue(js);
    case ')':
    case '}':
      case ']':
      return null;
    default:
      return new PrimitiveValue(s);
    }
  }

  /* Utility function for converting a JSON object / array into a string
   * param: al : list of objects/arrays
   *        left : left bracket to use
   *        right : right bracket to use
   * return: String of object or array
   */
  public String listToString(ArrayList al, char left, char right) {
    String str = null;                          // String we will build
    String indent = makeIndent(indentValue);    // Indent for values
    indentValue += 2;                           // indent nested vau

    for (Object o : al) {                       // loop over list to build str
      if (str == null) {
        str = indent + "  " + o.toString();     // first item
      } else {
        str += ",\n" + indent + "  " + o.toString();  // remaining items
      }
    }

    indentValue -= 2;
    if (str == null) {                          // add brackets    
      return left + "\n" + indent + right;
    } else {
      return left + "\n" + str + "\n" + indent + right;
    }
  }
}
