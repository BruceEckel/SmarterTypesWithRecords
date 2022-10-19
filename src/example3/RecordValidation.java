// example3/RecordValidation.java
// Creating a type using JDK 16 records
package example3;
import java.util.HashMap;
import util.Check;
import static util.Show.show;

// Defines constructor, getters, equals, hashCode, toString
record Stars(int n) {
  Stars {  // "Compact" constructor for validation
    Check.range(0 < n && n <= 10, n);
  }
}

public class RecordValidation {
  static Stars f1(Stars stars) {
    return new Stars(stars.n() * 2);
  }
  static Stars f2(Stars stars) {
    return new Stars(stars.n() + 4);
  }
  static Stars f3(Stars s1, Stars s2) {
    return new Stars(s1.n() + s2.n());
  }
  public static void main(String[] args) {
    var one = new Stars(1);
    var two = new Stars(2);
    var three = new Stars(3);
    var eleven = new Stars(11);
    show(one);
    show(f1(one));
    show(f1(three));
    show(f2(two));
    show(f2(three));
    show(f3(one, three));
    show(f3(three, three));

    // Records can be keys in hashed data
    // structures because they define
    // equals() and hashCode():
    var m = new HashMap<Stars, String>();
    m.put(one, "one");
    m.put(two, "two");
    show(m);
  }
}
/*
Type failure: 11 out of range
Stars[n=1]
Stars[n=2]
Stars[n=6]
Stars[n=6]
Stars[n=7]
Stars[n=4]
Stars[n=6]
{Stars[n=1]=one, Stars[n=2]=two}
*/