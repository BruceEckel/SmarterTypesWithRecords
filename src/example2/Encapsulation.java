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
    n = n % 5 + stars.n * 2;
    validate(n);
    return this;
  }
  Stars f2(Stars stars) {
    n = n % 5 + stars.n + 2;
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
    var one = new Stars(1);
    var two = new Stars(2);
    var three = new Stars(3);
    var eleven = new Stars(11);
    show(Stars.f3(one, three));
    show(one);
    show(one.f1(two));
    show(one.f2(three));
    show(one.f2(one));
    show(one.f2(one));
  }
}
/*
Type failure: 11 out of range
Stars(4)
Stars(1)
Stars(5)
Stars(5)
Stars(7)
Type failure: 11 out of range
Stars(11)
*/
