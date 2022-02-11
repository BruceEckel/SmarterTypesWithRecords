// Example 4: RecordValidation.java
// JDK 16 Records
package example4;
import check.Check;

record Stars(int n) {
    Stars {
        Check.range(0 < n && n <= 10, n);
    }
}

public class RecordValidation {
    static Stars f1(Stars stars) {
        return new Stars(stars.n() * 10);
    }
    static Stars f2(Stars stars) {
        return new Stars(stars.n() + 10);
    }
    public static void main(String[] args) {
        var stars1 = new Stars(6);
        System.out.println(stars1);
        System.out.println(f1(stars1));
        System.out.println(f2(stars1));
        var stars2 = new Stars(11);
        System.out.println(f1(stars2));
        // stars1.n = 99;  // Can 't modify n
    }
}
