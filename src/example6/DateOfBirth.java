// Example 6: DateOfBirth.java
package example6;
import util.Check;
import static util.Show.show;

record Day(int n) {
  Day {
    Check.range(0 < n && n <= 31, "Day(" + n + ")");
  }
}

enum Month {
  NONE(0),  // Only needed for this example
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
  Month(int max_days) {
    this.max_days = max_days;
  }
  public static Month number(int n) {
    if (Check.range(1 <= n && n <= 12, "Month.number(" + n + ")"))
      return values()[n];
    return NONE;
  }
  void check_day(Day day) {
    Check.range(day.n() <= max_days, "Month(" + this + ") " + day);
  }
}

record Year(int n) {
  Year {
    Check.range(1900 < n && n <= 2022, "Year(" + n + ")");
  }
}

record BirthDate(Month m, Day d, Year y) {
  BirthDate {
    m.check_day(d);
  }
}

public class DateOfBirth {
  record dob(int m, int d, int y) {
    dob {
      show(m + "/" + d + "/" + y);
      show(new BirthDate(Month.number(m), new Day(d), new Year(y)));
    }
  }
  public static void main(String[] args) {
    dob[] dates = {
        new dob(7, 8, 1957),
        new dob(0, 32, 1857),
        new dob(2, 31, 2022),
        new dob(9, 31, 2022),
        new dob(4, 31, 2022),
        new dob(6, 31, 2022),
        new dob(11, 31, 2022),
        new dob(12, 31, 2022),
    };
  }
}
