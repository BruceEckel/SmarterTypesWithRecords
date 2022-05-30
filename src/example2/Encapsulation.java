// example2/Encapsulation.java
// Encapsulation with pre- and post-condition checks
package example2;
import util.Check;
import static util.Show.show;

class Stars {
  private int n;
  static void condition(int s) {
    Check.range(0 < s && s <= 10, s);
  }
  Stars(int n) {
    condition(n); // Precondition
    this.n = n;
  }
  Stars f1(int stars) {
    condition(stars); // Precondition
    n = stars * 10;
    condition(n); // Postcondition
    return this;
  }
  Stars f2(int stars) {
    condition(stars); // Precondition
    n = stars + 10;
    condition(stars); // Postcondition
    return this;
  }
  @Override public String toString() {
    return "Stars(" + n + ")";
  }
}

public class Encapsulation {
  public static void main(String[] args) {
    var stars1 = new Stars(6);
    show(stars1);
    show(stars1.f1(4));
    show(stars1.f2(6));
    var stars2 = new Stars(11);
    show(stars2.f1(3));
  }
}
/*
Stars(6)
Type failure: 40 out of range
Stars(40)
Stars(16)
Type failure: 11 out of range
Type failure: 30 out of range
Stars(30)
 */
