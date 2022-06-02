package watchout2;

record Stars(int n) {
  Stars {
    // this.n = 42;
    // Cannot assign a value to final variable 'n'
    // System.out.println(this.n);
    // Variable 'this.n' might not have been initialized
    n();
  }
  @Override public int n() { return this.n; }
}

class Stars2 {
  final int n;
  Stars2(int n) {
    this.n = n;
  }
}

public class AssignInConstructor {
  public static void main(String[] args) {
    System.out.println(new Stars(1));
    System.out.println(new Stars2(2));
  }
}
