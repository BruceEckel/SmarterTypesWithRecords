// watchout/RecordConstructor.java
// Possibly surprising behavior in compact constructor
package watchout;
import static util.Show.show;

record Stars(int n) {
  Stars {
    show("In compact constructor:");
    show("n: " + n + ", n(): " + n());
    // show("this.n: " + this.n);
    // Variable 'this.n' might not have
    // been initialized
    x();
  }
  void x() {
    show("n: " + n + ", n(): " + n());
    show("this.n: " + this.n);
  }
}

public class RecordConstructor {
  public static void main(String[] args) {
    var s = new Stars(10);
    show("After construction:");
    s.x();
  }
}
/*
In compact constructor:
n: 10, n(): 0
n: 0, n(): 0
this.n: 0
After construction:
n: 10, n(): 10
this.n: 10
*/