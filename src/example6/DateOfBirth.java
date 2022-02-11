// Example 6: DateOfBirth.java
package example6;
import check.Check;

record Day(int day) {
    Day {
        Check.range(0 < day && day <= 31, day + ": day of month");
    }
}

record Month(int month) {
    Month {
        Check.range(0 < month && month <= 12, "Month(" + month + ")");
    }
}

record Year(int year) {
    Year {
        Check.range(1900 < year && year <= 2022, "Year(" + year + ")");
    }
}

record BirthDate(Month m, Day d, Year y) {}

public class DateOfBirth {
    public static void main(String[] args) {
        System.out.println(new BirthDate(new Month(7), new Day(8), new Year(1957)));
        System.out.println(new BirthDate(new Month(0), new Day(32), new Year(1857)));
    }
}
