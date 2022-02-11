// Example 2: DistributedTypeValidation.java
package example2;
import check.Check;

class Stars {
    int n;
    Stars(int n) { this.n = n; }
    @Override
    public String toString() {
        return "Stars(" + n + ")";
    }
}

public class DistributedTypeValidation {
    static Stars f1(Stars stars) {
        Check.validity(0 < stars.n && stars.n <= 10, stars.n + " out of range");
        return new Stars(stars.n * 10);
    }
    static Stars f2(Stars stars) {
        Check.validity(0 < stars.n && stars.n <= 10, stars.n + " out of range");
        return new Stars(stars.n + 10);
    }
    public static void main(String[] args) {
        var stars1 = new Stars(6);
        System.out.println(stars1);
        System.out.println(f1(stars1));
        System.out.println(f2(stars1));
        var stars2 = new Stars(11);
        System.out.println(f1(stars2));
        stars1.n = 99;
        System.out.println(f2(stars1));
    }
}
