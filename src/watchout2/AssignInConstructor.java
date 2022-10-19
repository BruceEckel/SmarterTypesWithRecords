// watchout2/AssignInConstructor.java
// More possibly surprising behavior
package watchout2;
import static util.Show.show;

record Stars(int n) {
  Stars {
    // this.n = 42;
    // Cannot assign a value to final variable 'n'
    // show(this.n);
    // Variable 'this.n' might not have been initialized
    n();
  }
}

class Stars2 {
  final int n;
  Stars2(int n) {
    this.n = n;
  }
  @Override public String toString() { return "Stars2[n=" + n + "]"; }
}

record Stars3(int n) {
  Stars3 { n = 4; }
}

public class AssignInConstructor {
  public static void main(String[] args) {
    show(new Stars(1));
    show(new Stars2(2));
    show(new Stars3(3));
  }
}
/*
Stars[n=1]
Stars2[n=2]
Stars3[n=4]
*/