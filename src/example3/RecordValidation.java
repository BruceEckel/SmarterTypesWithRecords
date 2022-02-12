// Example 3: RecordValidation.java
// JDK 16 Records
package example3;
import util.Check;
import static util.Show.show;

record Stars(int n) {
  Stars {
    Check.range(0 < n && n <= 10, n);
  }
}

public class RecordValidation {
  static Stars f1(Stars stars) {
    return new Stars(stars.n() * 10);
  }
  static Stars f2(Stars stars) {
    return new Stars(stars.n() + 10);
  }
  public static void main(String[] args) {
    var stars1 = new Stars(6);
    // stars1.n = 99;  // Can't modify n
    show(stars1);
    show(f1(stars1));
    show(f2(stars1));
    var stars2 = new Stars(11);
    show(f1(stars2));
  }
}
