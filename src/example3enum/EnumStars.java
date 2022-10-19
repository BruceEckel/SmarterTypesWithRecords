// example3enum/EnumStars.java
// An enum creates a predefined set of values
package example3enum;
import static example3enum.Stars.*;
import static util.Show.show;

enum Stars {
  NONE,
  ONE, TWO, THREE, FOUR, FIVE,
  SIX, SEVEN, EIGHT, NINE, TEN;
  final int n;
  Stars() {
    this.n = ordinal();
  }
}

public class EnumStars {
  private static Stars result(int n_stars) {
    if (0 < n_stars && n_stars <= 10)
      return Stars.values()[n_stars];
    return NONE; // Throw exception instead
  }
  static Stars f1(Stars stars) {
    return result(stars.n * 2);
  }
  static Stars f2(Stars stars) {
    return result(stars.n + 4);
  }
  static Stars f3(Stars s1, Stars s2) {
    return result(s1.n + s2.n);
  }
  public static void main(String... args) {
    show(ONE);
    show(f1(ONE));
    show(f1(THREE));
    show(f2(TWO));
    show(f2(THREE));
    show(f3(ONE, FOUR));
    show(f3(THREE, THREE));
  }
}
/*
ONE
TWO
SIX
SIX
SEVEN
FIVE
SIX
*/