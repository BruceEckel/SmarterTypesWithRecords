package watchout2;

record Stars(int n) {
  Stars {
    // this.n = 42;
    // Cannot assign a value to final variable 'n'
    // System.out.println(this.n);
    // Variable 'this.n' might not have been initialized
    n();
  }
}

class Stars2 {
  final int n;
  Stars2(int n) {
    this.n = n;
  }
}

record Stars3(int n) {
  Stars3 {
    n = 4;
  }
}

public class AssignInConstructor {
  public static void main(String[] args) {
    System.out.println(new Stars(1));
    System.out.println(new Stars2(2));
    var s3 = new Stars3(2);
    System.out.println(s3);
  }
}
