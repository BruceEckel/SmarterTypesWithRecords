// example3enum/EnumStars.java
// An enum creates a predefined set of values
package example3enum;
import static example3enum.Stars.*;
import static util.Show.show;

enum Stars {
  ONE, TWO, THREE, FOUR, FIVE,
  SIX, SEVEN, EIGHT, NINE, TEN;
  final int n;
  Stars() {
    this.n = ordinal() + 1;
  }
  public static Stars index(int i) {
    return values()[i - 1];
  }
}

public class EnumStars {
  static Stars f1(Stars stars) {
    return Stars.index(stars.n * 2);
  }
  static Stars f2(Stars stars) {
    return Stars.index(stars.n + 4);
  }
  static Stars f3(Stars s1, Stars s2) {
    return Stars.index(s1.n + s2.n);
  }
  public static void main(String... args) {
    show(ONE);
    show(f1(ONE));
    show(f1(THREE));
    show(f2(TWO));
    show(f2(THREE));
    show(f3(ONE, FOUR));
    show(f3(THREE, THREE));
    try {
      f3(TEN, TEN);
    } catch (Exception e) {
      show(e);
    }
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
java.lang.ArrayIndexOutOfBoundsException: Index 19 out of bounds for length 10
*/