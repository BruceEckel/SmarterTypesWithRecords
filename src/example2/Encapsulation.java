// example2/Encapsulation.java
// Encapsulation with validation checks
package example2;
import util.Check;
import static util.Show.show;

class Stars {
  private int n;
  static void validate(int s) {
    Check.range(0 < s && s <= 10, s);
  }
  Stars(int n) {
    validate(n);
    this.n = n;
  }
  int n() { return n; }
  Stars f1(Stars stars) {
    n = stars.n * 2;
    validate(n);
    return this;
  }
  Stars f2(Stars stars) {
    n = stars.n + 4;
    validate(n);
    return this;
  }
  static Stars f3(Stars s1, Stars s2) {
    return new Stars(s1.n + s2.n);
  }
  @Override public String toString() {
    return "Stars(" + n + ")";
  }
}

public class Encapsulation {
  public static void main(String[] args) {
    Stars[] s = {
      new Stars(1), new Stars(3),
      new Stars(4), new Stars(6),
      new Stars(11),
    };
    show(Stars.f3(s[1], s[3]));
    var s1 = s[1];
    show(s1);
    show(s1.f1(s[2]));
    show(s1.f2(s[3]));
    show(s1.f2(s1));
  }
}
/*
Type failure: 11 out of range
Stars(9)
Stars(3)
Stars(8)
Stars(10)
Type failure: 14 out of range
Stars(14)
 */
