// Example 6: DateOfBirth.java
package example6;
import check.Check;
import java.util.Arrays;

record Day(int n) {
    Day {
        Check.range(0 < n && n <= 31, "Day(" + n + ")");
    }
}

record Month(int n) {
    Month {
        Check.range(0 < n && n <= 12, "Month(" + n + ")");
    }
}

enum Month2 {
    JANUARY(31),
    FEBRUARY(28),
    MARCH(31),
    APRIL(30),
    MAY(31),
    JUNE(30),
    JULY(31),
    AUGUST(31),
    SEPTEMBER(30),
    OCTOBER(31),
    NOVEMBER(30),
    DECEMBER(31);
    final int max_days;
    Month2(int max_days) {
        this.max_days = max_days;
    }
    public Month2 number(int n) {
        Check.range(0 < n && n <= 12, "Month.number(" + n + ")");
        return values()[n -1]; // Zero-indexed
    }
    void check_day(Day day) {
        Check.range(day.n() <= max_days, this.toString() + day.n());
    }
}

record Year(int n) {
    Year {
        Check.range(1900 < n && n <= 2022, "Year(" + n + ")");
    }
}

record BirthDate(Month m, Day d, Year y) {
    BirthDate {
        // m.
    }
}

public class DateOfBirth {
    public static void main(String[] args) {
        for(var m: Month2.values())
            System.out.println(m);
//        Month2 m2 = Month2.
        var bd1 = new BirthDate(new Month(7), new Day(8), new Year(1957));
        System.out.println(bd1);
        var bd2 = new BirthDate(new Month(0), new Day(32), new Year(1857));
        System.out.println(bd2);
    }
}
