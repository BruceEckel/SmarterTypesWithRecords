// Example 1: Starred.java
package example1;
import check.Check;

public class Starred {
    static int f1(int stars) {
        Check.range(0 < stars && stars <= 10, stars);
        return stars * 10;
    }
    static int f2(int stars) {
        Check.range(0 < stars && stars <= 10, stars);
        return stars + 10;
    }
    public static void main(String[] args) {
        int stars1 = 6;
        System.out.println(stars1);
        System.out.println(f1(stars1));
        System.out.println(f2(stars1));
        int stars2 = 11;
        System.out.println(f1(stars2));
        stars1 = 99;
        System.out.println(f2(stars1));
    }
}
