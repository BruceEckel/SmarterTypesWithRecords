// example4/People.java
// Composing records using records
package example4;
import util.Check;
import static util.Show.show;

record FullName(String name) {
  FullName {
    show("Checking FullName " + name);
    Check.valid(name.split(" ").length > 1,
      name + " needs first and last names");
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
    show("TODO: Check Person");
  }
}

public class People {
  public static void main(String[] args) {
    var person = new Person(
      new FullName("Bruce Eckel"),
      new BirthDate("7/8/1957"),
      new EmailAddress("mindviewinc@gmail.com")
    );
    show(person);
  }
}
/*
Checking FullName Bruce Eckel
TODO: Check BirthDate 7/8/1957
TODO: Check EmailAddress mindviewinc@gmail.com
TODO: Check Person
Person[
  name=FullName[name=Bruce Eckel],
  dateOfBirth=BirthDate[dob=7/8/1957],
  email=EmailAddress[address=mindviewinc@gmail.com]
]
*/