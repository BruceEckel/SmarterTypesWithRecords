// Example 4: People.java
package example4;
import util.Check;
import static util.Show.show;

record FullName(String name) {
  FullName {
    show("Checking FullName " + name);
    Check.valid(name.split(" ").length > 1,
        name + " needs at least first and last names");
  }
}

record BirthDate(String dob) {
  BirthDate {
    show("TODO: Check BirthDate " + dob);
  }
}

record EmailAddress(String address) {
  EmailAddress {
    show("TODO: Check EmailAddress " + address);
  }
}

record Person(FullName name,
              BirthDate dateOfBirth,
              EmailAddress email) {
  Person {
    show("TODO: Check Person ");
  }
}

public class People {
  public static void main(String[] args) {
    var person = new Person(
        new FullName("Bruce Eckel"),
        new BirthDate("7/8/1957"),
        new EmailAddress("mindviewinc@gmail.com")
    );
  }
}
