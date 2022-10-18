// example5/DateOfBirth.java
// An enum is also a type, and is preferable
// when you have a smaller set of values.
// "Leap years are left as an exercise."
package example5;
import util.Check;
import static util.Show.show;

record Day(int n) {
  Day {
    Check.range(0 < n && n <= 31, this);
  }
}

enum Month {
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
  DECEMBER(31),
  // Only needed for this example:
  NONE(0);
  final int maxDays;
  Month(int maxDays) {
    this.maxDays = maxDays;
  }
  public static Month number(int n) {
    if (Check.range(1 <= n && n <= 12,
        "Month.number(" + n + ")")) {
      return values()[n - 1];
    }
    return NONE;
  }
  void checkDay(Day day) {
    Check.range(day.n() <= maxDays,
      this + ": " + day);
  }
}

record Year(int n) {
  Year {
    Check.range(1900 < n && n <= 2022, this);
  }
}

record BirthDate(Month m, Day d, Year y) {
  BirthDate {
    m.checkDay(d);
  }
}

public class DateOfBirth {
  static void test(int m, int d, int y) {
    show(m + "/" + d + "/" + y);
    show(new BirthDate(
      Month.number(m), new Day(d), new Year(y)
    ));
  }
  public static void main(String[] args) {
    test(7, 8, 1957);
    test(0, 32, 1857);
    test(2, 31, 2022);
    test(9, 31, 2022);
    test(4, 31, 2022);
    test(6, 31, 2022);
    test(11, 31, 2022);
    test(12, 31, 2022);
    test(13, 31, 2022);
  }
}
/*
7/8/1957
BirthDate[m=JULY, d=Day[n=8], y=Year[n=1957]]
0/32/1857
Type failure: Month.number(0) out of range
Type failure: Day[n=0] out of range
Type failure: Year[n=0] out of range
Type failure: NONE: Day[n=32] out of range
BirthDate[m=NONE, d=Day[n=32], y=Year[n=1857]]
2/31/2022
Type failure: FEBRUARY: Day[n=31] out of range
BirthDate[m=FEBRUARY, d=Day[n=31], y=Year[n=2022]]
9/31/2022
Type failure: SEPTEMBER: Day[n=31] out of range
BirthDate[m=SEPTEMBER, d=Day[n=31], y=Year[n=2022]]
4/31/2022
Type failure: APRIL: Day[n=31] out of range
BirthDate[m=APRIL, d=Day[n=31], y=Year[n=2022]]
6/31/2022
Type failure: JUNE: Day[n=31] out of range
BirthDate[m=JUNE, d=Day[n=31], y=Year[n=2022]]
11/31/2022
Type failure: NOVEMBER: Day[n=31] out of range
BirthDate[m=NOVEMBER, d=Day[n=31], y=Year[n=2022]]
12/31/2022
BirthDate[m=DECEMBER, d=Day[n=31], y=Year[n=2022]]
13/31/2022
Type failure: Month.number(13) out of range
Type failure: NONE: Day[n=31] out of range
BirthDate[m=NONE, d=Day[n=31], y=Year[n=2022]]
*/