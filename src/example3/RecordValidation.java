// example3/RecordValidation.java
// JDK 16 Records
package example3;
import util.Check;
import java.util.HashMap;
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
    show(f3(s[1], s[3]));
    var s1 = s[1];
    show(s1);
    show(f1(s[2]));
    show(f2(s[3]));
    show(f2(s1));

    var stars1 = new Stars(6);
    // stars1.n = 99;  // Can't modify n
    show(stars1);
    show(f1(stars1));
    show(f2(stars1));
    var stars2 = new Stars(11);
    show(f1(stars2));
    // Records can be keys in hashed data structures,
    // because they define equals() and hashCode():
    var m = new HashMap<Stars, String>();
    m.put(stars1, "stars1");
    m.put(stars2, "stars2");
    show(m);
  }
}
