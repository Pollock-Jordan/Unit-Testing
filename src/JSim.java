/* 
 * Author: Alex Brodsky
 * Class: CSCI 2110
 * Description: Sample implementation of code for determining if two JSON
 *    objects are identical
 */

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class JSim {

  /* Main method
   */
  public static void main(String [] args) {
    JSONScanner js = new JSONScanner(System.in);   
 
    Value v1 = Value.getValue(js);                // read in first object
    Value v2 = Value.getValue(js);                // read in second object

    System.out.println(v1);                       // print 1st object
    if (v1.equals(v2)) {                          // check if equals
      System.out.println("Objects are equal.");   
    } else {
      System.out.println(v2);                     // print 2nd object
      System.out.println("Objects are not equal.");
    }
  }
}
