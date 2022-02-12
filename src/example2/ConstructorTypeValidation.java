package example2;
// "A type is a set of values"
// "Make illegal values unrepresentable"
import util.Check;
import static util.Show.show;

class Stars {
  final int n;
  Stars(int n) {
    this.n = n;
    Check.range(0 < n && n <= 10, n);
  }
  @Override
  public String toString() {
    return "Stars(" + n + ")";
  }
}

public class ConstructorTypeValidation {
  static Stars f1(Stars stars) {
    return new Stars(stars.n * 10);
  }
  static Stars f2(Stars stars) {
    return new Stars(stars.n + 10);
  }
  public static void main(String[] args) {
    var stars1 = new Stars(6);
    show(stars1);
    show(f1(stars1));
    show(f2(stars1));
    var stars2 = new Stars(11);
    show(f1(stars2));
  }
}
