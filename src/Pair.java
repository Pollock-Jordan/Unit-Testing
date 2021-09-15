/* class for storing key-value pairs
 */
public class Pair implements Comparable<Pair> {
  private String name;                   // key 
  private Value value;                   // value

  /* Constructor
   * param: key and value to be stored
   */
  public Pair(String nm, Value val) {
    name = nm;
    value = val;
  }

  /* Checks if object is equal to this Pair
   * param: object v
   * return: true if Pair, keys are the same and values are the same.
   */
  public boolean equals(Object v) { 
    return (v instanceof Pair) && name.equals(((Pair)v).name) &&
           value.equals(((Pair)v).value);
  }

  /* Compares keys of Pairs and returns <0, 0, >0 if this key comes before, 
   * at, or after Pair p's key.
   * param: Pair p
   * return: integer, as described above
   */
  public int compareTo(Pair p) {
    //new string to hold only the key of the param pair
    String n = "" + p.toString().charAt(0);
    int count = 1;
    //exract the key from the param pair
    while(p.toString().charAt(count) != ('\"')) {
      n = n + p.toString().charAt(count);
      count++;
    }
    n = n + '\"';

    return name.compareTo(n);
  }

  /* returns a String representation of the Pair
   * return: String
   */
  public String toString() {
    return name + " : " + value;
  }
}
