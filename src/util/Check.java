// util/Check.java
package util;
import static util.Show.show;

public class Check {
  public static boolean
  valid(Boolean exp, String errInfo) {
    if (!exp) {
      show("Type failure: " + errInfo);
      return false;
      // Should actually throw an
      // exception, but this allows us
      // to see complete example output.
    }
    return true;
  }
  public static boolean
  range(Boolean exp, Object errInfo) {
    return valid(exp,
      errInfo + " out of range");
  }
}