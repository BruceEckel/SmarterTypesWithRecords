// example3/RecordValidation.java
// Creating a type using JDK 16 records
package example3;
import java.util.HashMap;
import util.Check;
import static util.Show.show;

record Stars(int n) {
  Stars {
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
    Stars[] s = {
        new Stars(1), new Stars(3),
        new Stars(4), new Stars(6),
        new Stars(11),
    };
    show(s[1]);
    show(f1(s[1]));
    show(f1(s[3]));
    show(f2(s[2]));
    show(f2(s[3]));
    show(f3(s[1], s[3]));
    show(f3(s[3], s[3]));

    // Records can be keys in hashed data structures,
    // because they define equals() and hashCode():
    var m = new HashMap<Stars, String>();
    m.put(s[1], "one");
    m.put(s[2], "two");
    show(m);
  }
}
/*
Type failure: 11 out of range
Stars[n=3]
Stars[n=6]
Type failure: 12 out of range
Stars[n=12]
Stars[n=8]
Stars[n=10]
Stars[n=9]
Type failure: 12 out of range
Stars[n=12]
{Stars[n=3]=one, Stars[n=4]=two}
 */