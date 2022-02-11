// Example 3: ConstructorTypeValidation.java
package example3;
import check.Check;

class Stars {
    final int n;
    Stars(int n) {
        this.n = n;
        Check.validity(0 < n && n <= 10, n + " out of range");
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
        System.out.println(stars1);
        System.out.println(f1(stars1));
        System.out.println(f2(stars1));
        var stars2 = new Stars(11);
        System.out.println(f1(stars2));
    }
}
