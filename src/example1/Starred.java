// example1/Starred.java
// 1-10 stars for giving feedback
package example1;
import util.Check;
import static util.Show.show;

public class Starred {
  static int f1(int stars) {
    Check.range(
      0 < stars && stars <= 10, stars);
    return stars * 2;
  }
  static int f2(int stars) {
    Check.range(
      0 < stars && stars <= 10, stars);
    return stars + 4;
  }
  public static void main(String[] args) {
    int stars1 = 6;
    show(stars1);
    show(f1(stars1));
    show(f2(stars1));
    int stars2 = 11;
    show(f1(stars2));
    stars1 = 99;
    show(f2(stars1));
  }
}
/*
6
12
10
Type failure: 11 out of range
22
Type failure: 99 out of range
103
*/
