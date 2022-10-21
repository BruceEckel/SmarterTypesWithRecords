package watchout4;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

record ListRecord(List<String> strings) {}

record ArrayRecord(String[] strings) {
  @Override
  public String toString() {
    return "ArrayRecord[strings=" + Arrays.toString(strings) + "]";
  }
}

public class ListInRecord {
  public static void main(String... args) {
    var listRecord = new ListRecord(new ArrayList<>(List.of("foo", "bar", "baz")));
    System.out.println(listRecord);
    listRecord.strings().addAll(List.of("bingo", "boingo"));
    System.out.println(listRecord);

    // List.of() creates an immutable List:
    var listRecord2 = new ListRecord(List.of("bongo", "oingo"));
    System.out.println(listRecord2);
    // listRecord2.strings().add("boingo"); // Runtime exception
    // listRecord2.strings().set(0, "boingo"); // Runtime exception

    var arrayRecord = new ArrayRecord(new String[]{"foo", "bar", "baz"});
    System.out.println(arrayRecord);
    arrayRecord.strings()[1] = "boingo";
    System.out.println(arrayRecord);
  }
}
/*
ListRecord[strings=[foo, bar, baz]]
ListRecord[strings=[foo, bar, baz, bingo, boingo]]
ListRecord[strings=[bongo, oingo]]
ArrayRecord[strings=[foo, bar, baz]]
ArrayRecord[strings=[foo, boingo, baz]]
*/