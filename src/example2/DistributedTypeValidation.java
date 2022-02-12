// Example 2: DistributedTypeValidation.java
// {{ Remove this step }}
package example2;
import util.Check;
import static util.Show.show;

class Stars {
  int n;
  Stars(int n) {
    this.n = n;
  }
  @Override
  public String toString() {
    return "Stars(" + n + ")";
  }
}

public class DistributedTypeValidation {
  static Stars f1(Stars stars) {
    Check.range(0 < stars.n && stars.n <= 10, stars.n);
    return new Stars(stars.n * 10);
  }
  static Stars f2(Stars stars) {
    Check.range(0 < stars.n && stars.n <= 10, stars.n);
    return new Stars(stars.n + 10);
  }
  public static void main(String[] args) {
    var stars1 = new Stars(6);
    show(String.valueOf(stars1));
    show(f1(stars1));
    show(f2(stars1));
    var stars2 = new Stars(11);
    show(f1(stars2));
    stars1.n = 99;   // Can mutate to an invalid Stars
    show(stars1 + ": Didn't detect problem!");
    // So, still need to validate Stars inside functions
    show(f2(stars1));
  }
}
